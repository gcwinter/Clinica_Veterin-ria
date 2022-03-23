package com.br.gabrielwinter.clinica.Repository;

import com.br.gabrielwinter.clinica.Repository.entidade.ClienteDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteDAO, Long> {


}
