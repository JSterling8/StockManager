package controllers;

import java.util.ArrayList;

public class UnitController {
	
	public static ArrayList<String> unitList;
	
	public UnitController(){
		unitList = new ArrayList<String>();
		for (int i = 0; i < StockController.stockList.size(); i++){
			unitList.add(ProductController.productList.get(i).getUnitType());
		}
	}
	
	public static void addUnit(String unit){
		boolean exists = false;
		for (int i = 0; i < unitList.size(); i++){
			if(unit.equals(unitList.get(i))){
				exists = true;
				break;
			}
		}
		
		if(!exists){
			unitList.add(unit);
		}
	}

}
