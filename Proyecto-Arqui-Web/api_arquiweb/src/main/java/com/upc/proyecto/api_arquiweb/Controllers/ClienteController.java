package com.upc.proyecto.api_arquiweb.Controllers;
import com.upc.proyecto.api_arquiweb.EntidadesDTO.ClienteDTO;
import com.upc.proyecto.api_arquiweb.Interfaces.IClienteServicio;
import com.upc.proyecto.api_arquiweb.Service.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private IClienteServicio iClienteServicio;

    // Registrar Cliente
    @PostMapping("/registrar")
    public EntityModel<ClienteDTO> registrar(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO cliente = iClienteServicio.registrar(clienteDTO);
        return EntityModel.of(cliente,
                linkTo(methodOn(ClienteController.class).buscarPorId(cliente.getId())).withSelfRel(),
                linkTo(methodOn(ClienteController.class).listar()).withRel("listar"));
    }

    // Listar Clientes
    @GetMapping
    public CollectionModel<EntityModel<ClienteDTO>> listar() {
        List<EntityModel<ClienteDTO>> clientes = iClienteServicio.listar().stream()
                .map(c -> EntityModel.of(c,
                        linkTo(methodOn(ClienteController.class).buscarPorId(c.getId())).withSelfRel(),
                        // pasar id y el DTO (coincide con la firma actualizar(id, clienteDTO))
                        linkTo(methodOn(ClienteController.class).actualizar(c.getId(), c)).withRel("actualizar"),
                        linkTo(methodOn(ClienteController.class).eliminar(c.getId())).withRel("eliminar")
                ))
                .collect(Collectors.toList());

        return CollectionModel.of(clientes,
                linkTo(methodOn(ClienteController.class).listar()).withSelfRel()
        );
    }

    // Buscar Cliente por ID
    @GetMapping("/{id}")
    public EntityModel<ClienteDTO> buscarPorId(@PathVariable Integer id) {
        ClienteDTO cliente = iClienteServicio.findById(id);
        return EntityModel.of(cliente,
                linkTo(methodOn(ClienteController.class).buscarPorId(id)).withSelfRel(),
                linkTo(methodOn(ClienteController.class).listar()).withRel("listar"),
                linkTo(methodOn(ClienteController.class).eliminar(id)).withRel("eliminar"));
    }

    // Actualizar Cliente
    @PutMapping("/{id}")
    public EntityModel<ClienteDTO> actualizar(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO) {
        clienteDTO.setId(id);
        ClienteDTO actualizado = iClienteServicio.actualizar(clienteDTO);
        return EntityModel.of(actualizado,
                linkTo(methodOn(ClienteController.class).buscarPorId(id)).withSelfRel(),
                linkTo(methodOn(ClienteController.class).listar()).withRel("listar"));
    }

    // Eliminar Cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        iClienteServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar por Correo con PathVariable
    @GetMapping("/buscar/correo/{correo}")
    public EntityModel<ClienteDTO> buscarPorCorreo(@PathVariable String correo) {
        ClienteDTO cliente = iClienteServicio.findBycorreo(correo);
        return EntityModel.of(cliente,
                linkTo(methodOn(ClienteController.class).buscarPorCorreo(correo)).withSelfRel(),
                linkTo(methodOn(ClienteController.class).listar()).withRel("listar"));
    }


    // Buscar por Nombre
    @GetMapping("/buscar/{nombre}")
    public CollectionModel<EntityModel<ClienteDTO>> buscarPorNombre(@PathVariable String nombre) {
        List<EntityModel<ClienteDTO>> clientes = iClienteServicio.listarPornombrealfabetico(nombre).stream()
                .map(c -> EntityModel.of(c,
                        linkTo(methodOn(ClienteController.class).buscarPorId(c.getId())).withSelfRel(),
                        linkTo(methodOn(ClienteController.class).actualizar(c.getId(), c)).withRel("actualizar"),
                        linkTo(methodOn(ClienteController.class).eliminar(c.getId())).withRel("eliminar")
                ))
                .collect(Collectors.toList());

        return CollectionModel.of(clientes,
                linkTo(methodOn(ClienteController.class).buscarPorNombre(nombre)).withSelfRel());
    }


}
