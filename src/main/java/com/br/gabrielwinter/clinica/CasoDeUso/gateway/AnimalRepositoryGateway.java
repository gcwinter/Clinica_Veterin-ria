package com.br.gabrielwinter.clinica.CasoDeUso.gateway;

import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Animal;

public interface AnimalRepositoryGateway {
    Animal cadastar(Long id,Animal animal);
    Animal deletar(Animal animal);
    Animal atualizar(Animal animal);
    Animal buscar(Animal animal);


}
