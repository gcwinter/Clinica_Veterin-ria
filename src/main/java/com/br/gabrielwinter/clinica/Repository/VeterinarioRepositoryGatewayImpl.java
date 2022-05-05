package com.br.gabrielwinter.clinica.Repository;

import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Veterinario;
import com.br.gabrielwinter.clinica.CasoDeUso.gateway.VeterinarioRepositoryGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class VeterinarioRepositoryGatewayImpl implements VeterinarioRepositoryGateway {
    @Override
    public Veterinario cadastrar(Veterinario veterinario) {
        return null;
    }

    @Override
    public Veterinario deletar(Veterinario veterinario) {
        return null;
    }

    @Override
    public Veterinario atualizar(Veterinario veterinario) {
        return null;
    }

    @Override
    public Veterinario buscar(Veterinario veterinario) {
        return null;
    }
}
