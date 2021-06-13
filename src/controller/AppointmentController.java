package controller;

import model.Appointment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AppointmentController {

    public void importAppointments(String fileName) {
        try {
            Scanner input = new Scanner(new File(fileName));
            input.useDelimiter(",");

            // For all lines in the appointments text file
            while (input.hasNextLine()) {

                // Store appointment information
                String[] appointmentInformation = new String[13];

                // Get values from text file to array
                for (int x = 0; x < 13 && input.hasNext(); x++)
                    appointmentInformation[x] = input.next();

                // Add information to appointments ArrayList
                ApplicationController.appointments.add(new Appointment(appointmentInformation[0],
                        appointmentInformation[1], appointmentInformation[2],
                        appointmentInformation[3], appointmentInformation[4], appointmentInformation[5]
                        , appointmentInformation[6], appointmentInformation[7], appointmentInformation[8]
                        , appointmentInformation[9], appointmentInformation[10], appointmentInformation[11]
                        , appointmentInformation[12]));

            }

            // Store current appointment information
            Appointment currentAppointmentInformation;

            // Remove last row in the appointments ArrayList which is all null
            ApplicationController.appointments.remove(ApplicationController.appointments.size() - 1);

            // Search through all appointments and match the current ID to appointments with the same ID
            // Add current appointment information to the current appointment ArrayList
            for (int index = 0; index < ApplicationController.appointments.size(); index++) {
                if (ApplicationController.appointments.get(index)
                        .getUniqueID().equals(ApplicationController.currentID)) {
                    // Create appointment for current appointment information
                    currentAppointmentInformation = new Appointment(
                            ApplicationController.appointments.get(index).getTopLength(),
                            ApplicationController.appointments.get(index).getBuzzCut(),
                            ApplicationController.appointments.get(index).getThinOut(),
                            ApplicationController.appointments.get(index).getFadeType(),
                            ApplicationController.appointments.get(index).getTaperType(),
                            ApplicationController.appointments.get(index).getSideType(),
                            ApplicationController.appointments.get(index).getDesign(),
                            ApplicationController.appointments.get(index).getBeard(),
                            ApplicationController.appointments.get(index).getLineUp(),
                            ApplicationController.appointments.get(index).getAppointmentDate(),
                            ApplicationController.appointments.get(index).getTime(),
                            ApplicationController.appointments.get(index).getCost(),
                            ApplicationController.appointments.get(index).getUniqueID());
                    // Add information to ArrayList
                    ApplicationController.currentAppointments.addAll(Arrays.asList(currentAppointmentInformation));
                }
            }

            input.close(); // Close input

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
