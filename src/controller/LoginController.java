package controller;

import model.Account;
import model.ScreenType;
import view.LoginScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginController implements ActionListener  {

    private LoginScreen loginScreen; // Access login screen
    private String emailInput; // Get email input

    // Constructor
    public LoginController(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
        setupListeners();

    }

    // Setup listeners
    public void setupListeners() {
        loginScreen.getLoginButton().addActionListener(this);
        loginScreen.getRegisterButton().addActionListener(this);
        loginScreen.getShowPassword().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginScreen.getLoginButton()) { // User clicked login button
            loginAccount(); // Call loginAccount method
        } else if (e.getSource() == loginScreen.getRegisterButton()) { // User clicked register button
            // Switch to register screen
            ApplicationController.switchScreen(ApplicationController.screens[ScreenType.REGISTER_SCREEN.getValue()]);
        } else if (e.getSource() == loginScreen.getShowPassword()) // User checked show password box
            showPassword();
    }

    // Logging into account by reading file
    // Check if the inputted account exists and set the account information to the current account
    private void loginAccount() {
        boolean accountFound = false; // Mark when an account is logged in
        emailInput = loginScreen.getEmailField().getText().toLowerCase(); // Get email input
        String passwordInput = loginScreen.getPasswordField().getText(); // Get password input

        try {
            // Read from registration.txt file
            Scanner input = new Scanner(new File("accounts/registration.txt"));

            // Reads through the lines of the text file until an account is found
            while (input.hasNextLine() && !accountFound) {
                String str = input.nextLine();
                String[] strArray = str.split(",");

                // Check if the user input matches the registration file information
                if (emailInput.equals(strArray[2]) && passwordInput.equals(strArray[3])) {
                    accountFound = true; // Found account login

                    // Switch to home screen
                    ApplicationController.switchScreen(ApplicationController.screens[ScreenType.HOME_SCREEN.getValue()]);

                    ApplicationController.currentAppointments.clear(); // Clear current appointments
                    ApplicationController.appointments.clear(); // Clear appointments

                    // Search through all accounts in the Arraylist
                    for (int index = 0; index < ApplicationController.accounts.size()-1; index++) {
                        Account account = ApplicationController.accounts.get(index);

                        // Set the account information to the logged in account
                        if (account.toString().contains(emailInput)) {
                            ApplicationController.currentFirstName = account.getFirstName();
                            ApplicationController.currentLastName = account.getLastName();
                            ApplicationController.currentEmail = account.getEmail();
                            ApplicationController.currentPhoneNumber = account.getPhoneNumber();
                            ApplicationController.currentID = account.getUUID();
                            ApplicationController.homeController.setupLabel();
                            ApplicationController.profileController.setupLabel();
                        }
                    }

                    // Reload imports
                    ApplicationController.appointmentImport.importAppointments("accounts/appointments.txt");

                    // Show login prompt
                    JOptionPane.showMessageDialog(null, "Login successful",
                            "Welcome", JOptionPane.INFORMATION_MESSAGE);

                    // Otherwise, the users input does not match an email and password
                } else {
                    loginScreen.getPasswordField().setText("");
                    accountFound = false;
                }
            }

            // Show error message if an account is not found
            if (accountFound == false) {
                JOptionPane.showMessageDialog(null, "Invalid login" +
                                " \nPlease check your email and password", "Error", JOptionPane.ERROR_MESSAGE);
                input.close(); // Close input
            }

        } catch (FileNotFoundException e) {
            System.err.println("An error occurred: " + e);
        }
    }

    // Show and hide password
    private void showPassword() {
        if (loginScreen.getShowPassword().isSelected())
            loginScreen.getPasswordField().setEchoChar((char) 0);
        else
            loginScreen.getPasswordField().setEchoChar('•');
    }
}
