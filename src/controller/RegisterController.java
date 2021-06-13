package controller;

import model.ScreenType;
import view.RegisterScreen;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.UUID;

public class RegisterController implements ActionListener {

    private RegisterScreen registerScreen; // Get access to register screen

    // Constructor
    public RegisterController(RegisterScreen registerScreen) {
        this.registerScreen = registerScreen;
        setupListeners();
    }

    // Setup listeners
    public void setupListeners() {
        registerScreen.getSignUpButton().addActionListener(this);
        registerScreen.getShowPassword().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerScreen.getSignUpButton())
            createAccount();
        else if (e.getSource() == registerScreen.getShowPassword())
            showPassword();
    }

    // Write account to a text file
    private void createAccount() {
        // Fields to get input values
        String firstName = registerScreen.getFirstNameField().getText();
        String lastName = registerScreen.getLastNameField().getText();
        String email = registerScreen.getEmailField().getText().toLowerCase();
        String password = registerScreen.getPasswordField().getText();
        String cPassword = registerScreen.getConfirmPasswordField().getText();
        String phoneNumber = registerScreen.getPhoneNumberField().getText();
        String uniqueID = UUID.randomUUID().toString();

        // Check if first name and last name fields are empty
        if (firstName.length() == 0 || lastName.length() == 0) {
            JOptionPane.showMessageDialog(null, "Please fill in your name",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
            // Check if the email is less than 3 characters long and contains the @ symbol
        } else if (email.length() < 3 && !email.contains("@")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email address",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
            // Check if passwords match and if the password is atleast 8 characters long
        } else if (!password.equals(cPassword) || password.length() < 8) {
            JOptionPane.showMessageDialog(null, "Please enter a valid password",
                    "Error", JOptionPane.ERROR_MESSAGE);
            registerScreen.getPasswordField().setText(""); // Set password field to blank
            registerScreen.getConfirmPasswordField().setText(""); // Set confirm password field to blank
            return;
            // Check if phone number is less than 3 characters long
        } else if (phoneNumber.length() < 3) {
            JOptionPane.showMessageDialog(null, "Please enter a valid phone number",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {

            // Read registration text file
            Scanner input = new Scanner(new File("accounts/registration.txt"));

            // Check if an account already has the same email as inputted
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.contains(email)) {
                    JOptionPane.showMessageDialog(null, "An account with this email has already"
                                    + " been created!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Write account information to registration text file
            FileWriter Writer = new FileWriter("accounts/registration.txt", true);
            Writer.write("" + firstName + "," + lastName + "," + email + "," + password + ","
                    + phoneNumber + "," + uniqueID + ",");
            Writer.write(System.getProperty("line.separator"));
            Writer.close(); // Close writer
            ApplicationController.accountImport.importAccounts("accounts/registration.txt"); // Reload imports
            JOptionPane.showMessageDialog(null, "Hello " + firstName +
                    "! Your account has been created");

            // Switch to login screen
            ApplicationController.switchScreen(ApplicationController.screens[ScreenType.LOGIN_SCREEN.getValue()]);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e);
        }
    }

    // Show and hide password
    private void showPassword() {
        if (registerScreen.getShowPassword().isSelected()) {
            registerScreen.getPasswordField().setEchoChar((char) 0);
            registerScreen.getConfirmPasswordField().setEchoChar((char) 0);
        } else {
            registerScreen.getPasswordField().setEchoChar('•');
            registerScreen.getConfirmPasswordField().setEchoChar('•');
        }
    }
}
