package com.rajmohan6.ems.cont;

public class Crud {
	JdbcConnection q = new JdbcConnection();
	public void create(Empdetail emp) {
		String query = "INSERT INTO employee1 VALUES("+emp.getId()+",'"+emp.getName()+"','"+emp.getCity()+"')";
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
	public String update(Empdetail emp) {
		String query = "UPDATE employee1 set id="+emp.getId()+",name='"+emp.getName()+"',city='"+emp.getCity()+"' where id="+emp.getIdd();
		return q.dbConnect(query, 1);
	}
	
	public String delete(int id) {
		String query = "DELETE from employee1 WHERE id="+id;
		return q.dbConnect(query, 1);
	}
}