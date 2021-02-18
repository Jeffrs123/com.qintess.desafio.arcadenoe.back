package com.qintess.clinicaarcadenoe.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusAtendimento {
	MARCADO,
    CANCELADO,
    EMESPERA,
    EMATENDIMENTO,
    FINALIZADO;

}
