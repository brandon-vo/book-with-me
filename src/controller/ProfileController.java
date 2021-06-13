package controller;

import view.ProfileScreen;

public class ProfileController {

    private ProfileScreen profileScreen; // Access ProfileScreen

    // Constructor
    public ProfileController(ProfileScreen profileScreen) {
        this.profileScreen = profileScreen;
    }

    // Profile labels with user data
    public void setupLabel() {
        profileScreen.getNameLabel().setText("Name: " + ApplicationController.currentFirstName +
                " " + ApplicationController.currentLastName);
        profileScreen.getEmailLabel().setText("Email: " + ApplicationController.currentEmail);
        profileScreen.getPhoneNumberLabel().setText("Phone Number: " + ApplicationController.currentPhoneNumber);
    }
}
