package view;

import javax.swing.*;
import java.awt.*;

public class DefaultScreen extends JFrame {

    // Screen Size Fields
    public static final int WIDTH = 1600;
    public static final int HEIGHT = 900;

    public DefaultScreen() {

        // Setup screen
        setTitle("Barber Booker - Brandon Vo");
        setSize(WIDTH, HEIGHT);
        getContentPane().setBackground(new Color(102, 153, 204));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

    }
}
