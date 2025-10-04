package com.upc.proyecto.api_arquiweb.Interfaces;

import com.upc.proyecto.api_arquiweb.EntidadesDTO.EmpresaDTO;
import java.util.List;
public interface IEmpresaServicio {
    public EmpresaDTO registrar(EmpresaDTO empresaDTO);
    public EmpresaDTO actualizar(EmpresaDTO empresaDTO);
    public EmpresaDTO eliminar(Integer id);
    public List<EmpresaDTO> listar();
}
