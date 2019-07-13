package com.rajmohan6.ems.cont;
import javax.ws.rs.Produces;

import org.springframework.http.MediaType;
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
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public String fetch(@PathVariable int id) {
		return c.readone(id);
	}
	
	@RequestMapping("/fetchall")
	public String fetchall() {
		return c.readall();
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public void create(int id,String name,String city) {
		c.create(id, name, city);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public void update(int id,String name,String city) {
		c.update(id, name, city);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public void delete(int id) {
		c.delete(id);
	}

}
