package com.br.gabrielwinter.clinica.Repository.entidade;

import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Animal;
import com.br.gabrielwinter.clinica.Controller.DTO.AnimalDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Animais")
public class AnimalDAO {


    @Id
    @GeneratedValue(strategy
            = GenerationType.IDENTITY)
    private long id;
<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "clientedao_id")
    private ClienteDAO clienteDAO;

    public AnimalDAO(String nome, String tipo, long peso, long idade) {
        this.nome = nome;
        this.tipo = tipo;
        this.peso = peso;
        this.idade = idade;
    }

=======
>>>>>>> edf46081447abf12f13bafb43e4c3e1a3555deab
    private String nome;
    private String tipo;
    private long peso;
    private long idade;

<<<<<<< HEAD
=======

>>>>>>> edf46081447abf12f13bafb43e4c3e1a3555deab
    public AnimalDAO(Animal animal) {

        converte(animal);
    }

    private void converte(Animal animal) {
        this.id = animal.getId();
        this.nome = animal.getNome();
        this.tipo = animal.getTipo();
        this.peso = animal.getPeso();
        this.idade = animal.getIdade();
<<<<<<< HEAD
        this.clienteDAO = new ClienteDAO(animal.getCliente());
=======

>>>>>>> edf46081447abf12f13bafb43e4c3e1a3555deab
    }

    public Animal paraAnimal() {

        Animal animal = new Animal();
        animal.setId(this.id);
        animal.setIdade(this.idade);
        animal.setNome(this.nome);
        animal.setPeso(this.peso);
        animal.setTipo(this.tipo);

        return animal;
    }

    public AnimalDTO paraAnimalDTO() {
        AnimalDTO animal = new AnimalDTO();
        animal.setId(this.id);
        animal.setIdade(this.idade);
        animal.setNome(this.nome);
        animal.setPeso(this.peso);
        animal.setTipo(this.tipo);
        return animal;
    }
}