package com.upc.proyecto.api_arquiweb.Controllers;

import com.upc.proyecto.api_arquiweb.EntidadesDTO.EmpresaDTO;
import com.upc.proyecto.api_arquiweb.Interfaces.IEmpresaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {
    @Autowired
    private IEmpresaServicio iEmpresaServicio;

    // Registrar una nueva empresa
    @PostMapping
    public EmpresaDTO registrar(@RequestBody EmpresaDTO empresaDTO) {
        return iEmpresaServicio.registrar(empresaDTO);
    }

    // Listar todas las empresas
    @GetMapping
    public List<EmpresaDTO> listar() {
        return iEmpresaServicio.listar();
    }

    // Actualizar una empresa
    @PutMapping
    public EmpresaDTO actualizar(@RequestBody EmpresaDTO empresaDTO) {
        return iEmpresaServicio.actualizar(empresaDTO);
    }

    // Eliminar una empresa
    @DeleteMapping("/{id}")
    public EmpresaDTO eliminar(@PathVariable Integer id) {
        return iEmpresaServicio.eliminar(id);
    }

}
