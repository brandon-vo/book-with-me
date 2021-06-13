package controller;

import model.ScreenType;
import view.HomeScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeController implements ActionListener {

    private HomeScreen homeScreen; // Access home screen

    // Constructor
    public HomeController(HomeScreen homeScreen) {
        this.homeScreen = homeScreen;
        setupListeners();
    }

    // Welcome label with accounts first name
    public void setupLabel() {
        homeScreen.getWelcomeLabel().setText("Welcome, " + ApplicationController.currentFirstName);
    }

    // Set up listeners
    public void setupListeners() {
        homeScreen.getAppointmentButton().addActionListener(this);
        homeScreen.getViewAppointmentButton().addActionListener(this);
        homeScreen.getProfileButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeScreen.getAppointmentButton()) { // Book appointment button
            ApplicationController.switchScreen // Switch to booking screen
                    (ApplicationController.screens[ScreenType.BOOKING_SCREEN.getValue()]);
            ApplicationController.bookingController.bookingScreen.enableCalendar(); // Enable calendar
        } else if (e.getSource() == homeScreen.getViewAppointmentButton()) { // View appointments button
            ApplicationController.switchScreen // Switch to view appointments screen
                    (ApplicationController.screens[ScreenType.VIEW_APPOINTMENTS_SCREEN.getValue()]);
            ApplicationController.appointmentListModel.clear(); // Clear initial list
            ApplicationController.appointmentListModel.addAll
                    (ApplicationController.currentAppointments); // Add appointments to list
        } else if (e.getSource() == homeScreen.getProfileButton()) // Profile button
            ApplicationController.switchScreen // Switch to profile screen
                    (ApplicationController.screens[ScreenType.PROFILE_SCREEN.getValue()]);
    }
}
