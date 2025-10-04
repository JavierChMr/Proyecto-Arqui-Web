package com.upc.proyecto.api_arquiweb.Repositorio;

import com.upc.proyecto.api_arquiweb.Entidades.Pago;
import com.upc.proyecto.api_arquiweb.EntidadesDTO.PagoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface PagoRepositorio extends JpaRepository<Pago, Integer> {
    List<Pago> findByIdAsesoriaClienteId(Integer idCliente);


    List<Pago> findByMetodoPago(String metodoPago);

    // Buscar pagos por fecha exacta
    List<Pago> findByFechaPago(LocalDate fechaPago);



}
