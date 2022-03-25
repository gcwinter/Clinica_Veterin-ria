package com.br.gabrielwinter.clinica.CasoDeUso.Impl;

import com.br.gabrielwinter.clinica.CasoDeUso.Cliente_Deletar;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Cliente;
import com.br.gabrielwinter.clinica.CasoDeUso.gateway.ClienteRepositoryGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Cliente_DeletarImpl implements Cliente_Deletar {

    private final ClienteRepositoryGateway clienteRepositoryGateway;

    @Override
    public Cliente exec(Cliente cliente) {
        return clienteRepositoryGateway.deletar(cliente);
    }
}
