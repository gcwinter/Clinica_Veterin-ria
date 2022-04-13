package com.br.gabrielwinter.clinica.Repository;

import com.br.gabrielwinter.clinica.CasoDeUso.Cliente_Buscar;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Animal;
import com.br.gabrielwinter.clinica.CasoDeUso.gateway.AnimalRepositoryGateway;
import com.br.gabrielwinter.clinica.Repository.entidade.AnimalDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import static java.util.Objects.isNull;

@Repository
@AllArgsConstructor
public class AnimalRepositoryGatewayImpl implements AnimalRepositoryGateway {

<<<<<<< HEAD
   private final AnimalRepository animalRepository;
=======
    private final AnimalRepository animalRepository;
    private final Cliente_Buscar cliente_buscar;
>>>>>>> edf46081447abf12f13bafb43e4c3e1a3555deab

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
        if (isNull(animalDB)) {
            return new Animal();
        }

        return animalDB.paraAnimal();
    }

}
