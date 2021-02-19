package com.qintess.clinicaarcadenoe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.clinicaarcadenoe.dto.reponse.MessageResponseDTO;
import com.qintess.clinicaarcadenoe.dto.request.PetDTO;
import com.qintess.clinicaarcadenoe.service.PetService;

import lombok.AllArgsConstructor;
import com.qintess.clinicaarcadenoe.exception.PetNotFoundException;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://arcadenoecliente.herokuapp.com"})
@RequestMapping("/api/v1/pet")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PetController {

	private PetService petService;
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid PetDTO petDTO) {
        return petService.create(petDTO);
    }
	
	@GetMapping
	public List<PetDTO> listAll() {
		return petService.listAll();
	}
	
	@GetMapping("/{id}")
    public PetDTO findById(@PathVariable Long id) throws PetNotFoundException {
        return petService.findById(id);
    }
	
	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PetNotFoundException {
    	petService.delete(id);
    }
	
	@PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PetDTO personDTO) throws PetNotFoundException {
        return petService.updateById(id, personDTO);
    }
}
