package com.br.gabrielwinter.clinica.Controller.DTO;

import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Cliente;
import com.br.gabrielwinter.clinica.Repository.entidade.AnimalDAO;
import com.br.gabrielwinter.clinica.Repository.entidade.ClienteDAO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private List<AnimalDTO> animais = new ArrayList<>();

    public ClienteDTO(ClienteDAO clienteDAO) {
        converte(clienteDAO);
    }

    private void converte(ClienteDAO clienteDAO) {
        this.id = clienteDAO.getId();
        this.nome = clienteDAO.getNome();
        this.cpf = clienteDAO.getCpf();
        this.endereco = clienteDAO.getEndereco();
        this.animais = clienteDAO
                .getAnimaisDAO()
                .stream()
                .map(AnimalDAO::paraAnimalDTO)
                .collect(Collectors.toList());


    }

    public ClienteDAO paraClienteDAO() {
        ClienteDAO cliente = new ClienteDAO();
        cliente.setId(this.id);
        cliente.setNome(this.nome);
        cliente.setCpf(this.cpf);
        cliente.setTelefone(this.telefone);
        cliente.setEndereco(this.endereco);


        return cliente;

    }
}

