package com.br.gabrielwinter.clinica.Repository.entidade;

import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Animal;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Cliente;
import com.fasterxml.classmate.AnnotationOverrides;
import lombok.*;

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
            cascade = CascadeType.ALL, fetch =FetchType.LAZY)
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

/*
                  cliente
                .getAnimais()
                .forEach(animal -> this.animais.add(new AnimalDAO(animal)));
        System.out.println(animais);*/
    }

    public Cliente paraCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(this.id);
        cliente.setNome(this.nome);
        cliente.setCpf(this.cpf);
        cliente.setTelefone(this.telefone);
        cliente.setEndereço(this.endereco);


        System.out.println(this.animais);
        List<Animal> listaDeAnimais = new ArrayList<>();
        animais.forEach(animalDAO -> listaDeAnimais.add(animalDAO.paraAnimal()));
        cliente.setAnimais(listaDeAnimais);


        return cliente;
    }

}