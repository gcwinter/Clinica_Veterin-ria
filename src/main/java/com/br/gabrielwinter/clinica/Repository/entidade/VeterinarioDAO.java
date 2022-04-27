package com.br.gabrielwinter.clinica.Repository.entidade;

import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Veterinario;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VeterinarioDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String crmv;
    private String nome;
    private String endereco;
    private String email;
    private String telefone;
    private String celular;
    private String cpf;


    public VeterinarioDAO(Veterinario veterinario) {

        this.id = veterinario.getId();
        this.crmv = veterinario.getCrmv();
        this.nome = veterinario.getNome();
        this.endereco = veterinario.getEndereco();
        this.email = veterinario.getEmail();
        this.telefone = veterinario.getTelefone();
        this.celular = veterinario.getCelular();
        this.cpf = veterinario.getCpf();

    }

    public Veterinario paraVeterinario(VeterinarioDAO veterinarioDAO) {
        Veterinario veterinario = new Veterinario();
        veterinario.setId(veterinarioDAO.getId());
        veterinario.setCrmv(veterinarioDAO.getCrmv());
        veterinario.setNome(veterinarioDAO.getNome());
        veterinario.setEndereco(veterinarioDAO.getEndereco());
        veterinario.setEmail(veterinarioDAO.getEmail());
        veterinario.setTelefone(veterinarioDAO.getTelefone());
        veterinario.setCelular(veterinario.getCelular());
        veterinario.setCpf(veterinarioDAO.getCpf());
        return veterinario;
    }


}
