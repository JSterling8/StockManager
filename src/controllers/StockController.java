package controllers;

import java.util.ArrayList;

import models.Stock;
import models.Supplier;

public class StockController {
	
	public static ArrayList<Stock> stockList = new ArrayList<Stock>();
	
	public StockController(){
		for (int i = 0; i < SupplierController.supplierList.size(); i ++){
			stockList.add(new Stock("prod" + i, SupplierController.supplierList.get(i), i, i, i, i));
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
		for (Stock stock : stockList){
			if (stock.getQuantity() == 0){
				stockList.remove(stock);
			}
		}
	}
	
}
