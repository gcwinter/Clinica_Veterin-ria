package com.br.gabrielwinter.clinica.CasoDeUso.Dominio;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereço;
    private List<Animal> animais = new ArrayList<>();


}
