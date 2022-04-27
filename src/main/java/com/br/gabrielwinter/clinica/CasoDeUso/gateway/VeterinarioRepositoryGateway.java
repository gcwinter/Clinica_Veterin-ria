package com.br.gabrielwinter.clinica.CasoDeUso.gateway;

import com.br.gabrielwinter.clinica.CasoDeUso.Dominio.Veterinario;

public interface VeterinarioRepositoryGateway {
    Veterinario cadastrar(Veterinario veterinario);
    Veterinario deletar(Veterinario veterinario);
    Veterinario atualizar(Veterinario veterinario);
    Veterinario buscar(Veterinario veterinario);
}
