package com.upc.proyecto.api_arquiweb.Interfaces;

import com.upc.proyecto.api_arquiweb.EntidadesDTO.PlaneDTO;
import  java.util.List;

public interface IPlanesServicio {
    public PlaneDTO registrarPlan(PlaneDTO planDTO);
    public List<PlaneDTO> listarPlanes();
    public PlaneDTO actualizarPlan(PlaneDTO planDTO);
    public void eliminarPlan(Integer idPlan);
    public List<PlaneDTO> listarPlanesPorDuracion(String duracion);
    public PlaneDTO obtenerPlanPorId(Integer idPlan);
}
