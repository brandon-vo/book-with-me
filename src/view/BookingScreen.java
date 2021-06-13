package view;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class BookingScreen extends Screen {

    // Fields
    private JLabel bookAppointmentLabel = new JLabel(new ImageIcon("images/bookAppointmentTitle.png"));
    private JLabel selectDateLabel = new JLabel("Select a date");
    private JLabel selectCutLabel = new JLabel("Select your haircut ($20)");
    private JLabel additionalLabel = new JLabel("Additional");
    private JLabel topLabel = new JLabel("Top (inches)");
    private JLabel sideLabel = new JLabel("Side");
    private Hashtable lengthTable = new Hashtable();
    private JSlider topLengthSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
    private JCheckBox buzzCutCheckBox = new JCheckBox("Buzz Cut", false);
    private JCheckBox thinOutCheckBox = new JCheckBox("Thin Out", false);
    private JRadioButton fadeButton = new JRadioButton("Fade", false);
    private JRadioButton taperButton = new JRadioButton("Taper", false);
    private JCheckBox skinFadeCheckBox = new JCheckBox("Skin Fade/Taper");
    private ButtonGroup sideType = new ButtonGroup();
    private JComboBox haircutSelect = new JComboBox<String>();
    private JLabel sideToLabel = new JLabel("to");
    private JComboBox sideOneSelect = new JComboBox<String>();
    private JComboBox sideTwoSelect = new JComboBox<String>();
    private JCheckBox designCheckBox = new JCheckBox("Design (+$0 - $10)", false);
    private JCheckBox beardCheckBox = new JCheckBox("Beard (+$5)", false);
    private JCheckBox lineUpCheckBox = new JCheckBox("Front Line Up", false);
    private JButton bookNowButton = new JButton("BOOK NOW");
    private JLabel guardLabel = new JLabel("Highest Guard             Lowest Guard");
    private String[] guardOptions = new String[] {
            "- Select -", "0", "0.5", "1.0", "1.5", "2.0", "3.0", "4.0", "5.0", "6.0", "7.0", "8.0",
    };
    private JLabel bookingHeader = new JLabel(new ImageIcon("images/bookingHeader.png"));

    public BookingScreen() {

        getBackButton().setVisible(false);
        setBackground(new Color(176, 196, 219));

        sideType.add(taperButton);
        sideType.add(fadeButton);

        bookAppointmentLabel.setBounds(0, 0, 1600, 900);
        add(bookAppointmentLabel);

        bookingHeader.setBounds(0, 0, 1600, 900);
        add(bookingHeader);

        selectCutLabel.setBounds(75, 170, 500, 100);
        selectCutLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(selectCutLabel);

        selectDateLabel.setBounds(1075, 170, 500, 100);
        selectDateLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(selectDateLabel);

        topLabel.setBounds(160, 220, 520, 100);
        topLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(topLabel);

        sideLabel.setBounds(550, 220, 520, 100);
        sideLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(sideLabel);

        fadeButton.setBounds(450, 280, 170, 50);
        fadeButton.setBackground(new Color(176, 196, 219));
        fadeButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(fadeButton);

        taperButton.setBounds(620, 280, 170, 50);
        taperButton.setBackground(new Color(176, 196, 219));
        taperButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(taperButton);

        haircutSelect.setBounds(450, 340, 250, 30);
        haircutSelect.setBackground(new Color (172, 181, 182));
        haircutSelect.setFont(new Font("Tahoma", Font.PLAIN, 17));
        haircutSelect.setEnabled(false);
        haircutSelect.addItem("Please select a haircut!");
        add(haircutSelect);

        // Hashtable values to allow decimal values on slider
        lengthTable.put(0, new JLabel("0"));
        lengthTable.put(1, new JLabel("0.5"));
        lengthTable.put(2, new JLabel("1"));
        lengthTable.put(3, new JLabel("1.5"));
        lengthTable.put(4, new JLabel("2"));
        lengthTable.put(5, new JLabel("2.5"));
        lengthTable.put(6, new JLabel("3"));
        lengthTable.put(7, new JLabel("3.5"));
        lengthTable.put(8, new JLabel("4"));
        lengthTable.put(9, new JLabel("4.5"));
        lengthTable.put(10, new JLabel("5"));
        topLengthSlider.setLabelTable(lengthTable);

        topLengthSlider.setBounds(80, 290, 300, 75);
        topLengthSlider.setBackground(new Color(176, 196, 219));
        topLengthSlider.setMajorTickSpacing(5);
        topLengthSlider.setPaintTicks(true);
        topLengthSlider.setPaintLabels(true);
        add(topLengthSlider);

        skinFadeCheckBox.setBounds(450, 370, 150, 50);
        skinFadeCheckBox.setBackground(new Color(176, 196, 219));
        skinFadeCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
        skinFadeCheckBox.setEnabled(false);
        add(skinFadeCheckBox);

        guardLabel.setBounds(450, 420, 270, 30);
        guardLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(guardLabel);

        sideOneSelect.setBounds(450, 450, 90, 30);
        sideOneSelect.setEnabled(false);
        sideOneSelect.setBackground(new Color (172, 181, 182));
        sideOneSelect.setFont(new Font("Tahoma", Font.PLAIN, 10));
        sideOneSelect.addItem("Highest Guard");
        sideOneSelect.setModel(new DefaultComboBoxModel(guardOptions));
        add(sideOneSelect);

        sideTwoSelect.setBounds(610, 450, 90, 30);
        sideTwoSelect.setEnabled(false);
        sideTwoSelect.setBackground(new Color (172, 181, 182));
        sideTwoSelect.setFont(new Font("Tahoma", Font.PLAIN, 10));
        sideTwoSelect.addItem("Lowest Guard");
        sideTwoSelect.setModel(new DefaultComboBoxModel(guardOptions));
        add(sideTwoSelect);

        sideToLabel.setBounds(565, 450, 90, 30);
        sideToLabel.setBackground(new Color(176, 196, 219));
        sideToLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(sideToLabel);

        buzzCutCheckBox.setBounds(100, 350, 150, 50);
        buzzCutCheckBox.setBackground(new Color(176, 196, 219));
        buzzCutCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(buzzCutCheckBox);

        thinOutCheckBox.setBounds(250, 350, 150, 50);
        thinOutCheckBox.setBackground(new Color(176, 196, 219));
        thinOutCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(thinOutCheckBox);

        additionalLabel.setBounds(75, 475, 500, 100);
        additionalLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(additionalLabel);

        designCheckBox.setBounds(100, 550, 200, 50);
        designCheckBox.setBackground(new Color(176, 196, 219));
        designCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(designCheckBox);

        beardCheckBox.setBounds(100, 600, 150, 50);
        beardCheckBox.setBackground(new Color(176, 196, 219));
        beardCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(beardCheckBox);

        lineUpCheckBox.setBounds(100, 650, 150, 50);
        lineUpCheckBox.setBackground(new Color(176, 196, 219));
        lineUpCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lineUpCheckBox);

        bookNowButton.setBackground(new Color(30, 75, 135));
        bookNowButton.setForeground(Color.WHITE);
        bookNowButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
        bookNowButton.setBorder(null);
        bookNowButton.setBounds(700, 700, 250, 100);
        add(bookNowButton);

    }

    public JSlider getTopLengthSlider() { return topLengthSlider; }

    public JCheckBox getBuzzCutCheckBox() { return buzzCutCheckBox; }

    public JCheckBox getThinOutCheckBox() { return thinOutCheckBox; }

    public JRadioButton getFadeButton() { return fadeButton; }

    public JRadioButton getTaperButton() { return taperButton; }

    public JComboBox getHaircutSelect() { return haircutSelect; }

    public JCheckBox getDesignCheckBox() { return designCheckBox; }

    public JCheckBox getBeardCheckBox() { return beardCheckBox; }

    public JCheckBox getLineUpCheckBox() { return lineUpCheckBox; }

    public JButton getBookNowButton() { return bookNowButton; }

    public JCheckBox getSkinFadeCheckBox() { return skinFadeCheckBox; }

    public JComboBox getSideOneSelect() { return sideOneSelect; }

    public JComboBox getSideTwoSelect() { return sideTwoSelect; }

}
