package models;

public class Supplier extends Company {
	
	private String name;
	
	public Supplier(String name){
		super();
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

}
