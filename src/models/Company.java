package models;

public abstract class Company {

	private String name;
	private long id;
	
	public Company(String name, long id){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
}
