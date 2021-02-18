package com.qintess.clinicaarcadenoe.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Especie {
	GATO("Gato"),
    CACHORRO("Cachorro");

    private final String description;
}
