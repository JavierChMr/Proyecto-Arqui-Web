package com.upc.proyecto.api_arquiweb.Controllers;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.upc.proyecto.api_arquiweb.EntidadesDTO.PagoDTO;
import com.upc.proyecto.api_arquiweb.Interfaces.IPagoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {
    @Autowired
    private IPagoServicio iPagoServicio;

    // Registrar un pago
    @PostMapping
    public EntityModel<PagoDTO> registrarPago(@RequestBody PagoDTO pagoDTO) {
        PagoDTO pago = iPagoServicio.registrarPago(pagoDTO);
        return EntityModel.of(pago,
                linkTo(methodOn(PagoController.class).buscarPagoPorId(pago.getId())).withSelfRel(),
                linkTo(methodOn(PagoController.class).listarPagos()).withRel("todos_los_pagos"),
                linkTo(methodOn(PagoController.class).actualizarPago(pago.getId(), pago)).withRel("actualizar"),
                linkTo(methodOn(PagoController.class).eliminarPago(pago.getId())).withRel("eliminar")
        );
    }

    //registrar
    //{
    //    "monto": 78.0,
    //    "metodoPago": "Efectivo",
    //    "fechaPago": "2025-09-12",
    //    "idAsesoria": 2
    //}

    // Listar todos los pagos
    @GetMapping
    public CollectionModel<EntityModel<PagoDTO>> listarPagos() {
        List<EntityModel<PagoDTO>> pagos = iPagoServicio.listarPagos().stream()
                .map(pago -> EntityModel.of(pago,
                        linkTo(methodOn(PagoController.class).buscarPagoPorId(pago.getId())).withSelfRel(),
                        linkTo(methodOn(PagoController.class).actualizarPago(pago.getId(), pago)).withRel("actualizar"),
                        linkTo(methodOn(PagoController.class).eliminarPago(pago.getId())).withRel("eliminar")
                ))
                .collect(Collectors.toList());

        return CollectionModel.of(pagos,
                linkTo(methodOn(PagoController.class).listarPagos()).withSelfRel(),
                linkTo(methodOn(PagoController.class).registrarPago(new PagoDTO())).withRel("registrar")
        );
    }

    // Actualizar un pago (ahora con ID en la URL)
    @PutMapping("/actualizar/{id}")
    public EntityModel<PagoDTO> actualizarPago(@PathVariable Integer id, @RequestBody PagoDTO pagoDTO) {
        pagoDTO.setId(id); // aseguramos que el id sea el mismo
        PagoDTO pago = iPagoServicio.actualizarPago(pagoDTO);
        return EntityModel.of(pago,
                linkTo(methodOn(PagoController.class).buscarPagoPorId(pago.getId())).withSelfRel(),
                linkTo(methodOn(PagoController.class).listarPagos()).withRel("todos_los_pagos"),
                linkTo(methodOn(PagoController.class).eliminarPago(pago.getId())).withRel("eliminar")
        );
    }



    // Eliminar un pago
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPago(@PathVariable Integer id) {
        iPagoServicio.eliminarPago(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar un pago por ID
    @GetMapping("/buscar_por_Id/{id}")
    public EntityModel<PagoDTO> buscarPagoPorId(@PathVariable Integer id) {
        PagoDTO pago = iPagoServicio.buscarPagoPorId(id);
        return EntityModel.of(pago,
                linkTo(methodOn(PagoController.class).buscarPagoPorId(id)).withSelfRel(),
                linkTo(methodOn(PagoController.class).listarPagos()).withRel("todos_los_pagos"),
                linkTo(methodOn(PagoController.class).actualizarPago(id, pago)).withRel("actualizar"),
                linkTo(methodOn(PagoController.class).eliminarPago(pago.getId())).withRel("eliminar")
        );
    }

    // Listar pagos por fecha
    @GetMapping("/listar_por_fecha")
    public CollectionModel<EntityModel<PagoDTO>> listarPagosPorFecha(@RequestParam("fecha") LocalDate fechapago) {
        List<EntityModel<PagoDTO>> pagos = iPagoServicio.listarporfechadepago(fechapago).stream()
                .map(p -> EntityModel.of(p,
                        linkTo(methodOn(PagoController.class).buscarPagoPorId(p.getId())).withSelfRel(),
                        linkTo(methodOn(PagoController.class).actualizarPago(p.getId(), p)).withRel("actualizar"),
                        linkTo(methodOn(PagoController.class).eliminarPago(p.getId())).withRel("eliminar")
                ))
                .collect(Collectors.toList());

        return CollectionModel.of(pagos,
                linkTo(methodOn(PagoController.class).listarPagosPorFecha(fechapago)).withSelfRel()
        );
    }

}
