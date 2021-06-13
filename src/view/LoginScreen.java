package view;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends Screen {

    private JLabel loginTitleLabel = new JLabel(new ImageIcon("images/loginTitle.png"));
    private JTextField emailField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JCheckBox showPassword;
    private JButton registerButton = new JButton("REGISTER");
    private JButton loginButton = new JButton("LOGIN");
    private JLabel emailLabel = new JLabel("Email");
    private JLabel passwordLabel = new JLabel("Password");

    public static final Font FONT = new Font("Tahoma", Font.PLAIN, 16);

    public LoginScreen() {

        // Disable back buttons on login screen
        getBackButton().setVisible(false);
        getBackToHomeButton().setVisible(false);

        // Background colour
        setBackground(new Color(102, 153, 204));

        // Title
        loginTitleLabel.setBounds(0, 0, 1600, 900);
        add(loginTitleLabel);

        // Email field
        emailField.setForeground(Color.GRAY);
        emailField.setBounds(525, 340, 540, 50);
        add(emailField);
        emailField.setColumns(10);

        // Password Field
        passwordField.setForeground(Color.GRAY);
        passwordField.setBounds(525, 440, 540, 50);
        add(passwordField);
        passwordField.setColumns(10);

        // Email Label
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(FONT);
        emailLabel.setBounds(525, 315, 92, 17);
        add(emailLabel);

        // Password Label
        passwordLabel.setFont(FONT);
        passwordLabel.setForeground(new Color(255, 255, 255));
        passwordLabel.setBounds(525, 415, 80, 17);
        add(passwordLabel);

        // Show password checkbox
        showPassword = new JCheckBox("Show Password");
        showPassword.setForeground(Color.WHITE);
        showPassword.setBackground(new Color( 102, 153, 204));
        showPassword.setBounds(525, 500, 139, 23);
        add(showPassword);

        // Login button
        loginButton.setBackground(new Color(48, 114, 163));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        loginButton.setBorder(null);
        loginButton.setBounds(605, 540, 150, 40);
        add(loginButton);

        // Register button
        registerButton.setBackground(new Color(204, 204, 204));
        registerButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        registerButton.setBorder(null);
        registerButton.setBounds(835, 540, 150, 40);
        add(registerButton);

    }

    public JTextField getEmailField() { return emailField; }

    public JPasswordField getPasswordField() { return passwordField; }

    public JButton getLoginButton() { return loginButton; }

    public JButton getRegisterButton() { return registerButton; }

    public JCheckBox getShowPassword() { return showPassword; }
}
