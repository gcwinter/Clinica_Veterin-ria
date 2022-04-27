package com.br.gabrielwinter.clinica.Controller;

import com.br.gabrielwinter.clinica.CasoDeUso.Animal_Atualizar;
import com.br.gabrielwinter.clinica.CasoDeUso.Animal_Buscar;
import com.br.gabrielwinter.clinica.CasoDeUso.Animal_Cadastrar;
import com.br.gabrielwinter.clinica.CasoDeUso.Animal_Deletar;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Animal;
import com.br.gabrielwinter.clinica.Controller.Recurso.AnimalDTO;
import com.br.gabrielwinter.clinica.Repository.AnimalRepository;
import com.br.gabrielwinter.clinica.Repository.entidade.AnimalDAO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO criar classe de transferencia DTO do front para o back


@RestController
@AllArgsConstructor
@RequestMapping("/animal")
public class AnimalController {

    private final Animal_Cadastrar animal_cadastrar;
    private final Animal_Deletar animal_deletar;
    private final Animal_Buscar animal_buscar;
    private final Animal_Atualizar animal_atualizar;
    private final AnimalRepository animalRepository;


    @PostMapping("/{id}")
    public AnimalDTO cadastrarAnimal(@PathVariable long id, @RequestBody AnimalDTO animalDTO) {
        Animal animal = animal_cadastrar.exec(id, animalDTO.paraAnimal());
        return new AnimalDTO(animal);

    }

    @GetMapping("/all")
    public List<AnimalDAO> buscarAnimais() {
        List<AnimalDAO> animais = animalRepository.findAll();

        return animais;
    }

    /*
        @PutMapping("/{id}")
        public ClienteDAO atualizarCliente(@PathVariable Long id, @RequestBody ClienteDAO clienteDAO) {
            clienteDAO.setId(id);
            Cliente cliente = cliente_atualizar.exec(clienteDAO.paraCliente());
            return new ClienteDAO(cliente);
        }
    */
    @DeleteMapping("/{id}")
    public AnimalDTO deletarAnimal(@PathVariable Long id) {
        AnimalDTO animalDTO = new AnimalDTO();
        animalDTO.setId(id);
        return new AnimalDTO(
                animal_deletar.exec(animalDTO.paraAnimal()));
    }

}