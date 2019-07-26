package com.rajmohan6.ems.cont;
import java.sql.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

class JdbcConnection{  
public String dbConnect(String query,int a){  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/empdetails","root","root");  

switch(a) {
case 1:
{
	Statement stmt=con.createStatement();  
	stmt.executeUpdate(query);
	con.close();
	return "";
}
case 2:
{
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery(query);
	//StringBuilder str = new StringBuilder();
	//str.append("[");
	JSONArray array = new JSONArray();
	while(rs.next()) {
		JSONObject obj = new JSONObject();
		obj.put("id", rs.getString(1));
		obj.put("name", rs.getString(2));
		obj.put("city", rs.getString(3));
		array.add(obj);
		
		//str.append("{'id':'"+rs.getString(1)+"','name':'"+rs.getString(2)+"','City':'"+rs.getString(3)+"'},");		
	}
	String str = array.toJSONString();
	//str.append("]");
	con.close();
	return str;
}
case 3:{
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery(query);
	rs.next();
	JSONArray array = new JSONArray();
	JSONObject obj = new JSONObject();	
		obj.put("id", rs.getString(1));
		obj.put("name", rs.getString(2));
		obj.put("city", rs.getString(3));
		array.add(obj);
		String str = array.toJSONString();
	con.close(); 
	return str;
}
case 4:{
	Statement stmt=con.createStatement();  
	stmt.executeUpdate(query);
	con.close();
	return "";
}
//case 6:{
//	JSONArray array = new JSONArray();
//	JSONObject obj = new JSONObject();
//	
//	obj.put("id", rs.getString(1));
//	obj.put("name", rs.getString(2));
//	obj.put("city", rs.getString(3));
//	array.add(obj);
//	String Str = array.toString();
//}
}
}catch(Exception e){ System.out.println(e);}
return null;  
}  
}  