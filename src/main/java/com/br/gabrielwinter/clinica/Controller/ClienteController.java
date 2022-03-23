package com.br.gabrielwinter.clinica.Controller;

import com.br.gabrielwinter.clinica.CasoDeUso.Cliente_Atualizar;
import com.br.gabrielwinter.clinica.CasoDeUso.Cliente_Buscar;
import com.br.gabrielwinter.clinica.CasoDeUso.Cliente_Cadastrar;
import com.br.gabrielwinter.clinica.CasoDeUso.Cliente_Delete;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Cliente;
import com.br.gabrielwinter.clinica.Repository.entidade.ClienteDAO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

//TODO criar classe de transferencia DTO do front para o back


@RestController
@AllArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final Cliente_Cadastrar cliente_cadastrar;
    private final Cliente_Buscar cliente_buscar;
    private final Cliente_Atualizar cliente_atualizar;
    private final Cliente_Delete cliente_delete;

    @PostMapping
    public ClienteDAO CadastrarCliente(@RequestBody ClienteDAO clienteDAO) {
        Cliente cliente = cliente_cadastrar.exec(clienteDAO.paraCliente());
        return new ClienteDAO(cliente);

    }

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

}
