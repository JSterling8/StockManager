package controllers;

import java.util.ArrayList;

import models.Supplier;

public class SupplierController {

public static ArrayList<Supplier> supplierList;
	
	public SupplierController(){
		supplierList = new ArrayList<Supplier>();
		
		supplierList.add(new Supplier("Supplier 0", 0));
		supplierList.add(new Supplier("Supplier 1", 1));
		supplierList.add(new Supplier("Supplier 2", 2));
		supplierList.add(new Supplier("Supplier 3", 3));
		supplierList.add(new Supplier("Supplier 4", 4));
	}
	
}
