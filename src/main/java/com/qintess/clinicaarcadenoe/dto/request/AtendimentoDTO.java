package com.qintess.clinicaarcadenoe.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.qintess.clinicaarcadenoe.enums.StatusAtendimento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AtendimentoDTO {
	
	private Long id;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String day;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String startTime;
	
	private String endTime;
	
	@NotEmpty
	@Size(min = 2, max = 500)
	private String diagnostico;
	
	@NotEmpty
	@Size(min = 2, max = 500)
	private String tratamento;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String veterinario;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String dono;
	
	@Valid
    @NotEmpty
	private PetDTO pet;
	
	 @Enumerated(EnumType.STRING)
	private StatusAtendimento status;
}
