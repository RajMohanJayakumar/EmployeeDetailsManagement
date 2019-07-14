package com.rajmohan6.ems.cont;
import javax.ws.rs.Consumes;
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
	Empdetail empp = new Empdetail();
	
	@RequestMapping("fetch/{id}")
	public String fetch(@PathVariable int id) {
		return c.readone(id);
	}
	
	@RequestMapping("/fetchall")
	public String fetchall() {
		return c.readall();
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public void create(Empdetail emp) {
		c.create(emp.getId(),emp.getName(), emp.getCity());
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public void update(Empdetail emp) {
		c.update(emp.getId(), emp.getName(), emp.getCity());
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public void delete(int id) {
		c.delete(id);
	}

}
