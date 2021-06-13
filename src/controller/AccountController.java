package controller;

import model.Account;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AccountController {

    // Reading the registration.txt file and adding the accounts to an ArrayList
    public void importAccounts(String fileName) {
        try {
            Scanner input = new Scanner(new File(fileName));
            input.useDelimiter(",");

            // For all lines in the registration text file
            while (input.hasNextLine()) {

                // Store account information
                String[] accountInformation = new String[6];

                // Get values from text file to array
                for (int x = 0; x < 6 && input.hasNext(); x++)
                    accountInformation[x] = input.next();

                // Add information to accounts ArrayList
                ApplicationController.accounts.add(new Account(accountInformation[0],
                        accountInformation[1], accountInformation[2],
                        accountInformation[3], accountInformation[4], accountInformation[5]));
            }

            input.close(); // Close input

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
