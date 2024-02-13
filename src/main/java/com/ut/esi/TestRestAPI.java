package com.ut.esi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestAPI {
	@GetMapping("/esi")
	public String helloWorld(){
		return "Welcome to the ESI course!";
	}
}
