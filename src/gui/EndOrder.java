package gui;

import javax.swing.*;

import Controller.SalesOrderController;
import Model.SalesOrder;

import java.awt.*;
import java.time.LocalDate;
import java.util.Date;

public class EndOrder extends JFrame {
	SalesOrderController orderController = new SalesOrderController();
    public EndOrder() {
        setTitle("Complete Order");
        setSize(400, 200);
        //JPanels 
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
       //Mixed Label and textfield due to GridLayout
       JLabel deliveryLabel = new JLabel("Delivery Date: ");
       JTextField deliveryField = new JTextField();
       JLabel  paymentLabel = new JLabel("Payment Date: ");
       JTextField paymentField = new JTextField();
        
       //Buttons + functionality 
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> {
            dispose(); 	 });
        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(e -> {
            Date deliveryDate = new Date(deliveryField.getText());
            Date paymentDate = new Date(paymentField.getText());
            orderController.setDates(deliveryDate, paymentDate);
            JOptionPane.showMessageDialog(this, "Order Is done");  
            orderController.completeOrder();});

        
        //Adds Panels
        buttonPanel.add(exitButton);
        buttonPanel.add(confirmButton);
        inputPanel.add(deliveryLabel);
        inputPanel.add(deliveryField);
        inputPanel.add(paymentLabel);
        inputPanel.add(paymentField);
        getContentPane().add(inputPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        // Visibility last 
        setVisible(true);
    }
}
