package org.example.rest.service;

import org.example.rest.model.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

	@Override
	public Greeting sayHello(String name) {
		
		return new Greeting(name);
	}

}
