package controllers;

import java.util.ArrayList;

import models.Product;
import models.Stock;
import models.Supplier;

public class StockController {
	
	// The master stockList used throughout the application.
	public static ArrayList<Stock> stockList = new ArrayList<Stock>();
	
	/**
	 * Initializes the stockList.
	 * This should only be called from the MainGUI.
	 */
	public StockController(){
		// Adds mock data to the stockList.
		// TODO Get this information from a database.
		for (int i = 1; i < 5; i ++){
			Product product = new Product("prod" + i, "units" + i);
			Supplier supplier = new Supplier("Supp" + i, "phone" + i, "email" + i, "addr" + i, i);
			Stock stock = new Stock (product, supplier, i, i, i*2, i);
			stockList.add(stock);
		}
	}
	
	/**
	 * Removes one or many stocks from the master stockList.
	 * If all of a stock is being removed, then the stock is deleted from the list.
	 * This method's complexity is O(n^2)
	 * 
	 * @param stockToRemove An ArrayList of Stocks to remove.
	 */
	public static void removeStock(ArrayList<Stock> stockToRemove){
		// Loop through the stocks to remove.
		for (int i = 0; i < stockToRemove.size(); i++){
			// Loop through the master stockList.
			for (int j = 0; j < stockList.size(); j++){
				// If the stock to remove's ID matches a stock ID in the list.
				if (stockToRemove.get(i).getId() == stockList.get(j).getId()){
					// Remove the specified amount of product.
					stockList.get(j).removeProduct(stockToRemove.get(i).getQuantity());
				}
			}
		}
		
		// Remove any stocks with a quantity of 0.
		for (int j = stockList.size()-1; j >= 0; j--){
			if (stockList.get(j).getQuantity() == 0){
				stockList.remove(j);
			}
		}
	}
}
