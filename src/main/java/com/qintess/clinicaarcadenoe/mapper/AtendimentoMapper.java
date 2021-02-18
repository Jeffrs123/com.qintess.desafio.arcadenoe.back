package com.qintess.clinicaarcadenoe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.qintess.clinicaarcadenoe.dto.request.AtendimentoDTO;
import com.qintess.clinicaarcadenoe.entity.Atendimento;

@Mapper
public interface AtendimentoMapper {

	AtendimentoMapper INSTANCE = Mappers.getMapper(AtendimentoMapper.class);
	@Mappings({
		@Mapping(target = "day", source = "day", dateFormat = "dd-MM-yyyy"),
		@Mapping(target = "startTime", source = "startTime", dateFormat = "HH:mm")
	})
	Atendimento toModel(AtendimentoDTO atendimentoDTO);

	AtendimentoDTO toDTO(Atendimento atendimento);
}
