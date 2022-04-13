package com.br.gabrielwinter.clinica.Controller.DTO;

import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Animal;
import com.br.gabrielwinter.clinica.Repository.entidade.AnimalDAO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {
    private long id;
    private String nome;
    private String tipo;
    private long peso;
    private long idade;

    }

