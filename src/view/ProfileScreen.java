package view;

import javax.swing.*;
import java.awt.*;

public class ProfileScreen extends Screen {

    // Fields
    private JLabel profileTitleLabel = new JLabel(new ImageIcon("images/profileTitle.png"));
    private JLabel nameLabel = new JLabel("Name: ");
    private JLabel passwordLabel = new JLabel("Password: •••••••");
    private JLabel emailLabel = new JLabel("Email: ");
    private JLabel phoneNumberLabel = new JLabel("Phone Number: ");
    private JLabel icons = new JLabel(new ImageIcon("images/profileIcons.png"));

    private static final Font FONT = new Font("Tahoma", Font.PLAIN, 30);

    public ProfileScreen() {

        getBackButton().setVisible(false);

        profileTitleLabel.setBounds(600, 0, 1600, 900);
        add(profileTitleLabel);

        nameLabel.setBounds(625, 230, 500, 50);
        nameLabel.setFont(FONT);
        add(nameLabel);

        passwordLabel.setBounds(625, 330, 500, 50);
        passwordLabel.setFont(FONT);
        add(passwordLabel);

        emailLabel.setBounds(625, 430, 500, 50);
        emailLabel.setFont(FONT);
        add(emailLabel);

        phoneNumberLabel.setBounds(625, 530, 500, 50);
        phoneNumberLabel.setFont(FONT);
        add(phoneNumberLabel);

        icons.setBounds(0, -5, 1600, 900);
        add(icons);

    }

    public JLabel getNameLabel() { return nameLabel; }

    public JLabel getEmailLabel() { return emailLabel; }

    public JLabel getPhoneNumberLabel() { return phoneNumberLabel; }

}
