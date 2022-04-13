package com.br.gabrielwinter.clinica.Controller;

import com.br.gabrielwinter.clinica.CasoDeUso.*;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Animal;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Cliente;
import com.br.gabrielwinter.clinica.Controller.DTO.ClienteDTO;
import com.br.gabrielwinter.clinica.Repository.ClienteRepository;
import com.br.gabrielwinter.clinica.Repository.entidade.AnimalDAO;
import com.br.gabrielwinter.clinica.Repository.entidade.ClienteDAO;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

//TODO criar classe de transferencia DTO do front para o back


@RestController
@AllArgsConstructor
@RequestMapping("/{id}/animal")
public class AnimalController {

    private final Cliente_Cadastrar cliente_cadastrar;
    private final Cliente_Buscar cliente_buscar;
    private final Cliente_Atualizar cliente_atualizar;
    private final Cliente_Deletar cliente_delete;
    private final ClienteRepository clienteRepository;

    @PostMapping
    public ClienteDTO cadastrarAnimal(@PathVariable Long id, @RequestBody AnimalDAO animalDAO) {
        ClienteDAO clienteDAO = clienteRepository.findById(id).get();
        animalDAO.setClienteDAO(clienteDAO);
        clienteDAO.addAnimais(animalDAO);

        clienteRepository.save(clienteDAO);
        clienteDAO = clienteRepository.findById(id).get();
        return  new ClienteDTO(clienteDAO);
                //cliente_cadastrar.exec(clienteDAO.paraCliente());



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
