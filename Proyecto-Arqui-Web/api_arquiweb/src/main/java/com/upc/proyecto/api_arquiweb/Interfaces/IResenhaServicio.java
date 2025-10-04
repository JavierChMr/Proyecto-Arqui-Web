package com.upc.proyecto.api_arquiweb.Interfaces;

import com.upc.proyecto.api_arquiweb.EntidadesDTO.ResenhaDTO;
import  java.util.List;

public interface IResenhaServicio {
    public ResenhaDTO registrarResenha(ResenhaDTO resenhaDTO);
    public List<ResenhaDTO> listarResenhas();
    public ResenhaDTO actualizarResenha(ResenhaDTO resenhaDTO);
    public void eliminarResenha(Integer idResenha);
    public List<ResenhaDTO> listarResenhasPorCliente(Integer idCliente);
    public ResenhaDTO obtenerResenhaPorId(Integer idResenha);
}
