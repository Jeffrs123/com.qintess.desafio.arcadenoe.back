package com.qintess.clinicaarcadenoe.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.qintess.clinicaarcadenoe.enums.StatusAtendimento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Atendimento {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private LocalDate day;
	@Column(nullable = false)
	private LocalTime startTime;
	@Column(nullable = false)
	private LocalTime endTime;
	@Column(nullable = true)
	private String diagnostico;
	@Column(nullable = true)
	private String tratamento;
	@Column(nullable = false)
	private String veterinario;
	@Column(nullable = false)
	private String dono;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Pet pet;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StatusAtendimento status;
}
