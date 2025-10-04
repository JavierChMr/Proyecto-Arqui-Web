package com.upc.proyecto.api_arquiweb.Repositorio;

import com.upc.proyecto.api_arquiweb.Entidades.Categoria;
import com.upc.proyecto.api_arquiweb.EntidadesDTO.CategoriaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {

    
}
