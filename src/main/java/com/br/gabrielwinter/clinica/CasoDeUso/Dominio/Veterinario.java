package com.br.gabrielwinter.clinica.CasoDeUso.Dominio;

import lombok.Data;

@Data
public class Veterinario {
    private long id;
    private String crmv;
    private String nome;
    private String endereco;
    private String email;
    private String telefone;
    private String celular;
    private String cpf;
}
