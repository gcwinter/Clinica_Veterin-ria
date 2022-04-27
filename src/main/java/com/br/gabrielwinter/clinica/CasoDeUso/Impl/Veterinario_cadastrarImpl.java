package com.br.gabrielwinter.clinica.CasoDeUso.Impl;

import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Veterinario;
import com.br.gabrielwinter.clinica.CasoDeUso.Veterinario_cadastrar;
import com.br.gabrielwinter.clinica.CasoDeUso.gateway.VeterinarioRepositoryGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class Veterinario_cadastrarImpl implements Veterinario_cadastrar {

    VeterinarioRepositoryGateway veterinarioRepositoryGateway;

    @Override
    public Veterinario exec(Veterinario veterinario) {
        return veterinarioRepositoryGateway.cadastrar(veterinario);
    }
}
