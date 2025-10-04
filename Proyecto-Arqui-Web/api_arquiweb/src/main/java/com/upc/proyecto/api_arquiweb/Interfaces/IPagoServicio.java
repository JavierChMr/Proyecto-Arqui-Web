package com.upc.proyecto.api_arquiweb.Interfaces;

import com.upc.proyecto.api_arquiweb.EntidadesDTO.PagoDTO;

import java.time.LocalDate;
import java.util.List;

public interface IPagoServicio {
    public PagoDTO registrarPago(PagoDTO pagoDTO);
    public List<PagoDTO> listarPagos();
    public PagoDTO actualizarPago(PagoDTO pagoDTO);
    public void eliminarPago(Integer idCliente);
    public List<PagoDTO> listarporfechadepago(LocalDate fecha);
    public PagoDTO buscarPagoPorId(Integer idCliente);

}
