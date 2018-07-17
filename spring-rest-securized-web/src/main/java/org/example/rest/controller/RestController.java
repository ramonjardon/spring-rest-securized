package org.example.rest.controller;

import org.example.rest.model.Greeting;
import org.example.rest.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/api")
public class RestController {

	@Autowired
	private GreetingService service;
	
	@RequestMapping(value="/greeting",method=RequestMethod.GET)
	public  @ResponseBody Greeting sayHello(@RequestParam(value="name") String name) {
		return this.getService().sayHello(name);
	}

	public GreetingService getService() {
		return service;
	}
}
