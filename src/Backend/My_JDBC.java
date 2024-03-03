package Backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import GUI.Constants.CommonConstants;

public class My_JDBC {
    // All backend codes

    // we will first start with registering new users to our Database
    public static boolean register(String username, String password) {

        // first check if the username alredy exists in the DB(database)
        // we will make a seprate method to check if the user already exists
        try {
            // the logic is that we will only register if the user does't found in the DB
            if (!checkUser(username)) {
                // connection to the DB
                Connection connection = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME,CommonConstants.DB_PASSWORD);

                // create insert Querry
                PreparedStatement insertUser = connection.prepareStatement(
                        "INSERT INTO " + CommonConstants.DB_USER_TABLE + "(username, password)" + "VALUES (?, ?)");

                insertUser.setString(1, username);
                insertUser.setString(2, password);

                // update DB with new user
                insertUser.executeUpdate();

                return true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // check if username already exists in the DB
    // false - user does't exists in the DB
    // true - user exists in the DB
    public static boolean checkUser(String username) {
        try {
            // JDBC SERVER CONNECT
            Connection connection = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME,CommonConstants.DB_PASSWORD);

            PreparedStatement checkUserExist = connection.prepareStatement(
                    "SELECT * FROM " + CommonConstants.DB_USER_TABLE + " WHERE USERNAME = ?");
            // we will replace the "?" with values using the setString()
            checkUserExist.setString(1, username);

            // then we will store our Result in a resultSet which will be able to access
            ResultSet resultSet = checkUserExist.executeQuery();

            // check to see if the resultSet is empty
            // if it is empty it means that there was no data roe that contains the username
            // (Ex - user does't exists)
            // we use the isBeforeFirst() to point the first row of data that is returned to
            // our resultSet
            if (!resultSet.isBeforeFirst()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // if the user does't exists in DB
        return true;
    }

    // validate user login
    // validate login credintials by checking to see if username/passwords pair
    // exists in the DB

    public static boolean validatelogin(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME,CommonConstants.DB_PASSWORD);

            // create select Querry
            PreparedStatement validateUser = connection.prepareStatement(
                "SELECT * FROM " + CommonConstants.DB_USER_TABLE + " WHERE USERNAME = ? AND PASSWORD = ?"
            );
            validateUser.setString(1, username);
             validateUser.setString(2, password);

             ResultSet resultSet = validateUser.executeQuery();

             //isBeforeFirst() is used here to see if your queryy returned any rows that matched our querry
             if (!resultSet.isBeforeFirst()) {
                return false;
                
             }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // if it is true it means that there was a username/password pair that match the user input
        return true;
    }
}
