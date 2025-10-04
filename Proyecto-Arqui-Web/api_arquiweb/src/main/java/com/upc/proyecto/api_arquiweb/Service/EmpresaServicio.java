package com.upc.proyecto.api_arquiweb.Service;


import com.upc.proyecto.api_arquiweb.Entidades.Asesor;
import com.upc.proyecto.api_arquiweb.Entidades.Cliente;
import com.upc.proyecto.api_arquiweb.Entidades.Empresa;
import com.upc.proyecto.api_arquiweb.EntidadesDTO.EmpresaDTO;
import com.upc.proyecto.api_arquiweb.Interfaces.IEmpresaServicio;

import com.upc.proyecto.api_arquiweb.Repositorio.EmpresaRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaServicio implements IEmpresaServicio {

    @Autowired
    private EmpresaRepositorio empresaRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmpresaDTO registrar(EmpresaDTO empresaDTO) {
        Empresa empresa = modelMapper.map(empresaDTO, Empresa.class);

        // 👇 Setear asesor si viene en el DTO
        if (empresaDTO.getIdAsesor() != null) {
            Asesor asesor = new Asesor();
            asesor.setId(empresaDTO.getIdAsesor());
            empresa.setAsesor(asesor);
        }

        // 👇 Setear cliente si viene en el DTO
        if (empresaDTO.getIdCliente() != null) {
            Cliente cliente = new Cliente();
            cliente.setId(empresaDTO.getIdCliente());
            empresa.setCliente(cliente);
        }

        Empresa savedEmpresa = empresaRepositorio.save(empresa);
        return modelMapper.map(savedEmpresa, EmpresaDTO.class);
    }

    @Override
    public EmpresaDTO actualizar(EmpresaDTO empresaDTO) {
        if (empresaDTO.getId() != null && empresaRepositorio.existsById(empresaDTO.getId())) {
            Empresa empresa = modelMapper.map(empresaDTO, Empresa.class);

            if (empresaDTO.getIdAsesor() != null) {
                Asesor asesor = new Asesor();
                asesor.setId(empresaDTO.getIdAsesor());
                empresa.setAsesor(asesor);
            }

            if (empresaDTO.getIdCliente() != null) {
                Cliente cliente = new Cliente();
                cliente.setId(empresaDTO.getIdCliente());
                empresa.setCliente(cliente);
            }

            Empresa updatedEmpresa = empresaRepositorio.save(empresa);
            return modelMapper.map(updatedEmpresa, EmpresaDTO.class);
        }
        return null;
    }

    @Override
    public EmpresaDTO eliminar(Integer id) {
        if (empresaRepositorio.existsById(id)) {
            empresaRepositorio.deleteById(id);
            return new EmpresaDTO(id, null, null, null, null, null);
        }
        return null;
    }

    @Override
    public List<EmpresaDTO> listar() {
        return empresaRepositorio.findAll()
                .stream()
                .map(empresa -> modelMapper.map(empresa, EmpresaDTO.class))
                .collect(Collectors.toList());
    }
}
