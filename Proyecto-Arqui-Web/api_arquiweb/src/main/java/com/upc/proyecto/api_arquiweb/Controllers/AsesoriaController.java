package com.upc.proyecto.api_arquiweb.Controllers;

import com.upc.proyecto.api_arquiweb.EntidadesDTO.AsesoriaDTO;
import com.upc.proyecto.api_arquiweb.Interfaces.IAsesoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Asesorias")
public class AsesoriaController {
    @Autowired
    private IAsesoriaServicio iAsesoriaServicio;

    // Registrar asesoría
    @PostMapping
    public EntityModel<AsesoriaDTO> registrarAsesoria(@RequestBody AsesoriaDTO asesoriaDTO) {
        AsesoriaDTO asesoria = iAsesoriaServicio.registrarAsesoria(asesoriaDTO);

        return EntityModel.of(asesoria,
                linkTo(methodOn(AsesoriaController.class).obtenerAsesoriaPorId(asesoria.getId())).withSelfRel(),
                linkTo(methodOn(AsesoriaController.class).listarAsesorias()).withRel("todas_las_asesorias"),
                linkTo(methodOn(AsesoriaController.class).actualizarAsesoria(asesoria.getId(), asesoria)).withRel("actualizar"),
                linkTo(methodOn(AsesoriaController.class).eliminarAsesoria(asesoria.getId())).withRel("eliminar")
        );
    }


    // Listar asesorías
    @GetMapping
    public CollectionModel<EntityModel<AsesoriaDTO>> listarAsesorias() {
        List<EntityModel<AsesoriaDTO>> asesorias = iAsesoriaServicio.listarAsesorias().stream()
                .map(asesoria -> EntityModel.of(asesoria,
                        linkTo(methodOn(AsesoriaController.class).obtenerAsesoriaPorId(asesoria.getId())).withSelfRel(),
                        linkTo(methodOn(AsesoriaController.class).actualizarAsesoria(asesoria.getId(), asesoria)).withRel("actualizar"),
                        linkTo(methodOn(AsesoriaController.class).eliminarAsesoria(asesoria.getId())).withRel("eliminar")
                ))
                .collect(Collectors.toList());

        return CollectionModel.of(asesorias,
                linkTo(methodOn(AsesoriaController.class).listarAsesorias()).withSelfRel(),
                linkTo(methodOn(AsesoriaController.class).registrarAsesoria(new AsesoriaDTO())).withRel("registrar")
        );
    }

    // Obtener asesoría por ID
    @GetMapping("/{id}")
    public EntityModel<AsesoriaDTO> obtenerAsesoriaPorId(@PathVariable Integer id) {
        AsesoriaDTO asesoria = iAsesoriaServicio.obtenerAsesoriaPorId(id);

        return EntityModel.of(asesoria,
                linkTo(methodOn(AsesoriaController.class).obtenerAsesoriaPorId(id)).withSelfRel(),
                linkTo(methodOn(AsesoriaController.class).listarAsesorias()).withRel("todas_las_asesorias"),
                linkTo(methodOn(AsesoriaController.class).actualizarAsesoria(id, asesoria)).withRel("actualizar"),
                linkTo(methodOn(AsesoriaController.class).eliminarAsesoria(id)).withRel("eliminar")
        );
    }

    // Actualizar asesoría
    @PutMapping("/actualizar/{id}")
    public EntityModel<AsesoriaDTO> actualizarAsesoria(@PathVariable Integer id, @RequestBody AsesoriaDTO asesoriaDTO) {
        asesoriaDTO.setId(id);
        AsesoriaDTO asesoria = iAsesoriaServicio.actualizarAsesoria(asesoriaDTO);

        return EntityModel.of(asesoria,
                linkTo(methodOn(AsesoriaController.class).obtenerAsesoriaPorId(asesoria.getId())).withSelfRel(),
                linkTo(methodOn(AsesoriaController.class).listarAsesorias()).withRel("todas_las_asesorias"),
                linkTo(methodOn(AsesoriaController.class).eliminarAsesoria(asesoria.getId())).withRel("eliminar")
        );
    }

    // Eliminar asesoría
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarAsesoria(@PathVariable Integer id) {
        iAsesoriaServicio.eliminarAsesoria(id);
        return ResponseEntity.noContent().build();
    }



}
