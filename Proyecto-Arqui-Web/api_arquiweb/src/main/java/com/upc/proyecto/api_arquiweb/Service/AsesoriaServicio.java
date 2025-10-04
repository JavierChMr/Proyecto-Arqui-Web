package com.upc.proyecto.api_arquiweb.Service;

import com.upc.proyecto.api_arquiweb.Entidades.Asesor;
import com.upc.proyecto.api_arquiweb.Entidades.Asesoria;
import com.upc.proyecto.api_arquiweb.Entidades.Cliente;
import com.upc.proyecto.api_arquiweb.Entidades.Empresa;
import com.upc.proyecto.api_arquiweb.EntidadesDTO.AsesoriaDTO;
import com.upc.proyecto.api_arquiweb.Interfaces.IAsesoriaServicio;
import com.upc.proyecto.api_arquiweb.Repositorio.AsesorRepositorio;
import com.upc.proyecto.api_arquiweb.Repositorio.AsesoriaRepositorio;
import com.upc.proyecto.api_arquiweb.Repositorio.ClienteRepositorio;
import com.upc.proyecto.api_arquiweb.Repositorio.EmpresaRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsesoriaServicio implements IAsesoriaServicio {
    @Autowired
    private AsesoriaRepositorio asesoriaRepositorio;
    @Autowired
    private EmpresaRepositorio empresaRepositorio;
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    @Autowired
    private AsesorRepositorio asesorRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AsesoriaDTO registrarAsesoria(AsesoriaDTO asesoriaDTO) {
        Asesoria asesoria = new Asesoria();

        asesoria.setNombre(asesoriaDTO.getNombre());
        asesoria.setDescripcion(asesoriaDTO.getDescripcion());
        asesoria.setPrecio(asesoriaDTO.getPrecio());

        // Buscar las relaciones
        Empresa empresa = empresaRepositorio.findById(asesoriaDTO.getIdEmpresa())
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
        Cliente cliente = clienteRepositorio.findById(asesoriaDTO.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        asesoria.setIdEmpresa(empresa);
        asesoria.setCliente(cliente);

        // Si manejas asesor:
        if (asesoriaDTO.getIdAsesor() != null) {
            Asesor asesor = asesorRepositorio.findById(asesoriaDTO.getIdAsesor())
                    .orElseThrow(() -> new RuntimeException("Asesor no encontrado"));
            // Aquí lo asignas si tu entidad Asesoria tiene campo asesor
        }

        Asesoria savedAsesoria = asesoriaRepositorio.save(asesoria);
        return modelMapper.map(savedAsesoria, AsesoriaDTO.class);
    }

    @Override
    public List<AsesoriaDTO> listarAsesorias() {
        return asesoriaRepositorio.findAll()
                .stream()
                .map(asesoria -> modelMapper.map(asesoria, AsesoriaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AsesoriaDTO actualizarAsesoria(AsesoriaDTO asesoriaDTO) {
        if (asesoriaDTO.getId() != null && asesoriaRepositorio.existsById(asesoriaDTO.getId())) {
            Asesoria asesoria = asesoriaRepositorio.findById(asesoriaDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Asesoría no encontrada"));

            asesoria.setNombre(asesoriaDTO.getNombre());
            asesoria.setDescripcion(asesoriaDTO.getDescripcion());
            asesoria.setPrecio(asesoriaDTO.getPrecio());

            Empresa empresa = empresaRepositorio.findById(asesoriaDTO.getIdEmpresa())
                    .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
            asesoria.setIdEmpresa(empresa);

            Cliente cliente = clienteRepositorio.findById(asesoriaDTO.getIdCliente())
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
            asesoria.setCliente(cliente);

            // Opcional: Asesor
            if (asesoriaDTO.getIdAsesor() != null) {
                Asesor asesor = asesorRepositorio.findById(asesoriaDTO.getIdAsesor())
                        .orElseThrow(() -> new RuntimeException("Asesor no encontrado"));
                // asesoria.setAsesor(asesor);
            }

            Asesoria updatedAsesoria = asesoriaRepositorio.save(asesoria);
            return modelMapper.map(updatedAsesoria, AsesoriaDTO.class);
        }
        return null;
    }

    @Override
    public void eliminarAsesoria(Integer idAsesoria) {
        asesoriaRepositorio.deleteById(idAsesoria);
    }

    @Override
    public AsesoriaDTO obtenerAsesoriaPorId(Integer idAsesoria) {
        Asesoria asesoria = asesoriaRepositorio.findById(idAsesoria).orElse(null);
        return modelMapper.map(asesoria, AsesoriaDTO.class);
    }

}
