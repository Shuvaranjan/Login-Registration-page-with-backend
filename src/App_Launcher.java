import javax.swing.SwingUtilities;

import GUI.LoginFrom_GUI;

public class App_Launcher {
    public static void main(String[] args) {
        // We use invokeLetter() to make updates GUI more thread safe and efficient
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // instance of login from GUI
                new LoginFrom_GUI().setVisible(true);

            }

        });
    }
}
