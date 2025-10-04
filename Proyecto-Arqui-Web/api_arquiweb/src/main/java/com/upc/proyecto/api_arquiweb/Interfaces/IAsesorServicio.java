package com.upc.proyecto.api_arquiweb.Interfaces;

import com.upc.proyecto.api_arquiweb.EntidadesDTO.AsesorDTO;
import java.util.List;

public interface IAsesorServicio {

    public AsesorDTO FindById(Integer idAsesor);
    public AsesorDTO registrar(AsesorDTO asesorDTO);
    public AsesorDTO actualizar(AsesorDTO asesorDTO);
    public void  eliminar(Integer idAsesor);
    public List<AsesorDTO> listar();
    public List<AsesorDTO> listarPornombrealfabetico(String nombre);
    public List<AsesorDTO> buscarporcorreo(String correo);
    public List<AsesorDTO> buscarpornombre(String nombre);


}
