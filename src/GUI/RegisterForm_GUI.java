package GUI;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Backend.My_JDBC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

import GUI.Constants.CommonConstants;

public class RegisterForm_GUI extends From {
    public RegisterForm_GUI() {
        super("Register...");
        addGuiComponents();

    }

    public void addGuiComponents() {
        /* Create a Login label */

        JLabel registerLabel = new JLabel("Register");

        ImageIcon image1 = new ImageIcon("Login & Registration page\\src\\Media\\logo1.png"); // create an image
        this.setIconImage(image1.getImage());// change icon of frame

        // configure components x, y position and width/height valuesrRelatively
        registerLabel.setBounds(0, 17, 520, 190);
        // change the font color
        registerLabel.setForeground(CommonConstants.TEXT_COLOR);
        // change the font size
        registerLabel.setFont(new Font("Agency FB", Font.BOLD, 65));
        // center text
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // CREATE A USERNAME LABEL
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(30, 150, 400, 100);
        usernameLabel.setForeground(CommonConstants.TEXT_COLOR);
        usernameLabel.setFont(new Font("Dialog", Font.BOLD, 30));
        usernameLabel.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

        /* CREATE A USERNAME TEXT_FIELD */
        JTextField userField = new JTextField("Enter Username...");
        userField.setBounds(30, 228, 450, 55);
        userField.setBackground(CommonConstants.SECONDARY_COLOR);
        userField.setForeground(new Color(255, 255, 255));
        userField.setFont(new Font("Dialog", Font.PLAIN, 18));
        userField.setBorder(BorderFactory.createEmptyBorder());
        userField.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                userField.setBackground(new Color(33, 14, 103));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                userField.setBackground(CommonConstants.SECONDARY_COLOR);
            }

        });

        // Add Placeholder - (1)
        userField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event) {
                if (userField.getText().equals("Enter Username...")) {
                    userField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (userField.getText().equals("")) {
                    userField.setText("Enter Username...");
                }
            }

        });

        /* CREATE A PASSWORD */
        JLabel passworldLabel = new JLabel("Password");
        passworldLabel.setBounds(30, 198, 400, 250);
        passworldLabel.setForeground(CommonConstants.TEXT_COLOR);
        passworldLabel.setFont(new Font("Dialog", Font.BOLD, 30));
        passworldLabel.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

        // CREATE A RE-ENTER PASSWORD
        JLabel reEnterpassword = new JLabel("Re-Enter Password");
        reEnterpassword.setBounds(30, 335, 400, 250);
        reEnterpassword.setForeground(CommonConstants.TEXT_COLOR);
        reEnterpassword.setFont(new Font("Dialog", Font.BOLD, 30));
        reEnterpassword.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

        /* CREATE A PASSWORD TEXT_FIELD */
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(30, 349, 450, 55);
        passwordField.setBackground(CommonConstants.SECONDARY_COLOR);
        passwordField.setForeground(new Color(0xF0F0F0));
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 18));
        passwordField.setBorder(BorderFactory.createEmptyBorder());

        passwordField.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                passwordField.setBackground(new Color(33, 14, 103));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                passwordField.setBackground(CommonConstants.SECONDARY_COLOR);
            }

        });

        // Add Placeholder - (2)
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event) {
                if (String.valueOf(passwordField.getPassword()).equals("Enter Password...")) {
                    passwordField.setText("");
                    passwordField.setEchoChar('*');
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getPassword().length < 1) {
                    passwordField.setText("Enter Password...");
                    passwordField.setEchoChar((char) 0);
                }
            }

        });

        // CREATE A RE-ENTER PASSWORD TEXT-FIELD
        JPasswordField reEnterPasswordfField = new JPasswordField();
        reEnterPasswordfField.setBounds(30, 485, 450, 55);
        reEnterPasswordfField.setBackground(CommonConstants.SECONDARY_COLOR);
        reEnterPasswordfField.setForeground(new Color(0xF0F0F0));
        reEnterPasswordfField.setFont(new Font("Dialog", Font.PLAIN, 18));
        reEnterPasswordfField.setBorder(BorderFactory.createEmptyBorder());
        reEnterPasswordfField.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                reEnterPasswordfField.setBackground(new Color(33, 14, 103));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                reEnterPasswordfField.setBackground(CommonConstants.SECONDARY_COLOR);
            }

        });

        // Add Placeholder - (3)
        reEnterPasswordfField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event) {
                if (String.valueOf(reEnterPasswordfField.getPassword()).equals("Enter Password...")) {
                    reEnterPasswordfField.setText("");
                    reEnterPasswordfField.setEchoChar('*');
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (reEnterPasswordfField.getPassword().length < 1) {
                    reEnterPasswordfField.setText("Enter Password...");
                    reEnterPasswordfField.setEchoChar((char) 0);
                }
            }

        });

        /* CREATE A REGISTER BUTTON */
        JButton registerbutton = new JButton("Register");
        registerbutton.setFont(new Font("Dialog", Font.BOLD, 30));
        registerbutton.setBounds(147, 600, 220, 47);
        registerbutton.setForeground(new Color(0xF0F0F0));
        registerbutton.setBackground(CommonConstants.TEXT_COLOR);
        registerbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerbutton.setBorder(BorderFactory.createLoweredBevelBorder());
        registerbutton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                registerbutton.setBounds(127, 595, 262, 62);
                registerbutton.setBorder(BorderFactory.createRaisedBevelBorder());
                registerbutton.setFont(new Font("Dialog", Font.BOLD, 40));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                registerbutton.setBounds(147, 600, 220, 47);
                registerbutton.setBorder(BorderFactory.createLoweredBevelBorder());
                registerbutton.setFont(new Font("Dialog", Font.BOLD, 30));
            }

        });
        /* BACKEND code goes here */
        registerbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // get the username
                String username = userField.getText();

                // get password
                String password = new String(passwordField.getPassword());

                // get re-Enter password
                String rePassword = new String(passwordField.getPassword());

                // validate user input
                if (validateUserInput(username, password, rePassword)) {
                    // register the user to the DB
                    if (My_JDBC.register(username, rePassword)) {
                        // dispose of this GUI
                        RegisterForm_GUI.this.dispose();

                        // take user back to the Login Gui
                        LoginFrom_GUI loginFrom_GUI = new LoginFrom_GUI();
                        loginFrom_GUI.setVisible(true);

                        // Create a Result dialogue box
                        JOptionPane.showMessageDialog(loginFrom_GUI, "Register Account Succesfull !");

                    } else {
                        // register failed(likely due to the user already exists in the DB)
                        JOptionPane.showMessageDialog(RegisterForm_GUI.this, "Error: Username had already taken");

                    }
                } else {
                    // Invalid user input
                    JOptionPane.showMessageDialog(RegisterForm_GUI.this,
                            "Error: Username must be 6 characters Long \n or password must match", "",
                            JOptionPane.WARNING_MESSAGE);

                }
            }

        });

        /* CREATE A LOGIN LABEL(Which is used to load the Register GUI) */

        JLabel loginLabel = new JLabel("Already have account? Login here...");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setBounds(88, 660, 330, 30);
        loginLabel.setFont(new Font("Dialog", Font.BOLD, 19));
        loginLabel.setForeground(CommonConstants.TEXT_COLOR);
        loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                loginLabel.setForeground(Color.CYAN);
            }

            public void mouseExited(MouseEvent e) {
                loginLabel.setForeground(CommonConstants.TEXT_COLOR);
            }
        });

        // Add Functionality So, that when clicked it will launch the Register from GUI
        loginLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // dispose login GUI
                RegisterForm_GUI.this.dispose();
                // Launch the Register GUI
                new LoginFrom_GUI().setVisible(true);
            }

        });

        // add compomemts
        add(loginLabel);
        add(registerLabel);
        add(usernameLabel);
        add(userField);
        add(passworldLabel);
        add(reEnterpassword);
        add(passwordField);
        add(reEnterPasswordfField);
        add(registerbutton);

    }

    // so here we are going to validate our user input, making sure that user has
    // placed a valid username and password
    private boolean validateUserInput(String username, String password, String rePassword) {
        // All fields must have a value
        if (username.length() == 0 || password.length() == 0 || rePassword.length() == 0) {
            return false;

        }

        // username has to be has atleast 6 character Long
        if (username.length() < 6) {
            return false;

        }

        // password and rePassword must be same like username
        if (!password.equals(rePassword)) {
            return false;
        }
        return true;
    }

}
