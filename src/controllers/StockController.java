package controllers;

import java.util.ArrayList;

import models.Stock;
import models.Supplier;

public class StockController {
	
	public static ArrayList<Stock> stockList = new ArrayList<Stock>();
	
	public StockController(){
		for (int i = 1; i < 5; i ++){
			Stock stock = new Stock ("prod" + i, new Supplier("Supp" + i, "phone" + i, "email" + i, "addr" + i, i), i, i, i*2, i);
			stockList.add(stock);
		}
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
		for (int j = stockList.size()-1; j >= 0; j--){
			if (stockList.get(j).getQuantity() == 0){
				stockList.remove(j);
			}
		}
	}
	
}
