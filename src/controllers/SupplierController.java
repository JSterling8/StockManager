package controllers;

import java.util.ArrayList;

import models.Supplier;

public class SupplierController {

	public static ArrayList<Supplier> supplierList;	

	public SupplierController(){
		supplierList = new ArrayList<Supplier>();

		for(int i = 0; i < StockController.stockList.size(); i++){
			supplierList.add(StockController.stockList.get(i).getSupplier());
		}

	}
}
