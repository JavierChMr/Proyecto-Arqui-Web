package com.upc.proyecto.api_arquiweb.Repositorio;

import com.upc.proyecto.api_arquiweb.Entidades.Resenha;
import com.upc.proyecto.api_arquiweb.EntidadesDTO.ResenhaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ResenhaRepositorio extends JpaRepository<Resenha, Integer> {


}
