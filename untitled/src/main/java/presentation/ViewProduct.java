package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * A class representing the product view.
 * This class extends JFrame and provides the user interface for interacting with product data.
 */
public class ViewProduct extends JFrame {
    private JTextField namePRtextField;
    private JTextField pricePRField;
    private JTextField stockPRtextField;
    private JTextField IDtextField;
    private JButton deletePRButton;
    private JButton addPRButton;
    private JButton updatePRButton;
    private JButton showPRButton;

    /**
     * Constructor for the ViewProduct class.
     * Sets up the JFrame and initializes the UI components.
     */
    public ViewProduct() {
        this.getContentPane().setBackground(new Color(176, 196, 222));
        this.getContentPane().setForeground(SystemColor.controlHighlight);
        this.setBounds(100, 100, 645, 600);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel nameORLabel = new JLabel("Name");
        nameORLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameORLabel.setBounds(61, 116, 93, 24);
        this.getContentPane().add(nameORLabel);

        JLabel productLabel = new JLabel("PRODUCT");
        productLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        productLabel.setBounds(266, 21, 118, 32);
        this.getContentPane().add(productLabel);

        JLabel pricePRLabel = new JLabel("Price");
        pricePRLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pricePRLabel.setBounds(61, 150, 45, 31);
        this.getContentPane().add(pricePRLabel);

        JLabel stockPRLabel = new JLabel("Stock");
        stockPRLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        stockPRLabel.setBounds(61, 203, 64, 13);
        this.getContentPane().add(stockPRLabel);

        namePRtextField = new JTextField();
        namePRtextField.setBounds(136, 122, 140, 19);
        this.getContentPane().add(namePRtextField);
        namePRtextField.setColumns(10);

        pricePRField = new JTextField();
        pricePRField.setBounds(136, 162, 140, 19);
        this.getContentPane().add(pricePRField);
        pricePRField.setColumns(10);

        stockPRtextField = new JTextField();
        stockPRtextField.setBounds(136, 202, 140, 19);
        this.getContentPane().add(stockPRtextField);
        stockPRtextField.setColumns(10);

        addPRButton = new JButton("ADD");
        addPRButton.setBounds(370, 175, 105, 31);
        this.getContentPane().add(addPRButton);

        updatePRButton = new JButton("UPDATE");
        updatePRButton.setBounds(380, 380, 105, 31);
        this.getContentPane().add(updatePRButton);

        deletePRButton = new JButton("DELETE");
        deletePRButton.setBounds(235, 380, 105, 31);
        this.getContentPane().add(deletePRButton);

        showPRButton = new JButton("SHOW");
        showPRButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        showPRButton.setBounds(234, 282, 137, 24);
        this.getContentPane().add(showPRButton);

        JLabel idLabel = new JLabel("ID");
        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        idLabel.setBounds(98, 381, 45, 24);
        this.getContentPane().add(idLabel);

        IDtextField = new JTextField();
        IDtextField.setBounds(153, 384, 45, 24);
        this.getContentPane().add(IDtextField);
        IDtextField.setColumns(10);
        this.setVisible(false);
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
     * Retrieves the namePRtextField.
     *
     * @return the namePRtextField
     */
    public JTextField getNamePRtextField() {
        return namePRtextField;
    }

    /**
     * Retrieves the pricePRField.
     *
     * @return the pricePRField
     */
    public JTextField getPricePRField() {
        return pricePRField;
    }

    /**
     * Retrieves the stockPRtextField.
     *
     * @return the stockPRtextField
     */
    public JTextField getStockPRtextField() {
        return stockPRtextField;
    }

    /**
     * Retrieves the IDtextField.
     *
     * @return the IDtextField
     */
    public JTextField getIDtextField() {
        return IDtextField;
    }

    /**
     * Adds an ActionListener to the addPRButton.
     *
     * @param ActionListener the ActionListener to be added
     */
    public void addAddProductListener(ActionListener ActionListener) {
        addPRButton.addActionListener(ActionListener);
    }

    /**
     * Adds an ActionListener to the updatePRButton.
     *
     * @param ActionListener the ActionListener to be added
     */
    public void addUpdateProductListener(ActionListener ActionListener) {
        updatePRButton.addActionListener(ActionListener);
    }

    /**
     * Adds an ActionListener to the deletePRButton.
     *
     * @param ActionListener the ActionListener to be added
     */
    public void addDeleteProductListener(ActionListener ActionListener) {
        deletePRButton.addActionListener(ActionListener);
    }

    /**
     * Adds an ActionListener to the showPRButton.
     *
     * @param ActionListener the ActionListener to be added
     */
    public void addShowProductListener(ActionListener ActionListener) {
        showPRButton.addActionListener(ActionListener);
    }
}