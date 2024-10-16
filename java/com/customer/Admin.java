package com.customer;

public class Admin {
	private int id;
	private String name;
	private String username;
	private String password;
	
	public Admin(int id, String name, String username, String password) {
		super();
		this.id = id;
		this.name =name;
		this.username=username;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}

}
