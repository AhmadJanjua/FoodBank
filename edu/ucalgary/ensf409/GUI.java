package edu.ucalgary.ensf409;

/**
@author Pedro Ghodsi
@version 1.9
@since 1.0
*/
import java.io.File;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
    public static JButton exitButton;
    public static int counting;

    public GUI() {
        initComponents();

    }

    public static void errorBox(String info, String title) {
        JOptionPane.showMessageDialog(null, info, "Error!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void completionBox(String info, String title) {
        JOptionPane.showMessageDialog(null, info, "Complete!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void successBox(String info, String title){
        JOptionPane.showMessageDialog(null, info, "Success!", JOptionPane.INFORMATION_MESSAGE);
    }

    class ClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Order order = new Order();
            if (counting <= 0) {
                if (e.getSource() == continueHamperButton) {
                    try {
                        order.addFirstOrder();
                        successBox("Hamper added Successfully", "Addition Successful");

                    } catch (InsufficientFoodException e2) {
                        e2.printStackTrace();
                        Order.decrement();
                    } catch (InsufficientStockException e1) {
                        e1.printStackTrace();
                    }
                }
                counting++;
            } else {

                if (e.getSource() == continueHamperButton) {
                    try {
                        order.orderCreation();
                        successBox("Hamper added Successfully", "Addition Successful");
                    } catch (InsufficientFoodException e1) {
                        e1.printStackTrace();
                    } catch (InsufficientStockException e1) {
                        e1.printStackTrace();
                    }
                    counting++;
                    
                }
                
            }name.setEditable(false);
        }
    }

    class ClickListenerTwo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == finalizeHamperButton) {
                name.setEditable(false);
                adultFemaleBox.setEditable(false);
                adultMaleBox.setEditable(false);
                under8Box.setEditable(false);
                over8Box.setEditable(false);
                postCodeBox.setEditable(false);
                mobReqBox.setEnabled(false);
                continueHamperButton.setEnabled(false);
                finalizeHamperButton.setEnabled(false);
                completionBox(
                        "Hamper(s) has/have been created successfully! Refer to output file for completed hampers. You may exit the Order Form now.",
                        "Success!");
            }
        }
    }

    class ClickListenerThree implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exitButton) {
                System.exit(1);
            }
        }
    }

    class PostCodeBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == GUI.mobReqBox) {
                postCodeBox.setEditable(true);
            }
            if (!(mobReqBox.isSelected())) {
                postCodeBox.setEditable(false);
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
        postCode = new JLabel("Postal Code (ex. T2N 1N4, T2N1N4, t2n1n4)");
        postCodeBox = new JTextField(5);
        continueHamperButton = new JButton("Add Hamper with Current Parameters");
        finalizeHamperButton = new JButton("Finalize All Hampers");
        exitButton = new JButton("Exit");
        hamperCreatorLabel = new JLabel("Hamper Creator");
        mobReqBox = new JCheckBox("Mobility Accomodations Required");
        ClickListener click = new ClickListener();
        continueHamperButton.addActionListener(click);
        ClickListenerTwo clickEnd = new ClickListenerTwo();
        finalizeHamperButton.addActionListener(clickEnd);
        ClickListenerThree clickExit = new ClickListenerThree();
        exitButton.addActionListener(clickExit);
        postCodeBox.setEditable(false);
        PostCodeBoxListener postCodeActivate = new PostCodeBoxListener();
        mobReqBox.addActionListener(postCodeActivate);

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
        add(mobReqBox);
        add(postCode);
        add(postCodeBox);
        add(continueHamperButton);
        add(finalizeHamperButton);
        add(exitButton);
    }

    public static void main(String[] args) {

        File delete = new File("Finalized Hamper Order.txt");
        delete.delete();
        JFrame frame = new JFrame("GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new GUI());
        frame.pack();
        frame.setVisible(true);

    }

}