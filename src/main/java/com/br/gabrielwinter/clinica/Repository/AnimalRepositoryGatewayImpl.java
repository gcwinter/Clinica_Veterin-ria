package com.br.gabrielwinter.clinica.Repository;

import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Animal;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Cliente;
import com.br.gabrielwinter.clinica.CasoDeUso.gateway.AnimalRepositoryGateway;
import com.br.gabrielwinter.clinica.CasoDeUso.gateway.ClienteRepositoryGateway;
import com.br.gabrielwinter.clinica.Repository.entidade.AnimalDAO;
import com.br.gabrielwinter.clinica.Repository.entidade.ClienteDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import static java.util.Objects.isNull;

@Repository
@AllArgsConstructor
public class AnimalRepositoryGatewayImpl implements AnimalRepositoryGateway {

   private final AnimalRepository animalRepository;
  
    @Override
    public Animal cadastar(Animal animal) {
        AnimalDAO animalDAO = new AnimalDAO(animal);
        AnimalDAO animalDAOSalvo = animalRepository.save(animalDAO);
        animal.setId(animalDAOSalvo.getId());
        return animal;
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
        if(isNull(animalDB)){
            return new Animal();
        }

        return animalDB.paraAnimal();
    }

}
