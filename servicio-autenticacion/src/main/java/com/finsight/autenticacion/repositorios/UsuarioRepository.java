package com.finsight.autenticacion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.finsight.autenticacion.modelos.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
