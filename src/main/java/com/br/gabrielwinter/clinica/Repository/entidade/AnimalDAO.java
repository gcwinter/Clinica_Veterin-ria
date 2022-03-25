package com.br.gabrielwinter.clinica.Repository.entidade;

import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Animal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "clienteDAO_id")
    private ClienteDAO clienteDAO;
    private String nome;
    private String tipo;
    private long peso;
    private long idade;


public AnimalDAO (Animal animal){

    converte(animal);
}

    private void converte(Animal animal) {
        this.id = animal.getId();
        this.nome = animal.getNome();
        this.tipo= animal.getTipo();
        this.peso= animal.getPeso();
        this.idade= animal.getIdade();
        this.clienteDAO=new ClienteDAO(animal.getCliente());
    }

    public Animal paraAnimal(){

    Animal animal = new Animal();
    animal.setId(this.id);
    animal.setIdade(this.idade);
    animal.setNome(this.nome);
    animal.setPeso(this.peso);
    animal.setTipo(this.tipo);
    animal.setCliente(this.clienteDAO.paraCliente());




    }

}