package model;

public class Account {

    // Fields
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String UUID;

    // Constructor
    public Account(String firstName, String lastName, String email, String password, String phoneNumber, String UUID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.UUID = UUID;
    }

    // Getters
    public String getFirstName() { return firstName; }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUUID() { return UUID; }

    // toString method
    @Override
    public String toString() {
        return firstName + ", " + lastName + ", " + email + ", " + password + ", " + phoneNumber + ", " + UUID;
    }
}
