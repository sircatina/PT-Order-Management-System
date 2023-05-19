package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * A class representing the start view.
 * This class extends JFrame and provides the user interface for selecting different modules of the application.
 */
public class ViewStart extends JFrame {
    private JButton orderButton;
    private JButton productButton;
    private JButton clientButton;

    /**
     * Constructor for the ViewStart class.
     * Sets up the JFrame and initializes the UI components.
     */
    public ViewStart() {
        this.getContentPane().setBackground(new Color(176, 196, 222));
        this.getContentPane().setForeground(SystemColor.controlHighlight);
        this.setBounds(100, 100, 645, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        this.getContentPane().setBackground(new Color(176, 196, 222));
        this.getContentPane().setForeground(SystemColor.controlHighlight);
        this.setBounds(100, 100, 645, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        clientButton = new JButton("Client");
        clientButton.setForeground(new Color(100, 149, 237));
        clientButton.setBackground(SystemColor.inactiveCaption);
        clientButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        clientButton.setBounds(186, 297, 219, 63);
        this.getContentPane().add(clientButton);

        productButton = new JButton("Product");
        productButton.setForeground(new Color(100, 149, 237));
        productButton.setBackground(SystemColor.inactiveCaption);
        productButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        productButton.setBounds(186, 405, 219, 63);
        this.getContentPane().add(productButton);

        JLabel databaseLabel = new JLabel("DataBase Management Application");
        databaseLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        databaseLabel.setBounds(102, 88, 460, 41);
        this.getContentPane().add(databaseLabel);

        orderButton = new JButton("Order");
        orderButton.setForeground(new Color(100, 149, 237));
        orderButton.setBackground(SystemColor.inactiveCaption);
        orderButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        orderButton.setBounds(186, 187, 219, 63);
        this.getContentPane().add(orderButton);

        setVisible(true);
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
     * Adds an ActionListener to the clientButton.
     *
     * @param ActionListener the ActionListener to be added
     */
    public void addClientListener(ActionListener ActionListener) {
        clientButton.addActionListener(ActionListener);
    }

    /**
     * Adds an ActionListener to the orderButton.
     *
     * @param ActionListener the ActionListener to be added
     */
    public void addOrderListener(ActionListener ActionListener) {
        orderButton.addActionListener(ActionListener);
    }

    /**
     * Adds an ActionListener to the productButton.
     *
     * @param ActionListener the ActionListener to be added
     */
    public void addProductListener(ActionListener ActionListener) {
        productButton.addActionListener(ActionListener);
    }
}