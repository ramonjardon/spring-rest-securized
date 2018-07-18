package org.example.rest.controller;

import java.security.Principal;

import org.example.rest.model.Greeting;
import org.example.rest.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/api")
public class RestController {

	private final static Logger LOG = LoggerFactory.getLogger(RestController.class);
	@Autowired
	private GreetingService service;
	
	@RequestMapping(value="/greeting",method=RequestMethod.GET)
	public  @ResponseBody Greeting sayHello(@RequestParam(value="name") String name,Principal principal) {
		if(null != principal && null != principal.getName()) {
			LOG.info("User " + principal.getName());
		}
		return this.getService().sayHello(name);
	}

	public GreetingService getService() {
		return service;
	}
}
