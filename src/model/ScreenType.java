package model;

public enum ScreenType {

    // Values for each screen
    LOGIN_SCREEN(0),
    REGISTER_SCREEN(1),
    HOME_SCREEN(2),
    BOOKING_SCREEN(3),
    VIEW_APPOINTMENTS_SCREEN(4),
    PROFILE_SCREEN(5);

    private int value; // Value of screen

    // Constructor
    ScreenType(int value) { this.value = value; }

    // Getter
    public int getValue() { return value; }

}
