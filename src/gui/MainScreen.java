package gui;
import javax.swing.*;

import Controller.SalesOrderController;
import Model.SalesOrder;

import java.awt.*;

public class MainScreen extends JFrame {
	 SalesOrderController orderControl = new SalesOrderController();  
    public MainScreen() {
    	setTitle("Main screen");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Panels
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        JPanel exitPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        exitPanel.setLayout(new BorderLayout());
        
        //Buttons and associated labels + functionality 
        JButton BTNOrder = new JButton("Make order");
        BTNOrder.setPreferredSize(new Dimension(100, 20));
        BTNOrder.addActionListener(e -> makeOrder());
        JLabel LBLOrder = new JLabel("Make a new order");
        buttonPanel.add(BTNOrder);
        buttonPanel.add(LBLOrder);
        
        JButton BTNCustomer = new JButton("Add customer");
        BTNCustomer.setPreferredSize(new Dimension(100, 20));
        BTNCustomer.addActionListener(e -> newCustomer());
        JLabel LBLCustomer = new JLabel("Add a new customer to system");
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        buttonPanel.add(BTNCustomer);
        buttonPanel.add(LBLCustomer);
        
        JButton BTNSupplier = new JButton("See suppliers");
        BTNSupplier.setPreferredSize(new Dimension(100, 20));
        JLabel LBLSupplier = new JLabel("See all suppliers");
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        buttonPanel.add(BTNSupplier);
        buttonPanel.add(LBLSupplier);
        
        JButton BTNAllCustomer = new JButton("See customers");
        BTNAllCustomer.setPreferredSize(new Dimension(100, 20));
        JLabel LBLAllCustomer = new JLabel("See all customers");
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        buttonPanel.add(BTNAllCustomer);
        buttonPanel.add(LBLAllCustomer);
        
        JButton BTNAllOrder = new JButton("See orders");
        BTNAllOrder.setPreferredSize(new Dimension(100, 20));
        JLabel LBLAllOrder = new JLabel("See all orders");
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        buttonPanel.add(BTNAllOrder);
        buttonPanel.add(LBLAllOrder);
        
        JButton exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(100, 30));
        exitButton.addActionListener(e -> System.exit(0));
        
        //Add Panels 
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(exitPanel, BorderLayout.SOUTH);
        exitPanel.add(exitButton, BorderLayout.EAST);
        
        add(mainPanel);
        
        //Makes frame visible, is last to avoid certain problems
        setVisible(true);
    }
    
    private void makeOrder() {
    	orderControl.createOrder();
    	new CustomerOrder();
    }
    
    private void newCustomer() {
    	new NewCustomer();
	}

	public static void main(String[] args) {
        new MainScreen();
    }
}
