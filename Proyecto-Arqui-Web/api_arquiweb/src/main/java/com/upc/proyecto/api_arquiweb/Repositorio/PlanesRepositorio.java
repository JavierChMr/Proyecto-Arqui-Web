package com.upc.proyecto.api_arquiweb.Repositorio;

import com.upc.proyecto.api_arquiweb.Entidades.Plane;
import com.upc.proyecto.api_arquiweb.EntidadesDTO.PlaneDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlanesRepositorio extends JpaRepository<Plane, Integer> {

}
