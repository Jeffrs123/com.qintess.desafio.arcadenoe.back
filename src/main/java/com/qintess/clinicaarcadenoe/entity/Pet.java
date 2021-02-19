package com.qintess.clinicaarcadenoe.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.qintess.clinicaarcadenoe.enums.Especie;
import com.qintess.clinicaarcadenoe.enums.Raca;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = true)
	private String nome2;
	
	@Column(nullable = true)
	private String dono; 
	
	@Column(nullable = false)
	private int idade;
	
//	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Especie especie;
	
//	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Raca raca;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Atendimento> atendimentos;
}
