package com.br.gabrielwinter.clinica.Repository.entidade;

import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ClienteDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    @OneToMany(mappedBy = "clienteDAO",
            cascade = CascadeType.ALL)
    private List<AnimalDAO> animais = new ArrayList<>();


    public ClienteDAO(Cliente cliente) {
        converte(cliente);
    }

    private void converte(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getTelefone();
        this.endereco = cliente.getEndereço();
                  cliente
                .getAnimais()
                .stream()
                .forEach(animal -> animais.add(new AnimalDAO(animal)));
    }

    public Cliente paraCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(this.id);
        cliente.setNome(this.nome);
        cliente.setCpf(this.cpf);
        cliente.setTelefone(this.telefone);
        cliente.setEndereço(this.endereco);
       cliente.setAnimais(this.animais.stream().forEach(animalDAO -> new AnimalDAO().paraAnimal());

        return cliente;
    }
}