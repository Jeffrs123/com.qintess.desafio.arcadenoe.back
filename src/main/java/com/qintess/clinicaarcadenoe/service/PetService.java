package com.qintess.clinicaarcadenoe.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.clinicaarcadenoe.dto.reponse.MessageResponseDTO;
import com.qintess.clinicaarcadenoe.dto.request.PetDTO;
import com.qintess.clinicaarcadenoe.entity.Pet;
import com.qintess.clinicaarcadenoe.mapper.PetMapper;
import com.qintess.clinicaarcadenoe.repository.PetRepository;

import lombok.AllArgsConstructor;
import com.qintess.clinicaarcadenoe.exception.PetNotFoundException;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PetService {

	private PetRepository petRepository;

	private final PetMapper petMapper = PetMapper.INSTANCE;

	public MessageResponseDTO create(PetDTO itemDTO) {
		Pet itemToSave = petMapper.toModel(itemDTO);
		Pet savedItem = petRepository.save(itemToSave);
		return createMessageResponse(savedItem.getId(), "Created pet with ID ");
	}

	public List<PetDTO> listAll() {
		List<Pet> allPeople = petRepository.findAll();
		return allPeople.stream()
				.map(petMapper::toDTO)
				.collect(Collectors.toList());
	}

	public PetDTO findById(Long id) throws PetNotFoundException {
		Pet pet = verifyIfExists(id);

		return petMapper.toDTO(pet);
	}
	
	private Pet verifyIfExists(Long id) throws PetNotFoundException {
		return petRepository.findById(id)
				.orElseThrow(() -> new PetNotFoundException(id));
	}

	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO
				.builder()
				.message(message + id)
				.build();
	}

}
