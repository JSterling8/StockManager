package controllers;

import java.util.ArrayList;

import models.Stock;
import models.Supplier;

public class StockController {
	
	public static ArrayList<Stock> stockList = new ArrayList<Stock>();
	
	public StockController(){
		stockList.add(new Stock("prod0", new Supplier("Supp1"), 1.1, 2.2, 0));
		stockList.add(new Stock("prod1", new Supplier("Supp2"), 1.1, 2.2, 1));
		stockList.add(new Stock("prod2", new Supplier("Supp3"), 1.1, 2.2, 2));
		stockList.add(new Stock("prod3", new Supplier("Supp4"), 1.1, 2.2, 3));
	}
	
}
