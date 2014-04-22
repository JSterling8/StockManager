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
	
	public static void addSupplier(Supplier supplier){
		for(int i = 0; i < supplierList.size(); i++){
			if (!supplierList.get(i).toString().equalsIgnoreCase(supplier.toString())){
				supplierList.add(supplier);
			}
		}
	}
}
