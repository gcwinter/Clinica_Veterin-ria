package com.br.gabrielwinter.clinica.Repository.entidade;

import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Animal;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Clientes")
public class ClienteDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;

    @OneToMany(targetEntity = AnimalDAO.class, cascade =  CascadeType.ALL)
    @JoinColumn(name = "animais_cliente")
    private List<AnimalDAO> animaisDAO = new ArrayList<>();


    public ClienteDAO(Cliente cliente) {

        paraClienteDAO(cliente);
    }

    private void paraClienteDAO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getTelefone();
        this.endereco = cliente.getEndereço();
        cliente.getAnimais()
                .forEach(this::converteLista);


    }
    public void converteLista (Animal animal){
        AnimalDAO animalDAO = new AnimalDAO(animal);
        this.animaisDAO.add(animalDAO);

    }

    public Cliente paraCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(this.id);
        cliente.setNome(this.nome);
        cliente.setCpf(this.cpf);
        cliente.setTelefone(this.telefone);
        cliente.setEndereço(this.endereco);
        List<Animal> animais = this.animaisDAO.stream().map(AnimalDAO::paraAnimal).collect(Collectors.toList());

        cliente.setAnimais(this.animaisDAO
                .stream()
                .map(AnimalDAO::paraAnimal)
                .collect(Collectors.toList()));

        cliente.setAnimais(animais);
        System.out.println(animais);

        return cliente;
    }

    public void addAnimais(Animal animal){
      this.animaisDAO.add(new AnimalDAO(animal));

    }

}