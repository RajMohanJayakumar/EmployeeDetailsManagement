package com.employeeDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.rajmohan6.ems.cont.*;

public class LocalStorageUtils {
	
	LocalStorageUtils instance = null;
	public Object getInstance() {
		
		if(instance == null) {
			instance = new LocalStorageUtils();
		}
		
		return instance;
	}
	private Map<Integer,EmpDetail> empDetails = new HashMap<>();
	
	public String getEmpDetails(int id) {
		JSONArray array = new JSONArray();
		JSONObject empObj = new JSONObject();
		
		empObj.put("id", empDetails.get(id).getId());
		empObj.put("name", empDetails.get(id).getName());
		empObj.put("city", empDetails.get(id).getCity());
		array.add(empObj);
		System.out.println(array);
		
		return array.toString();
	}
	
	public void setEmpDetails(EmpDetail empDetail) {
		empDetails.put(empDetail.getId(),empDetail);
	}
	
	public void deleteEmpDetails(int id) {
		empDetails.remove(id);
	}
	
	public String getAllEmpDetails() {
		
		
		JSONArray array = new JSONArray();
		
		for(EmpDetail eachEmp : empDetails.values()) {
			JSONObject empObj = new JSONObject();
			
			empObj.put("id", eachEmp.getId());
			empObj.put("name", eachEmp.getName());
			empObj.put("city", eachEmp.getCity());
			array.add(empObj);
			
		}
		System.out.println(array);
		return array.toString();
	}
}
