package view;

import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.util.Date;

public abstract class Screen extends JPanel {

    // Fields
    private JButton backButton;
    private JButton backToHomeButton;
    private JCalendar calendar = new JCalendar();
    private Date today = new Date();

    public Screen() {

        setLayout(null); // Absolute positioning
        setBounds(0, 0, DefaultScreen.WIDTH, DefaultScreen.HEIGHT); // Screen size

        // Create back buttons
        ImageIcon backImage = new ImageIcon("images/backButton.png");
        backButton = new JButton(backImage);
        backButton.setBounds(1540,20, backImage.getIconWidth(), backImage.getIconHeight());
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        add(backButton);

        backToHomeButton = new JButton(backImage);
        backToHomeButton.setBounds(1540,20, backImage.getIconWidth(), backImage.getIconHeight());
        backToHomeButton.setContentAreaFilled(false);
        backToHomeButton.setBorderPainted(false);
        add(backToHomeButton);

    }

    // Create JCalendar
    public void enableCalendar() {
        calendar.setBounds(1075, 260, 400, 350);
        calendar.setMinSelectableDate(today);
        add(calendar);

    }

    public JButton getBackButton() { return backButton; }

    public JButton getBackToHomeButton() { return backToHomeButton; }

    public JCalendar getCalendar() { return calendar; }
}
