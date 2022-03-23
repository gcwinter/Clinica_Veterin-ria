package com.br.gabrielwinter.clinica.CasoDeUso.Impl;

import com.br.gabrielwinter.clinica.CasoDeUso.Cliente_Buscar;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Cliente;
import com.br.gabrielwinter.clinica.CasoDeUso.gateway.ClienteRepositoryGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Cliente_BuscarImpl implements Cliente_Buscar {

    private final ClienteRepositoryGateway clienteRepositoryGateway;

    @Override
    public Cliente exec(Cliente cliente) {
       return clienteRepositoryGateway.buscar(cliente);
    }
}
