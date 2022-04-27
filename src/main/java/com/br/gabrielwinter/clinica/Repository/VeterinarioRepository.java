package com.br.gabrielwinter.clinica.Repository;

import com.br.gabrielwinter.clinica.Repository.entidade.VeterinarioDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository<VeterinarioDAO, Long> {
}
