package gui;
import javax.swing.*;

import Controller.CustomerController;
import Model.Customer;
import Model.SalesOrder;

import java.awt.*;
import java.awt.event.*;

public class NewCustomer extends JFrame{
	// Initialize text fields
    JTextField nameField = new JTextField(20);
    JTextField emailField = new JTextField(20);
    JTextField addressField = new JTextField(20);
    JTextField zipcodeField = new JTextField(20);
    JTextField cityField = new JTextField(20);
    JTextField phoneField = new JTextField(20);   
	CustomerController customerController = new CustomerController();
	public NewCustomer() {
        setTitle("Add customer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        
        //Panels
        JPanel panel = new JPanel(new GridLayout(7, 2));
        
        // lABELS
        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel zipcodeLabel = new JLabel("Zipcode:");
        JLabel cityLabel = new JLabel("City:");
        JLabel phoneLabel = new JLabel("Phone:");


        // Buttons and functionality 
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> submit());
        
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> clear());
        
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> back());

        // Add panels
        
        //Fields and labels are mixed to keep them aligned in GUI
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(zipcodeLabel);
        panel.add(zipcodeField);
        panel.add(cityLabel);
        panel.add(cityField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        
        //Buttons added
        panel.add(clearButton);
        panel.add(submitButton);
        
        add(panel);
        
      //Makes frame visible, is last to avoid certain problems
        setVisible(true);
    }

	public void submit() { //Checks if all are filled + if email is valid.
		if (nameField.getText().equals("") || emailField.getText().equals("") || addressField.getText().equals("") || zipcodeField.getText().equals("") || cityField.getText().equals("") || phoneField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
        } else if (!isValidEmail(emailField.getText())) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
        } else {
            Customer customer = new Customer(nameField.getText(), emailField.getText(), addressField.getText(), zipcodeField.getText(), cityField.getText(), phoneField.getText());
            
            
            customerController.addCustomer(customer);//Method to add customer
            
            
            JOptionPane.showMessageDialog(null, "Customer created:\n" + customer.toString());
            dispose();
        }
	}
	public void clear() { //Clears all input fields 
		nameField.setText("");
        emailField.setText("");
        addressField.setText("");
        zipcodeField.setText("");
        cityField.setText("");
        phoneField.setText("");
	}
	public void back() { //Removes current screen.
		dispose();
	}
    private boolean isValidEmail(String email) {
        String emailRegex = "^(.+)@(\\S+)$";
                             
        return email.matches(emailRegex);
    }
}
