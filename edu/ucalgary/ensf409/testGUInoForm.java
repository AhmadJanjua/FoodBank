package edu.ucalgary.ensf409;


/**
@author Pedro Ghodsi
@version 1.0
@since 1.0
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class testGUInoForm extends JPanel {
    private JLabel hamperCreatorLabel;
    private JCheckBox mobReqBox;
    private JLabel adultMaleLabel;
    private JTextField adultMaleBox;
    private JLabel adultFemaleLabel;
    private JTextField adultFemaleBox;
    private JLabel over8;
    private JTextField over8Box;
    private JLabel under8;
    private JTextField under8Box;
    private JLabel postCode;
    private JTextField postCodeBox;

    public testGUInoForm() {
        //construct components
        hamperCreatorLabel = new JLabel ("Hamper Creator");
        mobReqBox = new JCheckBox ("Mobility Accomodations Required");
        adultMaleLabel = new JLabel ("Adult Males:");
        adultMaleBox = new JTextField (5);
        adultFemaleLabel = new JLabel ("Adult Females:");
        adultFemaleBox = new JTextField (5);
        over8 = new JLabel ("Over 8:");
        over8Box = new JTextField (5);
        under8 = new JLabel ("Under 8:");
        under8Box = new JTextField (5);
        postCode = new JLabel ("Postal Code (ex. T2N 1N4)");
        postCodeBox = new JTextField (5);

        //adjust size and set layout
        setPreferredSize (new Dimension (944, 581));
        BoxLayout layout = new BoxLayout (this, BoxLayout.Y_AXIS);
        setLayout (layout);

        //add components
        add (hamperCreatorLabel);
        add (mobReqBox);
        add (adultMaleLabel);
        add (adultMaleBox);
        add (adultFemaleLabel);
        add (adultFemaleBox);
        add (over8);
        add (over8Box);
        add (under8);
        add (under8Box);
        add (postCode);
        add (postCodeBox);
    }
}

