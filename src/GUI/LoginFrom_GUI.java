package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import Backend.My_JDBC;
import GUI.Constants.CommonConstants;

public class LoginFrom_GUI extends From {

    public LoginFrom_GUI() {
        super("Login...");
        addGuiComponents();

    }

    public void addGuiComponents() {

        /* Create a Login label */
        JLabel loginLabel = new JLabel("Login");

        ImageIcon image1 = new ImageIcon("src\\Media\\logo1.png"); // create an image
        this.setIconImage(image1.getImage());// change icon of frame

        // configure components x, y position and width/height valuesrRelatively
        loginLabel.setBounds(0, 20, 520, 195);
        // change the font color
        loginLabel.setForeground(CommonConstants.TEXT_COLOR);
        // chane the font size
        loginLabel.setFont(new Font("Agency FB", Font.BOLD, 72));
        // center text
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // CREATE A USERNAME LABEL
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(30, 120, 400, 250);
        usernameLabel.setForeground(CommonConstants.TEXT_COLOR);
        usernameLabel.setFont(new Font("Dialog", Font.BOLD, 30));
        usernameLabel.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

        // panel.add(usernameLabel);

        /* CREATE A USERNAME TEXT_FIELD */
        JTextField userfield = new JTextField("Enter Username...");
        userfield.setBounds(30, 280, 450, 55);
        userfield.setBackground(CommonConstants.SECONDARY_COLOR);
        userfield.setBorder(BorderFactory.createEmptyBorder());
        userfield.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                userfield.setBackground(new Color(33, 14, 103));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                userfield.setBackground(CommonConstants.SECONDARY_COLOR);
            }

        });
        userfield.setForeground(new Color(0xF0F0F0));
        userfield.setFont(new Font("Dialog", Font.PLAIN, 18));

        // Add Placeholder - (1)
        userfield.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event) {
                if (userfield.getText().equals("Enter Username...")) {
                    userfield.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (userfield.getText().equals("")) {
                    userfield.setText("Enter Username...");
                }
            }

        });

        /* CREATE A PASSWORD */
        JLabel passworldLabel = new JLabel("Password");
        passworldLabel.setBounds(30, 290, 400, 250);
        passworldLabel.setForeground(CommonConstants.TEXT_COLOR);
        passworldLabel.setFont(new Font("Dialog", Font.BOLD, 30));

        /* CREATE A PASSWORD TEXT_FIELD */
        JPasswordField passwordfield = new JPasswordField();
        passwordfield.setBounds(30, 445, 450, 55);
        passwordfield.setBackground(CommonConstants.SECONDARY_COLOR);
        passwordfield.setForeground(new Color(0xF0F0F0));
        passwordfield.setFont(new Font("Dialog", Font.PLAIN, 18));
        passwordfield.setBorder(BorderFactory.createEmptyBorder());
        passwordfield.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                passwordfield.setBackground(new Color(33, 14, 103));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                passwordfield.setBackground(CommonConstants.SECONDARY_COLOR);
            }

        });

        passwordfield.setEchoChar((char) 0);

        // Add Placeholder - (2)
        passwordfield.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event) {
                if (String.valueOf(passwordfield.getPassword()).equals("Enter Password...")) {
                    passwordfield.setText("");
                    passwordfield.setEchoChar('*');
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordfield.getPassword().length < 1) {
                    passwordfield.setText("Enter Password...");
                    passwordfield.setEchoChar((char) 0);
                }
            }

        });

        /* CREATE LOGIN A BUTTON */
        JButton Loginbutton = new JButton("Login");
        Loginbutton.setFont(new Font("Dialog", Font.BOLD, 30));
        Loginbutton.setBounds(147, 600, 220, 47);
        Loginbutton.setForeground(new Color(0xF0F0F0));
        Loginbutton.setBackground(CommonConstants.TEXT_COLOR);
        Loginbutton.setBorder(BorderFactory.createLoweredBevelBorder());
        Loginbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        /* ADD Login credentials validation */
        Loginbutton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                Loginbutton.setBorder(BorderFactory.createRaisedBevelBorder());
                Loginbutton.setFont(new Font("Dialog", Font.BOLD, 40));
                Loginbutton.setBounds(127, 595, 262, 62);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Loginbutton.setBorder(BorderFactory.createLoweredBevelBorder());
                Loginbutton.setFont(new Font("Dialog", Font.BOLD, 30));
                Loginbutton.setBounds(147, 600, 220, 47);
                ;
            }

        });
        Loginbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // we will first retrive the username and password from our user
                // get username
                String username = userfield.getText();

                // get password
                String password = new String(passwordfield.getPassword());

                // check database if the username and password combo is valid or not
                if (My_JDBC.validatelogin(username, password)) {
                    if (My_JDBC.register(username, password)) {
                        // dispose the GUI
                        LoginFrom_GUI.this.dispose();

                    }
                    // login succesfull
                    JOptionPane.showMessageDialog(LoginFrom_GUI.this, "Login Succesful...");

                    // dispose the GUI
                    LoginFrom_GUI.this.dispose();
                    // take user go to the UI
                    new FinalUI();

                } else {
                    // take user back to the Register Gui
                    RegisterForm_GUI registerForm_GUI = new RegisterForm_GUI();
                    registerForm_GUI.setVisible(true);
                    // login failed
                    JOptionPane.showMessageDialog(LoginFrom_GUI.this,
                            "         " + "Login Failed..." + "\n" + "             " + "Register now", "",
                            JOptionPane.ERROR_MESSAGE);

                }
            }

        });

        /* CREATE A REGISTER LABEL(Which is used to load the Register GUI) */
        JLabel registerLabel = new JLabel("Not a User? Register here...");
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setBounds(130, 655, 260, 30);
        registerLabel.setFont(new Font("Dialog", Font.BOLD, 19));
        registerLabel.setForeground(CommonConstants.TEXT_COLOR);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        registerLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                registerLabel.setForeground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                registerLabel.setForeground(CommonConstants.TEXT_COLOR);
            }

        });
        // Add Functionality So, that when clicked it will launch the Register from GUI
        registerLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // dispose login GUI
                LoginFrom_GUI.this.dispose();
                // Launch the Register GUI
                new RegisterForm_GUI().setVisible(true);
            }

        });

        // Add compomemts
        add(loginLabel);
        add(usernameLabel);
        add(userfield);
        add(passwordfield);
        add(passworldLabel);
        add(Loginbutton);
        add(registerLabel);

    }

}
