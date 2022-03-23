package com.br.gabrielwinter.clinica.CasoDeUso.gateway;

import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Cliente;

public interface ClienteRepositoryGateway {
    Cliente salvar(Cliente cliente);
    Cliente deletar(Cliente cliente);
    Cliente atualizar(Cliente cliente);
    Cliente buscar(Cliente cliente);


}
