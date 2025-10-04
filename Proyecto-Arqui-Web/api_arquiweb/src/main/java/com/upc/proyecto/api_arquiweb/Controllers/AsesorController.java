package com.upc.proyecto.api_arquiweb.Controllers;

import com.upc.proyecto.api_arquiweb.EntidadesDTO.AsesorDTO;

import com.upc.proyecto.api_arquiweb.Interfaces.IAsesorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/asesores")
public class AsesorController {
    @Autowired
    private IAsesorServicio iAsesorServicio;

    // Registrar un asesor
    @PostMapping
    public EntityModel<AsesorDTO> registrarAsesor(@RequestBody AsesorDTO asesorDTO) {
        AsesorDTO asesor = iAsesorServicio.registrar(asesorDTO);
        return EntityModel.of(asesor,
                linkTo(methodOn(AsesorController.class).buscarAsesorPorId(asesor.getId())).withSelfRel(),
                linkTo(methodOn(AsesorController.class).listarAsesores()).withRel("todos_los_asesores"),
                linkTo(methodOn(AsesorController.class).actualizarAsesor(asesor.getId(), asesor)).withRel("actualizar"),
                linkTo(methodOn(AsesorController.class).eliminarAsesor(asesor.getId())).withRel("eliminar")
        );
    }
zzzzzz
    // Listar todos los asesores
    @GetMapping
    public CollectionModel<EntityModel<AsesorDTO>> listarAsesores() {
        List<EntityModel<AsesorDTO>> asesores = iAsesorServicio.listar().stream()
                .map(asesor -> EntityModel.of(asesor,
                        linkTo(methodOn(AsesorController.class).buscarAsesorPorId(asesor.getId())).withSelfRel(),
                        linkTo(methodOn(AsesorController.class).actualizarAsesor(asesor.getId(), asesor)).withRel("actualizar"),
                        linkTo(methodOn(AsesorController.class).eliminarAsesor(asesor.getId())).withRel("eliminar")
                ))
                .collect(Collectors.toList());

        return CollectionModel.of(asesores,
                linkTo(methodOn(AsesorController.class).listarAsesores()).withSelfRel(),
                linkTo(methodOn(AsesorController.class).registrarAsesor(new AsesorDTO())).withRel("registrar")
        );
    }

    // Actualizar un asesor (con ID en la URL)
    @PutMapping("/actualizar/{id}")
    public EntityModel<AsesorDTO> actualizarAsesor(@PathVariable Integer id, @RequestBody AsesorDTO asesorDTO) {
        asesorDTO.setId(id); // aseguramos que el id sea el mismo
        AsesorDTO asesor = iAsesorServicio.actualizar(asesorDTO);
        return EntityModel.of(asesor,
                linkTo(methodOn(AsesorController.class).buscarAsesorPorId(asesor.getId())).withSelfRel(),
                linkTo(methodOn(AsesorController.class).listarAsesores()).withRel("todos_los_asesores"),
                linkTo(methodOn(AsesorController.class).eliminarAsesor(asesor.getId())).withRel("eliminar")
        );
    }

    // Eliminar un asesor
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarAsesor(@PathVariable Integer id) {
        iAsesorServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar un asesor por ID
    @GetMapping("/buscar_por_Id/{id}")
    public EntityModel<AsesorDTO> buscarAsesorPorId(@PathVariable Integer id) {
        AsesorDTO asesor = iAsesorServicio.FindById(id);
        return EntityModel.of(asesor,
                linkTo(methodOn(AsesorController.class).buscarAsesorPorId(id)).withSelfRel(),
                linkTo(methodOn(AsesorController.class).listarAsesores()).withRel("todos_los_asesores"),
                linkTo(methodOn(AsesorController.class).actualizarAsesor(id, asesor)).withRel("actualizar"),
                linkTo(methodOn(AsesorController.class).eliminarAsesor(asesor.getId())).withRel("eliminar")
        );
    }

    // Buscar asesores por correo
    @GetMapping("/buscar/correo/{correo}")
    public CollectionModel<EntityModel<AsesorDTO>> buscarAsesoresPorCorreo(@PathVariable String correo) {
        List<EntityModel<AsesorDTO>> asesores = iAsesorServicio.buscarporcorreo(correo).stream()
                .map(asesor -> EntityModel.of(asesor,
                        linkTo(methodOn(AsesorController.class).buscarAsesorPorId(asesor.getId())).withSelfRel(),
                        linkTo(methodOn(AsesorController.class).actualizarAsesor(asesor.getId(), asesor)).withRel("actualizar"),
                        linkTo(methodOn(AsesorController.class).eliminarAsesor(asesor.getId())).withRel("eliminar")
                ))
                .collect(Collectors.toList());

        return CollectionModel.of(asesores,
                linkTo(methodOn(AsesorController.class).buscarAsesoresPorCorreo(correo)).withSelfRel()
        );
    }

    // Buscar asesores por nombre
    @GetMapping("/buscar/nombre/{nombre}")
    public CollectionModel<EntityModel<AsesorDTO>> buscarAsesoresPorNombre(@PathVariable String nombre) {
        List<EntityModel<AsesorDTO>> asesores = iAsesorServicio.buscarpornombre(nombre).stream()
                .map(asesor -> EntityModel.of(asesor,
                        linkTo(methodOn(AsesorController.class).buscarAsesorPorId(asesor.getId())).withSelfRel(),
                        linkTo(methodOn(AsesorController.class).actualizarAsesor(asesor.getId(), asesor)).withRel("actualizar"),
                        linkTo(methodOn(AsesorController.class).eliminarAsesor(asesor.getId())).withRel("eliminar")
                ))
                .collect(Collectors.toList());

        return CollectionModel.of(asesores,
                linkTo(methodOn(AsesorController.class).buscarAsesoresPorNombre(nombre)).withSelfRel()
        );
    }

    // Listar asesores por nombre en orden alfabético
    @GetMapping("/ordenados/{nombre}")
    public CollectionModel<EntityModel<AsesorDTO>> listarAsesoresPorNombre(@PathVariable String nombre) {
        List<EntityModel<AsesorDTO>> asesores = iAsesorServicio.listarPornombrealfabetico(nombre).stream()
                .map(asesor -> EntityModel.of(asesor,
                        linkTo(methodOn(AsesorController.class).buscarAsesorPorId(asesor.getId())).withSelfRel(),
                        linkTo(methodOn(AsesorController.class).actualizarAsesor(asesor.getId(), asesor)).withRel("actualizar"),
                        linkTo(methodOn(AsesorController.class).eliminarAsesor(asesor.getId())).withRel("eliminar")
                ))
                .collect(Collectors.toList());

        return CollectionModel.of(asesores,
                linkTo(methodOn(AsesorController.class).listarAsesoresPorNombre(nombre)).withSelfRel()
        );
    }




}
