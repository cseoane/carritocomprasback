package com.example.carritocomprasback;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@RequestMapping(value = "/API", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String api() {
		return "{\"response\":\"Mi string\"}";
	}

}