package com.qintess.clinicaarcadenoe.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.clinicaarcadenoe.dto.reponse.MessageResponseDTO;
import com.qintess.clinicaarcadenoe.dto.request.AtendimentoDTO;
import com.qintess.clinicaarcadenoe.entity.Atendimento;
import com.qintess.clinicaarcadenoe.exception.AtendimentoNotFoundException;
import com.qintess.clinicaarcadenoe.mapper.AtendimentoMapper;
import com.qintess.clinicaarcadenoe.repository.AtendimentoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AtendimentoService {

	private AtendimentoRepository atendimentoRepository;

    private final AtendimentoMapper atendimentoMapper = AtendimentoMapper.INSTANCE;
    
    public MessageResponseDTO create(AtendimentoDTO itemDTO) {
    	Atendimento itemToSave = atendimentoMapper.toModel(itemDTO);

    	Atendimento savedItem = atendimentoRepository.save(itemToSave);
        return createMessageResponse(savedItem.getId(), "Created Atendimento with ID ");
    }

    public List<AtendimentoDTO> listAll() {
        List<Atendimento> allPeople = atendimentoRepository.findAll();
        return allPeople.stream()
                .map(atendimentoMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    private Atendimento verifyIfExists(Long id) throws AtendimentoNotFoundException {
        return atendimentoRepository.findById(id)
                .orElseThrow(() -> new AtendimentoNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
