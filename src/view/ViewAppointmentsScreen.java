package view;

import controller.ApplicationController;
import model.Appointment;

import javax.swing.*;
import java.awt.*;

public class ViewAppointmentsScreen extends Screen {

    // Fields
    private JLabel titleLabel = new JLabel(new ImageIcon("images/viewAppointmentsTitle.png"));
    private JList<Appointment> appointmentList = new JList<>(ApplicationController.appointmentListModel);
    private JScrollPane appointmentScroll = new JScrollPane(appointmentList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    public ViewAppointmentsScreen() {

        getBackButton().setVisible(false);
        setBackground(new Color(162, 176, 177));

        titleLabel.setBounds(0, 0, 1600, 900);
        add(titleLabel);

        appointmentList.setFont(new Font("Tahoma", Font.PLAIN, 20));
        appointmentScroll.setBounds(100, 130, 1400, 600);
        add(appointmentScroll);
    }
}
