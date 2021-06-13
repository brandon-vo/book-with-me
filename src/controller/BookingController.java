package controller;

import model.ScreenType;
import view.BookingScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookingController implements ActionListener {

    public BookingScreen bookingScreen; // Access booking screen

    // Fields to get time and cost
    private int timeMin; // Minutes
    private int timeMax; // Minutes
    private double costMin = 20; // Dollars
    private double costMax = 20; // Dollars

    // Constructor
    public BookingController(BookingScreen bookingScreen) {
        this.bookingScreen = bookingScreen;
        setupListeners();
    }

    // Set up Listeners
    private void setupListeners() {
        bookingScreen.getBuzzCutCheckBox().addActionListener(this);
        bookingScreen.getFadeButton().addActionListener(this);
        bookingScreen.getTaperButton().addActionListener(this);
        bookingScreen.getHaircutSelect().addActionListener(this);
        bookingScreen.getSkinFadeCheckBox().addActionListener(this);
        bookingScreen.getSideOneSelect().addActionListener(this);
        bookingScreen.getSideTwoSelect().addActionListener(this);
        bookingScreen.getBookNowButton().addActionListener(this);
        bookingScreen.getHaircutSelect().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Check top style selection
        if (bookingScreen.getBuzzCutCheckBox().isSelected())
            bookingScreen.getTopLengthSlider().setEnabled(false);
        else if (!bookingScreen.getBuzzCutCheckBox().isSelected())
            bookingScreen.getTopLengthSlider().setEnabled(true);

        // Check side style selection
        if (bookingScreen.getFadeButton().isSelected()) {
            changeHaircutSelection(1);
            bookingScreen.getSideOneSelect().setEnabled(true);
            bookingScreen.getSideTwoSelect().setEnabled(true);
            bookingScreen.enableCalendar();
        } else if (bookingScreen.getTaperButton().isSelected()) {
            changeHaircutSelection(2);
            bookingScreen.getSideOneSelect().setEnabled(true);
            bookingScreen.getSideTwoSelect().setEnabled(true);
            bookingScreen.enableCalendar();
        } else if (!bookingScreen.getTaperButton().isSelected() && !bookingScreen.getFadeButton().isSelected()){
            changeHaircutSelection(0);
        }

        // Check if skin fade is selected
        if (bookingScreen.getSkinFadeCheckBox().isSelected()) {
            bookingScreen.getSideOneSelect().setEnabled(false);
            bookingScreen.getSideTwoSelect().setEnabled(false);
        } else if (!bookingScreen.getSkinFadeCheckBox().isSelected()
                && !bookingScreen.getSkinFadeCheckBox().isEnabled()) {
            bookingScreen.getSideOneSelect().setEnabled(true);
            bookingScreen.getSideTwoSelect().setEnabled(true);
        }

        // Book now button
        if (e.getSource() == bookingScreen.getBookNowButton())
            checkInputs();
    }

    // Method for haircut dropdown options
    private void changeHaircutSelection(int type) {
        bookingScreen.getHaircutSelect().setEnabled(true); // Allow user to select haircut
        bookingScreen.getSkinFadeCheckBox().setEnabled(true); // Allow user to choose skin fade or taper
        List<String> sideOptions = new ArrayList<>();

         if (type == 1) { // User selected fade
            if (!bookingScreen.getHaircutSelect().getItemAt(0).toString().contains("Fade")) {
                String [] optionList = new String[] {"- Select Fade-", "Low Fade", "Mid Fade", "High Fade"};
                sideOptions.addAll(Arrays.asList(optionList));
                bookingScreen.getHaircutSelect().setModel
                        (new DefaultComboBoxModel(sideOptions.toArray(new String[0])));
            }
        } else if (type == 2) { // User selected taper
             if (!bookingScreen.getHaircutSelect().getItemAt(0).toString().contains("Taper")) {
                 String[] optionList = new String[]{"- Select Taper -", "Low Taper", "Mid Taper", "High Taper"};
                 sideOptions.addAll(Arrays.asList(optionList));
                 bookingScreen.getHaircutSelect().setModel
                         (new DefaultComboBoxModel(sideOptions.toArray(new String[0])));
             }
        } else { // User does not have any haircut type selected
             bookingScreen.getHaircutSelect().setEnabled(false);
             bookingScreen.getHaircutSelect().addItem("Please select a haircut");
         }
    }

    // Method to check if user inputs are valid
    private void checkInputs() {
        int firstSideValue = bookingScreen.getSideOneSelect().getSelectedIndex();
        int secondSideValue = bookingScreen.getSideTwoSelect().getSelectedIndex();

        // Check if side types have not been selected
        if (!bookingScreen.getFadeButton().isSelected() && !bookingScreen.getTaperButton().isSelected()) {
            JOptionPane.showMessageDialog(null, "Please select a side type!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if (bookingScreen.getHaircutSelect().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Please select a side style!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Check if side lengths are inputted properly by user
        else if (firstSideValue < secondSideValue) {
            JOptionPane.showMessageDialog(null, "Please select a proper side length order!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Check if a side length has not been inputted
        else if (!bookingScreen.getSkinFadeCheckBox().isSelected()) {
            if (bookingScreen.getSideTwoSelect().getSelectedIndex() == 0 ||
                    bookingScreen.getSideTwoSelect().getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Please select a side length!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        bookAppointment(); // Call bookAppointment method
        ApplicationController.appointments.clear(); // Clear appointments
        ApplicationController.currentAppointments.clear(); // Clear appointments
        ApplicationController.appointmentImport.importAppointments("accounts/appointments.txt"); // Reload imports
    }

    // Method to write user input information to the appointments.txt file
    public void bookAppointment() {
        // Fields to get input values
        double selectedLengthValue = (double) bookingScreen.getTopLengthSlider().getValue() / 2;
        boolean selectedBuzzCut = bookingScreen.getBuzzCutCheckBox().isSelected();
        boolean selectedThinOut = bookingScreen.getThinOutCheckBox().isSelected();
        boolean selectedFade = bookingScreen.getFadeButton().isSelected();
        boolean selectedTaper = bookingScreen.getTaperButton().isSelected();
        boolean selectedSkinFade = bookingScreen.getSkinFadeCheckBox().isSelected();
        String firstSideValue = bookingScreen.getSideOneSelect().getSelectedItem().toString();
        String secondSideValue = bookingScreen.getSideTwoSelect().getSelectedItem().toString();
        boolean selectedDesign = bookingScreen.getDesignCheckBox().isSelected();
        boolean selectedBeard = bookingScreen.getBeardCheckBox().isSelected();
        boolean selectedLineUp = bookingScreen.getLineUpCheckBox().isSelected();
        String uniqueID = ApplicationController.currentID;
        int month = bookingScreen.getCalendar().getDate().getMonth();
        int date = bookingScreen.getCalendar().getDate().getDate();
        int year = bookingScreen.getCalendar().getDate().getYear() + 1900;
        String topLength;
        String buzzCut = null;
        String thinOut = null;
        String fadeType = null;
        String taperType = null;
        String sideType = null;
        String design = null;
        String beard = null;
        String lineUp = null;
        String appointmentDate;
        String time;
        String cost;

        // Skin fade
        if (bookingScreen.getSideOneSelect().getSelectedIndex() == 0)
            firstSideValue = "";
        if (bookingScreen.getSideTwoSelect().getSelectedIndex() == 0)
            secondSideValue = "";

        calculateTimeAndCost(); // Calculate time and cost

        // Setting variable text
        time = "" + timeMin + " min - " + timeMax + " min";
        cost = "$" + costMin;
        topLength = selectedLengthValue + "";
        if (selectedDesign)
            cost = "$" + costMin + " - $" + costMax;
        if (selectedBuzzCut) {
            buzzCut = "Buzz Cut";
            topLength = null;
        } if (selectedThinOut)
            thinOut = "Thin Out Top";
        if (selectedFade)
            fadeType = bookingScreen.getHaircutSelect().getSelectedItem().toString();
        if (selectedTaper)
            taperType = bookingScreen.getHaircutSelect().getSelectedItem().toString();

        int i = bookingScreen.getHaircutSelect().getSelectedItem().toString().indexOf(" ");
        if (!selectedSkinFade)
            sideType = firstSideValue + " to " + secondSideValue;
        if (selectedSkinFade && selectedFade) {
            fadeType = bookingScreen.getHaircutSelect().getSelectedItem().toString().substring(0, i) + " Skin Fade";
            sideType = null;
        } else if (selectedSkinFade && selectedTaper) {
            taperType = bookingScreen.getHaircutSelect().getSelectedItem().toString().substring(0, i) + " Skin Fade";
            sideType = null;
        }
        if (selectedDesign) {
            design = "Requested Design";
            cost = "$" + costMin + " - $" + costMax;
        }
        if (selectedBeard) {
            beard = "Requested Beard Work";
            cost = "$" + costMin + " - $" + costMax;
        }
        if (selectedLineUp)
            lineUp = "Requested Line Up";
        appointmentDate = month + "/" + date + "/" + year;

        try {
            // Write booking information to appointments text file
            FileWriter Writer = new FileWriter("accounts/appointments.txt", true);
            Writer.write("" + topLength + "," + buzzCut + "," + thinOut + "," + fadeType + ","
                    + taperType + "," + sideType + "," + design + "," + beard + "," + lineUp + ","
                    + appointmentDate + "," + time + "," + cost + "," + uniqueID + ",");
            Writer.write(System.getProperty("line.separator"));
            Writer.close(); // Close writer
            ApplicationController.accountImport.importAccounts("accounts/appointments.txt"); // Reload imports
            JOptionPane.showMessageDialog(null, "Your appointment has been booked!", "Success",
                    JOptionPane.INFORMATION_MESSAGE);

            // Reset values
            timeMin = 0;
            timeMax = 0;
            costMin = 20;
            costMax = costMin;

            // Switch to home screen
            ApplicationController.switchScreen(ApplicationController.screens[ScreenType.HOME_SCREEN.getValue()]);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e);
        }
    }

    // Method to calculate time and cost of a haircut based on the user's inputs
    public void calculateTimeAndCost() {
        // Fields to get input values
        double lengthValue = (double) bookingScreen.getTopLengthSlider().getValue() / 2;
        boolean buzzCut = bookingScreen.getBuzzCutCheckBox().isSelected();
        boolean thinOut = bookingScreen.getThinOutCheckBox().isSelected();
        boolean selectedFade = bookingScreen.getFadeButton().isSelected();
        boolean selectedTaper = bookingScreen.getTaperButton().isSelected();
        boolean selectedSkinFade = bookingScreen.getSkinFadeCheckBox().isSelected();
        boolean selectedDesign = bookingScreen.getDesignCheckBox().isSelected();
        boolean selectedBeard = bookingScreen.getBeardCheckBox().isSelected();
        boolean selectedLineUp = bookingScreen.getLineUpCheckBox().isSelected();

        // Add a minimum and maximum estimated time for haircut inputs
        if (lengthValue > 0) {
            timeMin += 5;
            timeMax += 20;
        } else if (buzzCut) {
            timeMin += 5;
            timeMax += 10;
        }
        if (thinOut) {
            timeMin += 5;
            timeMax += 10;
        }
        if (selectedSkinFade) {
            timeMin += 30;
            timeMax += 40;
        } else if (selectedFade) {
            timeMin += 25;
            timeMax += 35;
        }
        if (selectedTaper) {
            timeMin += 20;
            timeMax += 30;
        }
        if (selectedDesign) {
            timeMin += 5;
            timeMax += 15;
            costMax += 10;
        }
        if (selectedBeard) {
            timeMin += 5;
            timeMax += 10;
            costMax += 5;
        }
        if (selectedLineUp) {
            timeMin += 2;
            timeMax += 5;
        }
    }
}
