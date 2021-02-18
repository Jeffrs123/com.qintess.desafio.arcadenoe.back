package com.qintess.clinicaarcadenoe.dto.request;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.qintess.clinicaarcadenoe.enums.Especie;
import com.qintess.clinicaarcadenoe.enums.Raca;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {

	private Long id;
	@NotEmpty
	@Size(min = 2, max = 100)
	private String nome;
	@NotEmpty
	@Size(min = 2, max = 100)
	private int idade;
	@Enumerated(EnumType.STRING)
	private Especie especie;
	@Enumerated(EnumType.STRING)
	private Raca raca;
	@Valid
	@NotEmpty
	private List<AtendimentoDTO> atendimentos;

}
