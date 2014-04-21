package controllers;

import java.util.ArrayList;

import models.Supplier;

public class SupplierController {

public static ArrayList<Supplier> supplierList;
	
	public SupplierController(){
		supplierList = new ArrayList<Supplier>();
		
		supplierList.add(new Supplier("Supplier 1"));
		supplierList.add(new Supplier("Supplier 2"));
		supplierList.add(new Supplier("Supplier 3"));
		supplierList.add(new Supplier("Supplier 4"));
		supplierList.add(new Supplier("Supplier 5"));
	}
	
}
