package controllers;


import java.util.ArrayList;

public class ProductController {
public static ArrayList<String> productList = new ArrayList<String>();
	
	public ProductController(){
		for(int i = 0; i < StockController.stockList.size(); i++){
			productList.add(StockController.stockList.get(i).getProductName());
		}

	}
	
}
