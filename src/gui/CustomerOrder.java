package gui;
import javax.swing.*;

import Controller.CustomerController;
import Controller.SalesOrderController;
import Model.Customer;
import Model.SalesOrder;

import java.awt.*;
import java.awt.event.*;

public class CustomerOrder extends JFrame {
	
	Customer customer;
	SalesOrderController orderController = new SalesOrderController();
	//Email Input 
    JLabel emailLabel = new JLabel("Email:");
    JTextField emailField = new JTextField(50);
    CustomerController customerController = new CustomerController();
    public CustomerOrder() {
    	setTitle("Find Customer");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //Panels
        JPanel panel = new JPanel(new GridLayout(2, 2));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        //Buttons and associated functions
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchEmail());
        JButton newCustomerButton = new JButton("New Customer");
        newCustomerButton.addActionListener(e -> new NewCustomer());
        JButton exitButton = new JButton("Close");
        exitButton.addActionListener(e -> dispose());
        
        //Add Panels
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(searchButton);
        panel.add(newCustomerButton);
        buttonPanel.add(exitButton);
        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        //Makes frame visible, is last to avoid certain problems
        setVisible(true);
    }
    public void searchEmail() {  //Search for customer.
    	    String email = emailField.getText();
    	    Customer customer = customerController.findCustomer(email);
    	    if (customer != null) {
    	        JOptionPane.showMessageDialog(null, "Customer found:\n" + customer.toString());
    	        orderController.findAndAddCustomer(email);
    	        
    	        new AddProduct();
    	    } else {
    	        JOptionPane.showMessageDialog(null, "No customer found with email " + email);
    	    }
    }
}
