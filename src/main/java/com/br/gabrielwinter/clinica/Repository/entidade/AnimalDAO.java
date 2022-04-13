package com.br.gabrielwinter.clinica.Repository.entidade;

import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Animal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static java.util.Objects.isNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Animais")
public class AnimalDAO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String tipo;
    private long peso;
    private long idade;


    public AnimalDAO(Animal animal) {

        converte(animal);
    }

    private void converte(Animal animal) {
        this.id = animal.getId();
        this.nome = animal.getNome();
        this.tipo = animal.getTipo();
        this.peso = animal.getPeso();
        this.idade = animal.getIdade();

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

}