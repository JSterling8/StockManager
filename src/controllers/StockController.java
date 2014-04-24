package controllers;

import java.util.ArrayList;

import models.Stock;
import models.Supplier;

public class StockController {
	
	public static ArrayList<Stock> stockList = new ArrayList<Stock>();
	
	public StockController(){
		stockList.add(new Stock("prod0", new Supplier("Supp0", 0), 1.1, 1.2, 2, 0));
		stockList.add(new Stock("prod1", new Supplier("Supp1", 1), 2.1, 2.2, 3, 1));
		stockList.add(new Stock("prod2", new Supplier("Supp2", 2), 3.1, 3.2, 4, 2));
		stockList.add(new Stock("prod3", new Supplier("Supp3", 3), 4.1, 4.2, 5, 3));
	}
	
	public static void removeStock(ArrayList<Stock> stockToRemove){		
		// Loop through the stocks to remove.
		for (int i = 0; i < stockToRemove.size(); i++){
			// Loop through the stock list.
			for (int j = 0; j < stockList.size(); j++){
				// If the stock to remove's ID matches a stock ID in the list.
				if (stockToRemove.get(i).getId() == stockList.get(j).getId()){
					// Remove the specified amount of product.
					stockList.get(j).removeProduct(stockToRemove.get(i).getQuantity());
				}
			}
		}
		
		// Remove any stocks with a quantity of 0.
		for (Stock stock : stockList){
			if (stock.getQuantity() == 0){
				stockList.remove(stock);
			}
		}
	}
	
}
