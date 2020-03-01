package com.rajmohan6;

import com.rajmohan6.ems.cont.EmpDetail;

public class CurdLocalStorage {
	
	LocalStorageUtils localStorage = new LocalStorageUtils();
	
	public void create(EmpDetail emp) {
		localStorage.setEmpDetails(emp);
	}
	
	public String readall() {
		return localStorage.getAllEmpDetails();
	}
	
	public String readone(int id) {
		return localStorage.getEmpDetails(id);
	}
	public String update(EmpDetail emp) {
		localStorage.deleteEmpDetails(emp.getIdd());
		localStorage.setEmpDetails(emp);
		return readall();
	}
	
	public String delete(int id) {
		localStorage.deleteEmpDetails(id);
		return readall();
	}

}
