package com.br.gabrielwinter.clinica.Controller;

import com.br.gabrielwinter.clinica.CasoDeUso.*;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Animal;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Cliente;
import com.br.gabrielwinter.clinica.Controller.Recurso.AnimalDTO;
import com.br.gabrielwinter.clinica.Controller.Recurso.ClienteDTO;
import com.br.gabrielwinter.clinica.Repository.AnimalRepository;
import com.br.gabrielwinter.clinica.Repository.entidade.AnimalDAO;
import com.br.gabrielwinter.clinica.Repository.entidade.ClienteDAO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO criar classe de transferencia DTO do front para o back


@RestController
@AllArgsConstructor
@RequestMapping("/{id}/animal")
public class AnimalController {

    private final Animal_Cadastrar animal_cadastrar;
    private final Animal_Deletar animal_deletar;
    private final Animal_Buscar animal_buscar;
    private final Animal_Atualizar animal_atualizar;
    private final AnimalRepository animalRepository;

    private final Cliente_Cadastrar cliente_cadastrar;
    private final Cliente_Buscar cliente_buscar;

    @PostMapping
    public AnimalDTO cadastrarAnimal(@PathVariable long id, @RequestBody AnimalDTO animalDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente = cliente_buscar.exec(cliente);
        ClienteDTO clienteDTO = new ClienteDTO(cliente);
        clienteDTO.addAnimalDB(animalDTO);
        System.out.println(clienteDTO);
        cliente = cliente_cadastrar.exec(clienteDTO.paraCliente());
        System.out.println(cliente);
        System.out.println(new ClienteDTO(cliente));
        return animalDTO;

    }

    @GetMapping("/all")
    public List<AnimalDAO> buscarCliente() {
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

    @DeleteMapping("/{id}")
    public ClienteDAO deletarCliente(@PathVariable Long id){
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente_delete.exec(cliente);
        return new ClienteDAO();

    }
*/
}
