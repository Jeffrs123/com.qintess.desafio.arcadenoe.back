package com.qintess.clinicaarcadenoe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.clinicaarcadenoe.dto.reponse.MessageResponseDTO;
import com.qintess.clinicaarcadenoe.dto.request.AtendimentoDTO;
import com.qintess.clinicaarcadenoe.service.AtendimentoService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://arcadenoecliente.herokuapp.com"})
@RequestMapping("/api/v1/atendimento")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AtendimentoController {

	private AtendimentoService atendimentoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody @Valid AtendimentoDTO atendimentoDTO) {
		return atendimentoService.create(atendimentoDTO);
	}

	@GetMapping
	public List<AtendimentoDTO> listAll() {
		return atendimentoService.listAll();
	}
}
