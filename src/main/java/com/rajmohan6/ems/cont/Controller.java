package com.rajmohan6.ems.cont;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employeeDetails.CurdLocalStorage;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class Controller {
	
//	Crud c = new Crud();
	CurdLocalStorage c = new CurdLocalStorage();
	
	@RequestMapping(value="fetch/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String fetch(@PathVariable int id) {
		System.out.println(c.readone(id));
		return c.readone(id);
	}
	
	@RequestMapping(value="/fetchall", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String fetchall() {
		System.out.println(c.readall());
		return c.readall();
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String create(@RequestBody EmpDetail emp) {
		System.out.println(emp);
		c.create(emp);
		return "redirect:https://www.google.com";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void update(@RequestBody EmpDetail emp) {
		System.out.println(emp.getCity());
		c.update(emp);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public void delete(int id) {
		System.out.println(id);
		c.delete(id);
	}

}
