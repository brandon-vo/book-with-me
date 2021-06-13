package controller;

import model.Account;
import model.Appointment;
import model.ScreenType;
import view.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;

public class ApplicationController {

    private static DefaultScreen defaultScreen; // Access DefaultScreen

    public static Screen[] screens = new Screen[ScreenType.values().length]; // All screens
    public static LoginController loginController; // Access LoginController
    public static HomeController homeController; // Access HomeController
    public static BookingController bookingController; // Access BookingController
    public static ProfileController profileController; // Access ProfileController

    public static String currentEmail; // Logged in users email
    public static String currentFirstName; // Logged in users first name
    public static String currentLastName; // Logged in users last name
    public static String currentPhoneNumber; // Logged in users phone number
    public static String currentID; // Logged in users ID

    public static AccountController accountImport = new AccountController(); // Import accounts
    public static AppointmentController appointmentImport = new AppointmentController(); // Import appointments

    public static ArrayList<Account> accounts = new ArrayList(); // Store accounts into ArrayList
    public static ArrayList<Appointment> appointments = new ArrayList(); // Store appointments into ArrayList
    public static ArrayList<Appointment> currentAppointments = new ArrayList(); // Store appointments for current user

    public static DefaultListModel<Appointment> appointmentListModel = new DefaultListModel<>();

    public ApplicationController() {

        // Import account data
        accountImport.importAccounts("accounts/registration.txt");

        // Create default screen object
        defaultScreen = new DefaultScreen();

        // Create all screens
        screens[ScreenType.LOGIN_SCREEN.getValue()] = new LoginScreen();
        screens[ScreenType.REGISTER_SCREEN.getValue()] = new RegisterScreen();
        screens[ScreenType.HOME_SCREEN.getValue()] = new HomeScreen();
        screens[ScreenType.BOOKING_SCREEN.getValue()] = new BookingScreen();
        screens[ScreenType.VIEW_APPOINTMENTS_SCREEN.getValue()] = new ViewAppointmentsScreen();
        screens[ScreenType.PROFILE_SCREEN.getValue()] = new ProfileScreen();

        // Create controllers
        loginController = new LoginController((LoginScreen) screens[ScreenType.LOGIN_SCREEN.getValue()]);
        new RegisterController((RegisterScreen) screens[ScreenType.REGISTER_SCREEN.getValue()]);
        homeController = new HomeController((HomeScreen) screens[ScreenType.HOME_SCREEN.getValue()]);
        bookingController = new BookingController((BookingScreen) screens[ScreenType.BOOKING_SCREEN.getValue()]);
        profileController = new ProfileController((ProfileScreen) screens[ScreenType.PROFILE_SCREEN.getValue()]);

        // Setup back buttons
        setupBackButton();

        // Login screen set to initial screen
        defaultScreen.add(screens[ScreenType.LOGIN_SCREEN.getValue()]);
        defaultScreen.setVisible(true);

        System.out.println("Start Application");

    }

    // Setting up back buttons
    public void setupBackButton() {
        for (int x = 0; x < ScreenType.values().length; x++) {
            // Switching to login screen
            screens[x].getBackButton().addActionListener(e ->
                    switchScreen(screens[ScreenType.LOGIN_SCREEN.getValue()])
            );
            // Switching to home screen
            screens[x].getBackToHomeButton().addActionListener(e ->
                    switchScreen(screens[ScreenType.HOME_SCREEN.getValue()])
            );
        }
    }

    // Method to switch screens
    public static void switchScreen(JPanel newScreen) {
        defaultScreen.getContentPane().removeAll();
        defaultScreen.getContentPane().repaint();
        defaultScreen.getContentPane().add(newScreen);
    }
}
