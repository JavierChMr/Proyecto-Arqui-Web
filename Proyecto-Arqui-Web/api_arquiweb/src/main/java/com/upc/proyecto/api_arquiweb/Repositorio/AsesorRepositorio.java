package com.upc.proyecto.api_arquiweb.Repositorio;

import com.upc.proyecto.api_arquiweb.Entidades.Asesor;
import com.upc.proyecto.api_arquiweb.EntidadesDTO.AsesorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AsesorRepositorio extends JpaRepository<Asesor, Integer> {
    List<Asesor> findByCorreoElectronicoContaining(String correoElectronico);
    List<Asesor> findByNombreContaining(String nombre);
    List<Asesor> findByNombreContainingOrderByNombreAsc(String nombre);

}
