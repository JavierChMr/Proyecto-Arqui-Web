package com.upc.proyecto.api_arquiweb.Interfaces;
import com.upc.proyecto.api_arquiweb.EntidadesDTO.AsesoriaDTO;

import java.time.LocalDate;
import java.util.List;

public interface IAsesoriaServicio {
    public AsesoriaDTO registrarAsesoria(AsesoriaDTO asesoriaDTO);
    public List<AsesoriaDTO> listarAsesorias();
    public AsesoriaDTO actualizarAsesoria(AsesoriaDTO asesoriaDTO);
    public void eliminarAsesoria(Integer idAsesoria);
    public AsesoriaDTO obtenerAsesoriaPorId(Integer idAsesoria);

}
