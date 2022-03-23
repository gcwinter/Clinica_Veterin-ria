package com.br.gabrielwinter.clinica.CasoDeUso.Impl;

import com.br.gabrielwinter.clinica.CasoDeUso.Cliente_Atualizar;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Cliente;
import com.br.gabrielwinter.clinica.CasoDeUso.gateway.ClienteRepositoryGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Cliente_AtualizarImpl implements Cliente_Atualizar {

    private  final ClienteRepositoryGateway clienteRepositoryGateway;

    @Override
    public Cliente exec(Cliente cliente) {
        return  clienteRepositoryGateway.atualizar(cliente);
    }
}
