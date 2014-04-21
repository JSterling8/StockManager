package models;

public class Supplier extends Company {
	
	private String name;
	private long id;
	
	public Supplier(String name, long id){
		super();
		this.name = name;
		this.id = id;
	}
	
	public String getName(){
		return name;
	}

}
