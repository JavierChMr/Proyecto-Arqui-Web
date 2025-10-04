package com.upc.proyecto.api_arquiweb.Repositorio;

import com.upc.proyecto.api_arquiweb.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByNombreContaining(String nombre);
    List<Cliente> findByNombreContainingOrderByNombreAsc(String nombre);
    Cliente findByCorreoElectronico(String correoElectronico);

}
