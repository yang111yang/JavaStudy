package com.liu.pojo;

public class Address {
	private String prev;
	private String city;
	private String town;
	public String getPrev() {
		return prev;
	}
	public void setPrev(String prev) {
		this.prev = prev;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	@Override
	public String toString() {
		return "Address [prev=" + prev + ", city=" + city + ", town=" + town + "]";
	}
	public Address(String prev, String city, String town) {
		super();
		this.prev = prev;
		this.city = city;
		this.town = town;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
