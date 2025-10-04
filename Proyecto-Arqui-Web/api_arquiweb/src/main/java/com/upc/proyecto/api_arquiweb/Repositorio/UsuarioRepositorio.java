package com.upc.proyecto.api_arquiweb.Repositorio;
import com.upc.proyecto.api_arquiweb.Entidades.Usuario;
import com.upc.proyecto.api_arquiweb.EntidadesDTO.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> { ;

}
