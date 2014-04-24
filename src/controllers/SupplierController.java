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
	
	// TODO Add address and other info as well.
	public static String addSupplier(String name, String phone, String email, String address ){
		boolean exists = false;
		
		// Loop through the product list and see if the product already exists.
		for(int i = 0; i < supplierList.size(); i++){
			if (supplierList.get(i).toString().equalsIgnoreCase(name)){
				exists = true;
			}
		}
		// If it doesn't exist in the product list, then add it.
		if (!exists){
			long idToAdd;
			if (supplierList.size() == 0){
				idToAdd = 0;
			}
			else{
				idToAdd = supplierList.get(supplierList.size()-1).getId() + 1;
			}
			Supplier supplierToAdd = new Supplier(name, phone, email, address, idToAdd);
			supplierList.add(supplierToAdd);
			return "Supplier added.";
		}
		else {
			return "This supplier is already in the supplier list";
		}
	}
}
