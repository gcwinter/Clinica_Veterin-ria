package com.br.gabrielwinter.clinica.Controller;

import com.br.gabrielwinter.clinica.CasoDeUso.Cliente_Atualizar;
import com.br.gabrielwinter.clinica.CasoDeUso.Cliente_Buscar;
import com.br.gabrielwinter.clinica.CasoDeUso.Cliente_Cadastrar;
import com.br.gabrielwinter.clinica.CasoDeUso.Cliente_Deletar;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Cliente;
import com.br.gabrielwinter.clinica.Controller.Recurso.ClienteDTO;
import com.br.gabrielwinter.clinica.Repository.ClienteRepository;
import com.br.gabrielwinter.clinica.Repository.entidade.ClienteDAO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO criar classe de transferencia DTO do front para o back


@RestController
@AllArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final Cliente_Cadastrar cliente_cadastrar;
    private final Cliente_Buscar cliente_buscar;
    private final Cliente_Atualizar cliente_atualizar;
    private final Cliente_Deletar cliente_delete;
    private final ClienteRepository clienteRepository;

    @PostMapping
    public ClienteDTO CadastrarCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = cliente_cadastrar.exec(clienteDTO.paraCliente());
        return new ClienteDTO(cliente);

    }

    @GetMapping("/{id}")
    public ClienteDTO buscarCliente(@PathVariable Long id) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(id);
        Cliente cliente = cliente_buscar.exec(clienteDTO.paraCliente());
        return new ClienteDTO(cliente);
    }

    @GetMapping("/all")
    public List<ClienteDAO> buscarTodosClientes() {

        List<ClienteDAO> clienteDAO = clienteRepository.findAll();

        return clienteDAO;
    }

    @PutMapping("/{id}")
    public ClienteDAO atualizarCliente(@PathVariable Long id, @RequestBody ClienteDAO clienteDAO) {
        clienteDAO.setId(id);
        Cliente cliente = cliente_atualizar.exec(clienteDAO.paraCliente());

        return new ClienteDAO(cliente);
    }

    @DeleteMapping("/{id}")
    public ClienteDAO deletarCliente(@PathVariable Long id) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente_delete.exec(cliente);
        return new ClienteDAO();

    }

}