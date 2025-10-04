package com.upc.proyecto.api_arquiweb.Interfaces;

import com.upc.proyecto.api_arquiweb.EntidadesDTO.SuscripcioneDTO;
import java.util.List;

public interface ISupcripcioneServicio {
    public SuscripcioneDTO registrarSuscripcion(SuscripcioneDTO suscripcionDTO);
    public List<SuscripcioneDTO> listarSuscripciones();
    public SuscripcioneDTO actualizarSuscripcion(SuscripcioneDTO suscripcionDTO);
    public void eliminarSuscripcion(Integer idSuscripcion);
    public List<SuscripcioneDTO> listarSuscripcionesPorCliente(Integer idCliente);
    public List<SuscripcioneDTO> listarSuscripcionesPorPlan(Integer idPlan);
    public SuscripcioneDTO obtenerSuscripcionPorId(Integer idSuscripcion);
}
