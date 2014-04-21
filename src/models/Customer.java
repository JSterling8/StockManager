package models;

public class Customer extends Company {
	
	public Customer(String name, long id) {
		super(name, id);
	}
	
	public String toString(){
		return getName();
	}
	
}
