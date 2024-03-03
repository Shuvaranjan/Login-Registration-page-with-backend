package GUI;

import java.awt.Color;

import javax.swing.JFrame;

//import GUI.Constants.CommonConstants;

public class From extends JFrame {
    // create a constructor
    public From(String title) {
        // set the title of the JFrame bar
        super(title);

        // set the size of GUI
        setSize(530, 750);

        setResizable(false);

        // configure GUI to end process after closing
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set layout to null to disable layout management
        // to place the components whatever we want
        setLayout(null);

        // login GUI in the center of the screen
        setLocationRelativeTo(null);

        // create the background of GUI
        getContentPane().setBackground(new Color(20, 20, 20));

    }

}
