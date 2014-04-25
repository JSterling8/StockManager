package controllers;


import java.util.ArrayList;

import models.Product;

public class ProductController {
	// The master productList used throughout the application.
	public static ArrayList<Product> productList = new ArrayList<Product>();

	/**
	 * Initializes the productList.
	 * This should only be called from the MainGUI.
	 */
	public ProductController(){
		// Adds mock data to the productList based off of what stock is available.
		// TODO pull this date from a database.
		for(int i = 0; i < StockController.stockList.size(); i++){
			Product product = StockController.stockList.get(i).getProduct();
			productList.add(product);
		}
	}

	
	/**
	 *	This method adds a single product to the master productList.
	 * 
	 * 	@param productName The name of the product to add to the master productList.
	 *  @return Either a success or failure String to be used in a popup to inform the user of what's happened.
	 */
	public static String addProduct(Product product){
		// A boolean variable to see if the product name already exists.
		boolean exists = false;
		
		// Loop through the product list and see if the product already exists.
		for(int i = 0; i < productList.size(); i++){
			if (productList.get(i).getName().equalsIgnoreCase(product.getName())){
				exists = true;
			}
		}
		// If the product doesn't exist in the product list, then add it.
		if (!exists){
			productList.add(product);
			return "Product added.";
		}
		else {
			return "This product is already in the product list";
		}
		
	}
}
