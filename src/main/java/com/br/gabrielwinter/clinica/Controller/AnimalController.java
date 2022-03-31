package com.br.gabrielwinter.clinica.Controller;

import com.br.gabrielwinter.clinica.CasoDeUso.*;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Animal;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Cliente;
import com.br.gabrielwinter.clinica.Repository.entidade.AnimalDAO;
import com.br.gabrielwinter.clinica.Repository.entidade.ClienteDAO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

//TODO criar classe de transferencia DTO do front para o back


@RestController
@AllArgsConstructor
@RequestMapping("/cliente/animal")
public class AnimalController {

    private final Animal_Cadastrar animal_cadastrar;
    private final Animal_Deletar animal_deletar;
    private final Animal_Buscar animal_buscar;
    private final Animal_Atualizar animal_atualizar;

    @PostMapping
    public AnimalDAO cadastrarAnimal(@RequestBody AnimalDAO animalDAO) {
        Animal animal = animal_cadastrar.exec(animalDAO.paraAnimal());
        return new AnimalDAO(animal);

    }
/*
    @GetMapping("/{id}")
    public ClienteDAO buscarCliente(@PathVariable Long id, ClienteDAO clienteDAO) {
        clienteDAO.setId(id);
        Cliente cliente = cliente_buscar.exec(clienteDAO.paraCliente());
        return new ClienteDAO(cliente);
    }

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
