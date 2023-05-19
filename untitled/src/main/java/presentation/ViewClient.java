package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * A class representing the client view.
 * This class extends JFrame and provides the user interface for interacting with client data.
 */
public class ViewClient extends JFrame {
    private JTextField nameCLtextField;
    private JTextField ageCLField;
    private JTextField addressCLtextField;
    private JTextField IDtextField;
    //private JTable tableClient;
    private JButton showCLButton;
    private JButton deleteCLButton;
    private JButton addCLButton;
    private JButton updateCLButton;

    /**
     * Constructor for the ViewClient class.
     * Sets up the JFrame and initializes the UI components.
     */
    public ViewClient() {
        this.getContentPane().setBackground(new Color(176, 196, 222));
        this.getContentPane().setForeground(SystemColor.controlHighlight);
        this.setBounds(100, 100, 645, 600);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel nameCLLabel = new JLabel("Name");
        nameCLLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameCLLabel.setBounds(61, 121, 93, 24);
        this.getContentPane().add(nameCLLabel);

        JLabel clientLabel = new JLabel("CLIENT");
        clientLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        clientLabel.setBounds(266, 21, 118, 32);
        this.getContentPane().add(clientLabel);

        JLabel ageCLLabel = new JLabel("Age");
        ageCLLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ageCLLabel.setBounds(71, 155, 45, 31);
        this.getContentPane().add(ageCLLabel);

        JLabel addressCLLabel = new JLabel("Address");
        addressCLLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        addressCLLabel.setBounds(61, 203, 64, 13);
        this.getContentPane().add(addressCLLabel);

        nameCLtextField = new JTextField();
        nameCLtextField.setBounds(136, 126, 140, 19);
        this.getContentPane().add(nameCLtextField);
        nameCLtextField.setColumns(10);

        ageCLField = new JTextField();
        ageCLField.setBounds(136, 162, 140, 19);
        this.getContentPane().add(ageCLField);
        ageCLField.setColumns(10);

        addressCLtextField = new JTextField();
        addressCLtextField.setBounds(136, 202, 140, 19);
        this.getContentPane().add(addressCLtextField);
        addressCLtextField.setColumns(10);

        addCLButton = new JButton("ADD");
        addCLButton.setBounds(380, 183, 105, 31);
        this.getContentPane().add(addCLButton);

        updateCLButton = new JButton("UPDATE");
        updateCLButton.setBounds(417, 383, 105, 31);
        this.getContentPane().add(updateCLButton);

        deleteCLButton = new JButton("DELETE");
        deleteCLButton.setBounds(266, 383, 105, 31);
        this.getContentPane().add(deleteCLButton);

        showCLButton = new JButton("SHOW");
        showCLButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        showCLButton.setBounds(235, 247, 137, 24);
        this.getContentPane().add(showCLButton);

        JLabel idLabel = new JLabel("ID");
        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        idLabel.setBounds(92, 384, 45, 24);
        this.getContentPane().add(idLabel);

        IDtextField = new JTextField();
        IDtextField.setBounds(136, 387, 45, 24);
        this.getContentPane().add(IDtextField);
        IDtextField.setColumns(10);
        this.setVisible(false);
    }

    /**
     * Retrieves the ID value from the IDtextField.
     *
     * @return the ID value as an integer
     */
    public int getIDtextField() {
        return Integer.parseInt(IDtextField.getText());
    }

    /**
     * Retrieves the name value from the nameCLtextField.
     *
     * @return the name value as a string
     */
    public String getNameCLtextField() {
        return nameCLtextField.getText();
    }

    /**
     * Retrieves the ageCLField.
     *
     * @return the ageCLField
     */
    public JTextField getAgeCLField() {
        return ageCLField;
    }

    /**
     * Retrieves the address value from the addressCLtextField.
     *
     * @return the address value as a string
     */
    public String getAddressCLtextField() {
        return addressCLtextField.getText();
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
     * Adds an ActionListener to the addCLButton.
     *
     * @param ActionListener the ActionListener to be added
     */
    public void addAddClientListener(ActionListener ActionListener) {
        addCLButton.addActionListener(ActionListener);
    }

    /**
     * Adds an ActionListener to the deleteCLButton.
     *
     * @param ActionListener the ActionListener to be added
     */
    public void addDeleteClientListener(ActionListener ActionListener) {
        deleteCLButton.addActionListener(ActionListener);
    }

    /**
     * Adds an ActionListener to the updateCLButton.
     *
     * @param ActionListener the ActionListener to be added
     */
    public void addUpdateClientListener(ActionListener ActionListener) {
        updateCLButton.addActionListener(ActionListener);
    }

    /**
     * Adds an ActionListener to the showCLButton.
     *
     * @param ActionListener the ActionListener to be added
     */
    public void addShowClientListener(ActionListener ActionListener) {
        showCLButton.addActionListener(ActionListener);
    }
}