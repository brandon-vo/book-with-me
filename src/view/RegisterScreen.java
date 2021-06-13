package view;

import javax.swing.*;
import java.awt.*;

public class RegisterScreen extends Screen {

    // Fields
    private JLabel registerTitleLabel = new JLabel(new ImageIcon("images/registerTitle.png"));
    private JTextField firstNameField = new JTextField();
    private JTextField lastNameField = new JTextField();
    private JTextField emailField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JPasswordField confirmPasswordField = new JPasswordField();
    private JTextField phoneNumberField = new JTextField();

    private JLabel firstNameLabel = new JLabel("First Name");
    private JLabel lastNameLabel = new JLabel("Last Name");
    private JLabel emailLabel = new JLabel("Email");
    private JLabel passwordLabel = new JLabel("Password");
    private JLabel confirmPasswordLabel = new JLabel("Confirm Password");
    private JLabel phoneNumberLabel = new JLabel("Phone Number");

    private JCheckBox showPassword = new JCheckBox("Show password");

    private JButton signUpButton = new JButton("SIGN UP");

    private static final Font FONT = new Font("Tahoma", Font.PLAIN, 16);
    private static final Color COLOUR = new Color(128, 128, 128);

    public RegisterScreen() {

        setBackground(new Color(211, 211, 211));

        // Title
        registerTitleLabel.setBounds(0, 0, 1600, 900);
        add(registerTitleLabel);

        // First Name Field
        firstNameField.setForeground(COLOUR);
        firstNameField.setBounds(525, 228, 254, 33);
        add(firstNameField);
        firstNameField.setColumns(10);

        // Last Name Field
        lastNameField.setForeground(COLOUR);
        lastNameField.setColumns(10);
        lastNameField.setBounds(825, 228, 249, 33);
        add(lastNameField);

        // Email Field
        emailField.setForeground(COLOUR);
        emailField.setBounds(525, 305, 550, 33);
        emailField.setColumns(10);
        add(emailField);

        // Password Field
        passwordField.setForeground(COLOUR);
        passwordField.setColumns(10);
        passwordField.setBounds(525, 379, 254, 33);
        add(passwordField);

        // Confirm Password Field
        confirmPasswordField.setForeground(COLOUR);
        confirmPasswordField.setColumns(10);
        confirmPasswordField.setBounds(825, 379, 247, 33);
        add(confirmPasswordField);

        // Phone Number Field
        phoneNumberField.setForeground(COLOUR);
        phoneNumberField.setColumns(10);
        phoneNumberField.setBounds(525, 480, 255, 33);
        add(phoneNumberField);

        // First Name Label
        firstNameLabel.setFont(FONT);
        firstNameLabel.setBounds(525, 197, 100, 20);
        add(firstNameLabel);

        // Last name label
        lastNameLabel.setFont(FONT);
        lastNameLabel.setBounds(825, 197, 100, 20);
        add(lastNameLabel);

        // Email label
        emailLabel.setFont(FONT);
        emailLabel.setBounds(525, 280, 127, 14);
        add(emailLabel);

        // Password label
        passwordLabel.setFont(FONT);
        passwordLabel.setBounds(525, 356, 101, 14);
        add(passwordLabel);

        // Confirm password label
        confirmPasswordLabel.setFont(FONT);
        confirmPasswordLabel.setBounds(825, 355, 153, 14);
        add(confirmPasswordLabel);

        // Phone number label
        phoneNumberLabel.setFont(FONT);
        phoneNumberLabel.setBounds(525, 455, 114, 14);
        add(phoneNumberLabel);

        // Show password checkbox
        showPassword.setBackground(new Color(211, 211, 211));
        showPassword.setBounds(525, 415, 129, 23);
        add(showPassword);

        // Sign up button
        signUpButton.setBackground(new Color(100, 149, 237));
        signUpButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        signUpButton.setBounds(690, 550, 210, 50);
        add(signUpButton);
    }

    public JTextField getFirstNameField() { return firstNameField; }

    public JTextField getLastNameField() { return lastNameField; }

    public JTextField getEmailField() { return emailField; }

    public JTextField getPhoneNumberField() { return phoneNumberField; }

    public JPasswordField getPasswordField() { return passwordField; }

    public JPasswordField getConfirmPasswordField() { return confirmPasswordField; }

    public JCheckBox getShowPassword() { return showPassword; }

    public JButton getSignUpButton() { return signUpButton; }
}
