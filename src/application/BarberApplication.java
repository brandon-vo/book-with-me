/**
 * Book With Me - A Barber Booking Application
 * The following application simulates the process of users booking haircutting services with my barber shop.
 * It consists of creating or logging into an account, booking an appointment by selecting the styles they want done,
 * calculating the cost and time for the haircut, and viewing previous appointments.
 * This information is saved and written to text files as a local database.
 *
 * Sample login information with pre-tested appointments:
 * Email - admin@email.com
 * Password - password
 *
 * Features:
 * - Create an account with first and last name, email, password, phone number. A unique UUID is generated per account.
 * - Login to an account with an email and password
 * - Logging out of an account
 * - Booking appointments by selecting what top length they would like to cut, if they want a taper or fade,
 *    the side style, and if they request any additional haircutting services
 * - Viewing previously booked appointments for user-specific accounts
 * - Viewing profile information (name, email, phone number)
 * - Navigate through login, register, home, booking, view appointments, profile screen with buttons and back buttons
 *
 * Major Skills:
 * - Modular Programming (Model-View-Controller)
 * - Object Oriented Programming
 * - String, int, double, boolean
 * - Arrays, ArrayLists, DefaultListModel
 * - For loops, If/Else/Else If, Break, While, Try-catch
 * - Text-file Database:
 *      - Reading text files to retrieve account data and appointments
 *      - Writing to text files to save data for an account
 * - Java Swing Objects (Jlist, JButton, JComboBox, JSlider, JRadioButton, JLabel...)
 * - ActionListener
 * - Use of methods to handle tasks
 * - Use of external library (JCalendar)
 *
 * @author Brandon Vo
 */

package application;

import controller.ApplicationController;

public class BarberApplication {

    public static void main(String[] args) {

        new ApplicationController(); // Create ApplicationController
    }
}
