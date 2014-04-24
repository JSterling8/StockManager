package models;

public abstract class Company {

	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private long id;
	
	public Company(String name, String phoneNumber, String email, String address, long id){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.id = id;
	}
	
	public String toString(){
		return name;
	}
	
	public long getId(){
		return id;
	}
	
	public String getCompanyName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}
	
	public String getEmail() {
		return email;
	}
	
}
