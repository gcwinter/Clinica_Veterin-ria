package com.br.gabrielwinter.clinica.CasoDeUso.Impl;

import com.br.gabrielwinter.clinica.CasoDeUso.Cliente_Delete;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Cliente;
import com.br.gabrielwinter.clinica.CasoDeUso.gateway.ClienteRepositoryGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Cliente_DeleteImpl implements Cliente_Delete {

    private final ClienteRepositoryGateway clienteRepositoryGateway;

    @Override
    public Cliente exec(Cliente cliente) {
        return clienteRepositoryGateway.deletar(cliente);
    }
}
