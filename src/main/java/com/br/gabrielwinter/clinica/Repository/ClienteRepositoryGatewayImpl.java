package com.br.gabrielwinter.clinica.Repository;

import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Cliente;
import com.br.gabrielwinter.clinica.CasoDeUso.gateway.ClienteRepositoryGateway;
import com.br.gabrielwinter.clinica.Repository.entidade.AnimalDAO;
import com.br.gabrielwinter.clinica.Repository.entidade.ClienteDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Objects.isNull;

@Repository
@AllArgsConstructor
public class ClienteRepositoryGatewayImpl implements ClienteRepositoryGateway {

   private final ClienteRepository clienteRepository;
  
    @Override
    public Cliente salvar(Cliente cliente) {
        ClienteDAO clienteDAO = new ClienteDAO(cliente);
        ClienteDAO clienteSalvo = clienteRepository.save(clienteDAO);
        cliente.setId(clienteSalvo.getId());
        return cliente;
    }

    @Override
    public Cliente deletar(Cliente cliente) {
        ClienteDAO clienteDAO = new ClienteDAO(cliente);
        if(isNull(clienteDAO)){
            return new Cliente();
        }
        clienteRepository.deleteById(clienteDAO.getId());
        return new Cliente();
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        ClienteDAO clienteDAO = new ClienteDAO(cliente);
        ClienteDAO clienteAtualizar = clienteRepository.findById(clienteDAO.getId()).get();
        if(isNull(clienteAtualizar)){
            return new Cliente();
        }
        clienteAtualizar.setId(clienteDAO.getId());
        clienteAtualizar.setNome(clienteDAO.getNome());
        clienteAtualizar.setCpf(clienteDAO.getCpf());
        clienteAtualizar.setTelefone(clienteDAO.getTelefone());
        clienteAtualizar.setEndereco(clienteDAO.getEndereco());
        clienteRepository.save(clienteAtualizar);
        return clienteAtualizar.paraCliente();
    }

    @Override
    public Cliente buscar(Cliente cliente) {
        ClienteDAO clienteDAO = new ClienteDAO(cliente);
        ClienteDAO clienteBuscado = clienteRepository.findById(clienteDAO.getId()).get();
       List<AnimalDAO> animalDAOS =  clienteBuscado.getAnimaisDAO();
        return clienteBuscado.paraCliente();
    }
}
