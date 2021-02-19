package com.qintess.clinicaarcadenoe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.qintess.clinicaarcadenoe.dto.request.PetDTO;
import com.qintess.clinicaarcadenoe.entity.Pet;

@Mapper
public interface PetMapper {

	PetMapper INSTANCE = Mappers.getMapper(PetMapper.class);
	
	Pet toModel(PetDTO petDTO);
	
	PetDTO toDTO(Pet pet);
}
