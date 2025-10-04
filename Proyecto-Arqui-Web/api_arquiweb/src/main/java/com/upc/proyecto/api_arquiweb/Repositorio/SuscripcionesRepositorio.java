package com.upc.proyecto.api_arquiweb.Repositorio;


import com.upc.proyecto.api_arquiweb.Entidades.Resenha;
import com.upc.proyecto.api_arquiweb.Entidades.Suscripcione;
import com.upc.proyecto.api_arquiweb.EntidadesDTO.ResenhaDTO;
import com.upc.proyecto.api_arquiweb.EntidadesDTO.SuscripcioneDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SuscripcionesRepositorio extends JpaRepository<Suscripcione, Integer> {

}
