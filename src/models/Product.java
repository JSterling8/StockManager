package models;

public class Product {

	private String name;
	private String unitType;
	
	public Product (String name, String unitType){
		this.name = name;
		this.unitType = unitType;
	}
	
	public String getName() {
		return name;
	}
	public String getUnitType() {
		return unitType;
	}
	
}
