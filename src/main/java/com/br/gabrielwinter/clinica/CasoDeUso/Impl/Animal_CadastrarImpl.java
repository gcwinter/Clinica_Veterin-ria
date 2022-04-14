package com.br.gabrielwinter.clinica.CasoDeUso.Impl;

import com.br.gabrielwinter.clinica.CasoDeUso.Animal_Cadastrar;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Animal;
import com.br.gabrielwinter.clinica.CasoDeUso.gateway.AnimalRepositoryGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class Animal_CadastrarImpl implements Animal_Cadastrar {

    private final AnimalRepositoryGateway animalRepositoryGateway;

    @Override
    public Animal exec(Long id,Animal animal) {
        return animalRepositoryGateway.cadastar(id, animal);
    }
}
