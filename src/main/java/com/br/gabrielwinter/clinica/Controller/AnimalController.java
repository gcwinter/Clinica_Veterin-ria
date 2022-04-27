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
        return new AnimalDTO(animal_cadastrar.exec(id, animalDTO.paraAnimal()));

    }

    @GetMapping("/all")
    public List<AnimalDAO> buscarAnimais() {
        return animalRepository.findAll();

    }

    @PutMapping("/{id}")
    public AnimalDTO atualizaAnimal(@RequestBody AnimalDTO animalDTO) {
        return new AnimalDTO(animal_atualizar.exec(animalDTO.paraAnimal()));
    }

    @DeleteMapping("/{id}")
    public AnimalDTO deletarAnimal(@PathVariable Long id) {
        AnimalDTO animalDTO = new AnimalDTO();
        animalDTO.setId(id);
        return new AnimalDTO(
                animal_deletar.exec(animalDTO.paraAnimal()));
    }

}