package edu.ucalgary.ensf409;

/**
@author Pedro Ghodsi
@version 1.1
@since 1.0
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GUI extends JPanel {
    public static JLabel hamperCreatorLabel;
    public static JLabel nameLabel;
    public static JTextField name;
    public static JCheckBox mobReqBox;
    public static JLabel adultMaleLabel;
    public static JTextField adultMaleBox;
    public static JLabel adultFemaleLabel;
    public static JTextField adultFemaleBox;
    public static JLabel over8;
    public static JTextField over8Box;
    public static JLabel under8;
    public static JTextField under8Box;
    public static JLabel postCode;
    public static JTextField postCodeBox;
    public static JButton continueHamperButton;
    public static JButton finalizeHamperButton;
    public static int counting;

    public GUI() {
        initComponents();

    }

    class ClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Order order = new Order();
            if (counting <= 0) {
                if (e.getSource() == continueHamperButton) {
                    try {
                        order.addFirstOrder();
                    } catch (InsufficientFoodException e2) {
                        e2.printStackTrace();
                    }
                }
                counting++;
            } else {

                if (e.getSource() == continueHamperButton) {
                    try {
                        order.orderCreation();
                    } catch (InsufficientFoodException e1) {
                        e1.printStackTrace();
                    } catch (InsufficientStockException e1) {
                        e1.printStackTrace();
                    }
                    counting++;
                }
            }
        }
    }

    class ClickListenerTwo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == finalizeHamperButton) {
                System.exit(1);
            }
        }
    }

    public void initComponents() {
        nameLabel = new JLabel("Name:");
        name = new JTextField(5);
        adultMaleLabel = new JLabel("Adult Males:");
        adultMaleBox = new JTextField(5);
        adultFemaleLabel = new JLabel("Adult Females:");
        adultFemaleBox = new JTextField(5);
        over8 = new JLabel("Over 8:");
        over8Box = new JTextField(5);
        under8 = new JLabel("Under 8:");
        under8Box = new JTextField(5);
        postCode = new JLabel("Postal Code (ex. T2N 1N4)");
        postCodeBox = new JTextField(5);
        continueHamperButton = new JButton("Add Current Hamper");
        finalizeHamperButton = new JButton("Finalize All Hampers");
        hamperCreatorLabel = new JLabel("Hamper Creator");
        mobReqBox = new JCheckBox("Mobility Accomodations Required");
        ClickListener click = new ClickListener();
        continueHamperButton.addActionListener(click);
        ClickListenerTwo clickEnd = new ClickListenerTwo();
        finalizeHamperButton.addActionListener(clickEnd);

        // adjust size and set layout
        setPreferredSize(new Dimension(683, 334));
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        // add components
        add(hamperCreatorLabel);
        add(nameLabel);
        add(name);
        add(adultMaleLabel);
        add(adultMaleBox);
        add(adultFemaleLabel);
        add(adultFemaleBox);
        add(over8);
        add(over8Box);
        add(under8);
        add(under8Box);
        add(postCode);
        add(postCodeBox);
        add(mobReqBox);
        add(continueHamperButton);
        add(finalizeHamperButton);
    }

    public static void main(String[] args) throws InsufficientFoodException, InsufficientStockException {

        JFrame frame = new JFrame("GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new GUI());
        frame.pack();
        frame.setVisible(true);
        // boolean inNeed = MobilityStruggling();

    }

}
