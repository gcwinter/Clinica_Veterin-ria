package com.br.gabrielwinter.clinica.Controller.Recurso;


import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Animal;
import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {


    private long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private List<AnimalDTO> animais = new ArrayList<>();


    public ClienteDTO(Cliente cliente) {
        converte(cliente);
    }

    private void converte(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getTelefone();
        this.endereco = cliente.getEndereço();
        cliente.getAnimais().forEach(Animal->addAnimalDB(new AnimalDTO(Animal)));

    }

    public Cliente paraCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(this.id);
        cliente.setNome(this.nome);
        cliente.setCpf(this.cpf);
        cliente.setTelefone(this.telefone);
        cliente.setEndereço(this.endereco);
        List<Animal> animais = this.animais.stream().map(AnimalDTO::paraAnimal).collect(Collectors.toList());
        cliente.setAnimais(animais);


        return cliente;
    }

    public void addAnimalDB(AnimalDTO animalDTO) {
        this.animais.add(animalDTO);
    }
}