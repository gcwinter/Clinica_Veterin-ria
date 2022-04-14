package com.br.gabrielwinter.clinica.Repository;

import com.br.gabrielwinter.clinica.CasoDeUso.Cliente_Buscar;
import com.br.gabrielwinter.clinica.CasoDeUso.Cliente_Cadastrar;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Animal;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Cliente;
import com.br.gabrielwinter.clinica.CasoDeUso.gateway.AnimalRepositoryGateway;
import com.br.gabrielwinter.clinica.Repository.entidade.AnimalDAO;
import com.br.gabrielwinter.clinica.Repository.entidade.ClienteDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import static java.util.Objects.isNull;

@Repository
@AllArgsConstructor
public class AnimalRepositoryGatewayImpl implements AnimalRepositoryGateway {

    private final AnimalRepository animalRepository;
    private final Cliente_Buscar cliente_buscar;
    private final Cliente_Cadastrar cliente_cadastrar;

    @Override
    public Animal cadastar(Long id, Animal animal) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente = cliente_buscar.exec(cliente);
        ClienteDAO clienteDAO = new ClienteDAO(cliente);
        clienteDAO.addAnimais(animal);
        cliente = cliente_cadastrar.exec(clienteDAO.paraCliente());
        return cliente.getAnimais().get(cliente.getAnimais().size() - 1);
    }

    @Override
    public Animal deletar(Animal animal) {
        return null;
    }

    @Override
    public Animal atualizar(Animal animal) {
        return null;
    }


    /*
        @Override
        public Cliente deletar(Animal animal) {
            ClienteDAO clienteDAO = new ClienteDAO(cliente);
            if(isNull(clienteDAO)){
                return new Cliente();
            }
            clienteRepository.deleteById(clienteDAO.getId());
            return new Cliente();
        }

        @Override
        public Animal atualizar(Animal animal) {
            AnimalDAO animalDAO = new AnimalDAO(animal);
           AnimalDAO animalDB = animalRepository.findById(animalDAO.getId()).get();
            if(isNull(animalDB)){
                return new Animal();
            }
            clienteAtualizar.setId(clienteDAO.getId());
            clienteAtualizar.setNome(clienteDAO.getNome());
            clienteAtualizar.setCpf(clienteDAO.getCpf());
            clienteAtualizar.setTelefone(clienteDAO.getTelefone());
            clienteAtualizar.setEndereco(clienteDAO.getEndereco());
            clienteRepository.save(clienteAtualizar);
            return clienteAtualizar.paraCliente();
        }
    */
    @Override
    public Animal buscar(Animal animal) {
        AnimalDAO animalDAO = new AnimalDAO(animal);
        AnimalDAO animalDB = animalRepository.findById(animalDAO.getId()).get();
        if (isNull(animalDB)) {
            return new Animal();
        }

        return animalDB.paraAnimal();
    }

}
