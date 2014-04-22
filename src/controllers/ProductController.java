package controllers;


import java.util.ArrayList;

public class ProductController {
	public static ArrayList<String> productList = new ArrayList<String>();

	public ProductController(){
		for(int i = 0; i < StockController.stockList.size(); i++){
			productList.add(StockController.stockList.get(i).getProductName());
		}
	}

	public static String addProduct(String productName){
		boolean exists = false;
		
		// Loop through the product list and see if the product already exists.
		for(int i = 0; i < productList.size(); i++){
			if (productList.get(i).equalsIgnoreCase(productName)){
				exists = true;
			}
		}
		// If it doesn't exist in the product list, then add it.
		if (!exists){
			productList.add(productName);
			return "Product added.";
		}
		else {
			return "This product is already in the product list";
		}
		
	}



}
