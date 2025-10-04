package com.upc.proyecto.api_arquiweb.Controllers;

import com.upc.proyecto.api_arquiweb.EntidadesDTO.UsuarioDTO;
import com.upc.proyecto.api_arquiweb.Interfaces.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioServicio iUsuarioServicio;

    @PostMapping
    public UsuarioDTO registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return iUsuarioServicio.registrarusuario(usuarioDTO);
    }

    @GetMapping
    public List<UsuarioDTO> listarUsuarios() {
        return iUsuarioServicio.listarusuario();
    }

    @GetMapping("/{id}")
    public UsuarioDTO obtenerUsuarioPorId(@PathVariable Integer id) {
        return iUsuarioServicio.encontrarusuarioById(id);
    }

    @PutMapping
    public UsuarioDTO actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return iUsuarioServicio.actualizarusuario(usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Integer id) {
        iUsuarioServicio.eliminarusuario(id);
    }

}
