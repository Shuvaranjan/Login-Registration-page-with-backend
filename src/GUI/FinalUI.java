package GUI;

import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class FinalUI {
    public FinalUI() throws HeadlessException {

        try {
            Desktop.getDesktop().browse(new URI("https://www.youtube.com/"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

    }

}
