package com.rajmohan6.ems.cont;

public class EmpDetail {
	private int id;
	private String name;
	private String city;
	private int idd;
	
	public EmpDetail() {
		
	}
	
	public EmpDetail(int id, String name, String city, int idd) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.idd = idd;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getIdd() {
		return idd;
	}
	public void setIdd(int idd) {
		this.idd = idd;
	}
	
	
}
