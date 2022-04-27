package com.br.gabrielwinter.clinica.CasoDeUso.Dominio;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agenda {

    private long id;
    private LocalDateTime data;
    Veterinario veterinario;
    Animal animal;
    Cliente cliente;
}
