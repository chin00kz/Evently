package com.customer;

public class Customer {
	private int id;
	private String username;
	private String name;
	private String password;
	private String phone_number;
	private String country;
	private String address;
	private String gender;
	
	
	public Customer(int id, String username, String name, String password, String phone_number, String country,
			String address, String gender) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.password = password;
		this.phone_number = phone_number;
		this.country = country;
		this.address = address;
		this.gender = gender;
	}


	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public String getCountry() {
		return country;
	}

	public String getAddress() {
		return address;
	}

	public String getGender() {
		return gender;
	}




}
