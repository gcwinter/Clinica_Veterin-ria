package com.br.gabrielwinter.clinica.Repository.entidade;

import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Animal;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Cliente;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
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
<<<<<<< HEAD
    @OneToMany(mappedBy = "clienteDAO")
      private List<AnimalDAO> animaisDAO= new ArrayList<>();
=======
    @OneToMany(targetEntity = AnimalDAO.class, cascade =  CascadeType.ALL)
    @JoinColumn(name = "animais_cliente")
    private List<AnimalDAO> animais = new ArrayList<>();
>>>>>>> edf46081447abf12f13bafb43e4c3e1a3555deab


    public ClienteDAO(Cliente cliente) {

        converte(cliente);
    }

    private void converte(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getTelefone();
        this.endereco = cliente.getEndereço();
        cliente.getAnimais()
                .stream()
                .forEach(animal -> converteLista(animal));


    }
    public void converteLista (Animal animal){
        AnimalDAO animalDAO = new AnimalDAO(animal);
        this.animais.add(animalDAO);

<<<<<<< HEAD

=======
>>>>>>> edf46081447abf12f13bafb43e4c3e1a3555deab
    }

    public Cliente paraCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(this.id);
        cliente.setNome(this.nome);
        cliente.setCpf(this.cpf);
        cliente.setTelefone(this.telefone);
        cliente.setEndereço(this.endereco);
        List<Animal> animais = this.animais.stream().map(AnimalDAO::paraAnimal).collect(Collectors.toList());

<<<<<<< HEAD
        cliente.setAnimais(this.animaisDAO
                .stream()
                .map(AnimalDAO::paraAnimal)
                .collect(Collectors.toList()));

=======
        cliente.setAnimais(animais);
        System.out.println(animais);
>>>>>>> edf46081447abf12f13bafb43e4c3e1a3555deab

        return cliente;
    }

<<<<<<< HEAD
    public void addAnimais(AnimalDAO animalDAO){
      this.animaisDAO.add(animalDAO);

=======
    public void addAnimalDB(AnimalDAO animalDAO) {
        this.animais.add(animalDAO);
>>>>>>> edf46081447abf12f13bafb43e4c3e1a3555deab
    }
}