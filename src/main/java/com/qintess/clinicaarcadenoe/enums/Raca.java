package com.qintess.clinicaarcadenoe.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Raca {
	MALHADO("Gato"),
	LABRADOR("Cachorro"),
    PINTCHER("Cachorro");

    private final String description;
}
