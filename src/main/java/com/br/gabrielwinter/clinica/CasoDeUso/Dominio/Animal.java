package com.br.gabrielwinter.clinica.CasoDeUso.Dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    private long id;
    private Cliente cliente;
    private String nome;
    private String tipo;
    private long peso;
    private long idade;
}
