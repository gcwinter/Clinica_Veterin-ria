package com.br.gabrielwinter.clinica.CasoDeUso.Impl;

import com.br.gabrielwinter.clinica.CasoDeUso.Animal_Buscar;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Animal;
import com.br.gabrielwinter.clinica.CasoDeUso.gateway.AnimalRepositoryGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class Animal_BuscarImpl implements Animal_Buscar {

    private final AnimalRepositoryGateway animalRepositoryGateway;

    @Override
    public Animal exec(Animal animal) {

        return animalRepositoryGateway.buscar(animal);
    }
}
