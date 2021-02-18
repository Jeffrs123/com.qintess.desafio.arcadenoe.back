package com.qintess.clinicaarcadenoe.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = {
//		"http://localhost:4200", 
//		"https://arcadenoecliente.herokuapp.com"
//})
@RestController
@CrossOrigin(origins = "https://arcadenoecliente.herokuapp.com")
@RequestMapping("/api/v1/pet")
public class PetController {

	@GetMapping
	public String getTest() {
		return "Teste Controller - Está funcionando";
	}
}
