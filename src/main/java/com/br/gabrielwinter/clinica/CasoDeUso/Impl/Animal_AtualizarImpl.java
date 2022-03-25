package com.br.gabrielwinter.clinica.CasoDeUso.Impl;

import com.br.gabrielwinter.clinica.CasoDeUso.Animal_Atualizar;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Animal;
import com.br.gabrielwinter.clinica.CasoDeUso.gateway.AnimalRepositoryGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class Animal_AtualizarImpl implements Animal_Atualizar {

    private final AnimalRepositoryGateway animalRepositoryGateway;

    @Override
    public Animal exec(Animal animal) {
        return animalRepositoryGateway.atualizar(animal);
    }
}
