package com.rajmohan6.ems.cont;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class Controller {
	
	Crud c = new Crud();
	
	@RequestMapping("fetch/{id}")
	public String fetch(@PathVariable int id) {
		return c.readone(id);
	}
	
	@RequestMapping("/fetchall")
	public String fetchall() {
		return c.readall();
	}
	
	@RequestMapping(value="/create/{id}/{name}/{city}",method=RequestMethod.POST)
	public void create(@PathVariable int id,@PathVariable String name,@PathVariable String city) {
		c.create(id, name, city);
	}
	
	@RequestMapping(value="/update/{id}/{name}/{city}",method=RequestMethod.PUT)
	public void update(@PathVariable int id,@PathVariable String name,@PathVariable String city) {
		c.update(id, name, city);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		c.delete(id);
	}

}
