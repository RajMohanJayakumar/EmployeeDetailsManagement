package com.rajmohan6.ems.cont;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class Controller {
	
	Crud c = new Crud();
	
	@RequestMapping(value="fetch/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String fetch(@PathVariable int id) {
		return c.readone(id);
	}
	
	@RequestMapping(value="/fetchall", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String fetchall() {
		return c.readall();
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void create(@RequestBody Empdetail emp) {
		c.create(emp.getId(),emp.getName(), emp.getCity());
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void update(@RequestBody Empdetail emp) {
		c.update(emp);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public void delete(int id) {
		c.delete(id);
	}

}
