package view;

import javax.swing.*;
import java.awt.*;

public class HomeScreen extends Screen {

    private JLabel welcomeLabel = new JLabel("Welcome to Barber Booker");
    private JButton appointmentButton = new JButton("<html>Book an<br/>appointment</html>");
    private JButton viewAppointmentButton = new JButton("<html>View previous<br/>appointments</html>");
    private JButton profileButton = new JButton("Your Profile");

    private static final Font FONT = new Font("Tahoma", Font.PLAIN, 30);

    public HomeScreen() {

        getBackToHomeButton().setVisible(false);
        setBackground(new Color(113, 146, 172));

        welcomeLabel.setBounds(70, 50, 700, 100);
        welcomeLabel.setFont(new Font("Calibri", Font.BOLD, 50));
        welcomeLabel.setForeground(Color.WHITE);
        add(welcomeLabel);

        appointmentButton.setBackground(new Color(30, 75, 135));
        appointmentButton.setForeground(Color.WHITE);
        appointmentButton.setFont(FONT);
        appointmentButton.setBorder(null);
        appointmentButton.setBounds(300, 400, 250, 125);
        add(appointmentButton);

        viewAppointmentButton.setBackground(new Color(30, 75, 135));
        viewAppointmentButton.setForeground(Color.WHITE);
        viewAppointmentButton.setFont(FONT);
        viewAppointmentButton.setBorder(null);
        viewAppointmentButton.setBounds(700, 400, 250, 125);
        add(viewAppointmentButton);

        profileButton.setBackground(new Color(30, 75, 135));
        profileButton.setForeground(Color.WHITE);
        profileButton.setFont(FONT);
        profileButton.setBorder(null);
        profileButton.setBounds(1100, 400, 250, 125);
        add(profileButton);

    }

    public JLabel getWelcomeLabel() { return welcomeLabel; }

    public JButton getAppointmentButton() { return appointmentButton; }

    public JButton getViewAppointmentButton() { return viewAppointmentButton; }

    public JButton getProfileButton() { return profileButton; }
}
