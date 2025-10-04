package com.upc.proyecto.api_arquiweb.Service;

import com.upc.proyecto.api_arquiweb.Entidades.Asesor;
import com.upc.proyecto.api_arquiweb.Repositorio.AsesorRepositorio;
import com.upc.proyecto.api_arquiweb.EntidadesDTO.AsesorDTO;
import com.upc.proyecto.api_arquiweb.Interfaces.IAsesorServicio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsesorServicio implements IAsesorServicio {
    @Autowired
    private AsesorRepositorio asesorRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AsesorDTO FindById(Integer idAsesor) {
        return asesorRepositorio.findById(idAsesor)
                .map(asesor -> modelMapper.map(asesor, AsesorDTO.class))
                .orElse(null);
    }

    @Override
    public AsesorDTO registrar(AsesorDTO asesorDTO) {
        if (asesorDTO.getId() == null) { // valida que no tenga ID al registrar
            Asesor asesor = modelMapper.map(asesorDTO, Asesor.class);
            return modelMapper.map(asesorRepositorio.save(asesor), AsesorDTO.class);
        }
        return null;
    }

    @Override
    public AsesorDTO actualizar(AsesorDTO asesorDTO) {
        if (asesorDTO.getId() != null) {
            if (asesorRepositorio.existsById(asesorDTO.getId())) {
                Asesor asesor = modelMapper.map(asesorDTO, Asesor.class);
                return modelMapper.map(asesorRepositorio.save(asesor), AsesorDTO.class);
            }
        }
        return null;
    }

    @Override
    public void eliminar(Integer idAsesor) {
        asesorRepositorio.deleteById(idAsesor);
    }

    @Override
    public List<AsesorDTO> listar() {
        return asesorRepositorio.findAll().stream()
                .map(asesor -> modelMapper.map(asesor, AsesorDTO.class))
                .toList();
    }

    @Override
    public List<AsesorDTO> listarPornombrealfabetico(String nombre) {
        return asesorRepositorio.findByNombreContainingOrderByNombreAsc(nombre)
                .stream()
                .map(asesor -> modelMapper.map(asesor, AsesorDTO.class))
                .toList();
    }

    @Override
    public List<AsesorDTO> buscarporcorreo(String correo) {
        return asesorRepositorio.findByCorreoElectronicoContaining(correo)
                .stream()
                .map(asesor -> modelMapper.map(asesor, AsesorDTO.class))
                .toList();
    }

    @Override
    public List<AsesorDTO> buscarpornombre(String nombre) {
        return asesorRepositorio.findByNombreContaining(nombre)
                .stream()
                .map(asesor -> modelMapper.map(asesor, AsesorDTO.class))
                .toList();
    }


}

