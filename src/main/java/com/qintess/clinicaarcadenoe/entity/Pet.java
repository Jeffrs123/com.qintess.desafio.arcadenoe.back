package com.qintess.clinicaarcadenoe.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private String responsavel; 
	
	@Column(nullable = false)
	private int idade;
	
	@Column(nullable = false)
	private Especie especie;
	
	@Column(nullable = false)
	private Raca raca;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Atendimento> atendimentos;
}
