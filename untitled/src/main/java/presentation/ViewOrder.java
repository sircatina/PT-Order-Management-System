package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * A class representing the order view.
 * This class extends JFrame and provides the user interface for interacting with order data.
 */
public class ViewOrder extends JFrame {
    //private JTextField IDtextField;
    private JTextField productField;
    private JTextField clientField;
    private JTextField quantitytextField;
    //private JTable tableOrder;
    private JButton billButton;
    private JComboBox ClientcomboBox;
    private JComboBox ProductcomboBox;
    private JButton addOrderButton;
    private JButton showButton;

    /**
     * Constructor for the ViewOrder class.
     * Sets up the JFrame and initializes the UI components.
     */
    public ViewOrder() {
        this.getContentPane().setBackground(new Color(176, 196, 222));
        this.getContentPane().setForeground(SystemColor.controlHighlight);
        this.setBounds(100, 100, 645, 600);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.getContentPane().setLayout(null);

//    JLabel IDORLabel = new JLabel("ID");
//    IDORLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
//    IDORLabel.setBounds(50, 75, 93, 24);
//    this.getContentPane().add(IDORLabel);

        JLabel clientLabel = new JLabel("ORDER");
        clientLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        clientLabel.setBounds(266, 21, 118, 32);
        this.getContentPane().add(clientLabel);

        JLabel ageCLLabel = new JLabel("ID PRODUCT");
        ageCLLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ageCLLabel.setBounds(50, 154, 93, 31);
        this.getContentPane().add(ageCLLabel);

        JLabel quantityLabel = new JLabel("QUANTITY");
        quantityLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        quantityLabel.setBounds(49, 203, 94, 13);
        this.getContentPane().add(quantityLabel);

//    IDtextField = new JTextField();
//    IDtextField.setBounds(136, 80, 140, 19);
//    this.getContentPane().add(IDtextField);
//    IDtextField.setColumns(10);

        quantitytextField = new JTextField();
        quantitytextField.setBounds(136, 202, 140, 19);
        this.getContentPane().add(quantitytextField);
        quantitytextField.setColumns(10);

//    tableOrder = new JTable();
//    tableOrder.setBounds(58, 281, 502, 230);
//    this.getContentPane().add(tableOrder);

        JLabel IDclientLlabel = new JLabel("ID CLIENT");
        IDclientLlabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        IDclientLlabel.setBounds(50, 120, 93, 24);
        this.getContentPane().add(IDclientLlabel);

        billButton = new JButton("Generate bill");
        billButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        billButton.setBounds(352, 233, 209, 24);
        this.getContentPane().add(billButton);

        clientField = new JTextField();
        clientField.setBounds(142, 125, 134, 19);
        this.getContentPane().add(clientField);
        clientField.setColumns(10);

        productField = new JTextField();
        productField.setColumns(10);
        productField.setBounds(142, 162, 134, 19);
        this.getContentPane().add(productField);

        addOrderButton = new JButton("ADD");
        addOrderButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        addOrderButton.setBounds(439, 172, 122, 28);
        this.getContentPane().add(addOrderButton);

        showButton = new JButton("SHOW");
        showButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        showButton.setBounds(439, 124, 122, 30);
        this.getContentPane().add(showButton);

        this.setVisible(false);
    }

    /**
     * Retrieves the value from the productField.
     *
     * @return the value of the productField as an integer
     */
    public int getProductField() {
        return Integer.parseInt(productField.getText());
    }

    /**
     * Retrieves the value from the clientField.
     *
     * @return the value of the clientField as an integer
     */
    public int getClientField() {
        return Integer.parseInt(clientField.getText());
    }

    /**
     * Retrieves the value from the quantitytextField.
     *
     * @return the value of the quantitytextField as an integer
     */
    public int getQuantitytextField() {
        return Integer.parseInt(quantitytextField.getText());
    }

    /**
     * Displays a message dialog with the given message.
     *
     * @param message the message to be displayed
     */
    public void showMessage1(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * Adds an ActionListener to the addOrderButton.
     *
     * @param ActionListener the ActionListener to be added
     */
    public void addADDOrderListener(ActionListener ActionListener) {
        addOrderButton.addActionListener(ActionListener);
    }

    /**
     * Adds an ActionListener to the showButton.
     *
     * @param ActionListener the ActionListener to be added
     */
    public void addShowOrderListener(ActionListener ActionListener) {
        showButton.addActionListener(ActionListener);
    }

    /**
     * Adds an ActionListener to the billButton.
     *
     * @param ActionListener the ActionListener to be added
     */
    public void addBillOrderListener(ActionListener ActionListener) {
        billButton.addActionListener(ActionListener);
    }
}