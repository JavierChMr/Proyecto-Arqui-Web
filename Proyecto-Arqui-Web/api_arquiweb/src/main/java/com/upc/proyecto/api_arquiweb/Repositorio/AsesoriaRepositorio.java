package com.upc.proyecto.api_arquiweb.Repositorio;

import com.upc.proyecto.api_arquiweb.Entidades.Asesoria;
import com.upc.proyecto.api_arquiweb.EntidadesDTO.AsesoriaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface AsesoriaRepositorio extends JpaRepository<Asesoria, Integer> {
}
