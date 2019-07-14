package com.rajmohan6.ems.cont;

public class Crud {
	JdbcConnection q = new JdbcConnection();
	public void create(int id,String name,String city) {
		String query = "INSERT INTO employee1 VALUES("+id+",'"+name+"','"+city+"')";
		q.dbConnect(query, 1);
	}
	
	public String readall() {
		String query = "select * from employee1";
		return q.dbConnect(query, 2);
	}
	
	public String readone(int id) {
		String query = "select * from employee1 where id="+id;
		return q.dbConnect(query, 3);
	}
	public String update(int id,String name,String city) {
		String query = "UPDATE employee1 set name='"+name+"',city='"+city+"' where id="+id;
		return q.dbConnect(query, 4);
	}
	
	public String delete(int id) {
		String query = "DELETE from employee1 WHERE id="+id;
		return q.dbConnect(query, 4);
	}
}