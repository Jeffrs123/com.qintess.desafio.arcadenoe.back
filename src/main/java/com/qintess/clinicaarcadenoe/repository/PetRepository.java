package com.qintess.clinicaarcadenoe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.clinicaarcadenoe.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{

}
