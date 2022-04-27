package com.br.gabrielwinter.clinica.CasoDeUso.Impl;

import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Veterinario;
import com.br.gabrielwinter.clinica.CasoDeUso.Veterinario_Atualizar;
import com.br.gabrielwinter.clinica.CasoDeUso.gateway.VeterinarioRepositoryGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class Veterinario_AtualizarImpl implements Veterinario_Atualizar {

    VeterinarioRepositoryGateway veterinarioRepositoryGateway;
    @Override
    public Veterinario exec(Veterinario veterinario) {
        return veterinarioRepositoryGateway.atualizar(veterinario);
    }
}
