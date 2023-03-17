package gui;
import javax.swing.*;

import Controller.ProductController;
import Controller.SalesOrderController;
import Controller.SalesOrderControllerIF;
import Model.OrderLine;
import Model.Product;
import Model.SalesOrder;

import java.awt.*;
import java.awt.event.*;

public class AddProduct extends JFrame {
	//Fields 
	int totalPrice = 0;
	SalesOrderController salesController = new SalesOrderController();
	ProductController productController = new ProductController();
	//List is made outside method so its accessible to all methods
	DefaultListModel listModel = new DefaultListModel<>();
	JList<String> list = new JList<>(listModel);
	
    public AddProduct() {
        setTitle("Products");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        String totalPriceText = "Total: " + totalPrice +" DKK";
        
        
        //List Stuff
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Can only select one at the time
        add(new JScrollPane(list), BorderLayout.CENTER); //Makes it possible to go out of bounds
        
        //Panels
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel lowRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        //Label
        JLabel totalDKK = new JLabel(totalPriceText);
        
        //Buttons + functionality
        JButton addButton = new JButton("Add new"); // Add new product, called append as to avoid confusion with class name and main method
        addButton.addActionListener(e -> {
        appendProduct();
        totalDKK.setText(totalPriceText);});
        	
        
        JButton deleteButton = new JButton("Delete");//Delete a single product
        deleteButton.addActionListener(e -> deleteSingle());
        
        JButton backButton = new JButton("Exit"); //Go back to last screen
        backButton.addActionListener(e -> goBack());
        
        JButton clearButton = new JButton("Clear"); //Clears the whole list, with a warning first as to avoid misclicks
        clearButton.addActionListener(e -> clearList());
        
        JButton confirmButton = new JButton("Confirm"); //Confirms that these product are all thats needed.
        confirmButton.addActionListener(e -> confirm());
        
        
        //Add panels
        //Add, Delete.
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        // Back, clear.
        bottomPanel.add(totalDKK, BorderLayout.CENTER);
        bottomPanel.add(lowRightPanel, BorderLayout.EAST);
        lowRightPanel.add(backButton);
        lowRightPanel.add(clearButton);
        lowRightPanel.add(confirmButton);
        
        add(bottomPanel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.EAST);
        
        //Makes frame visible, is last to avoid certain problems
        setVisible(true);
    }
    

	public void appendProduct() { /////WORKS
    	String newProduct = JOptionPane.showInputDialog(AddProduct.this, "Enter product name:");
    	if (newProduct != null && !newProduct.isEmpty()) {
    	Product product = productController.findProduct(newProduct);
    	 if (product != null) {
    	 String quantityString = JOptionPane.showInputDialog(AddProduct.this, "Enter amount:");
    	   if (quantityString != null && !quantityString.isEmpty()) {
    	     try {
    	       int amount = Integer.parseInt(quantityString);
    	       int price = product.getSalesPrice();
    	       salesController.findAndAddProduct(product.getName(), amount,price);
    	       int ProductTotalPrice = amount * price;
    	       String ProductText = newProduct + " x" + amount + " (" + price + " each) = DKK." + ProductTotalPrice;
    	       listModel.addElement(ProductText);
    	       totalPrice += ProductTotalPrice;
    	       
    	         } catch (NumberFormatException ex) {
    	                JOptionPane.showMessageDialog(AddProduct.this, "Invalid Amount.");
    	            }
    	        }
    	    } else {
    	        JOptionPane.showMessageDialog(AddProduct.this, "Product does not exist in database.");
    	    }
    	}}
    
	 private void confirm() { //Checks that atleast 1 product is added, else it wont allow.
		if(listModel.getSize()>0) {
			salesController.setTotalPrice(totalPrice);
			EndOrder endOrder = new EndOrder();
		}
		else JOptionPane.showMessageDialog(null, "Please add products before continuing.");
		}

	public void deleteSingle() {
    	int selectedIndex = list.getSelectedIndex();
        if (selectedIndex != -1) {
            listModel.remove(selectedIndex);
        }
    }
	
    
    public void goBack() {
    dispose();
    }
    
    public void clearList() {
    	int result = JOptionPane.showConfirmDialog(AddProduct.this, "Are you sure you want to clear the list?", "Confirm clear", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            listModel.clear();
        }
    }
}
