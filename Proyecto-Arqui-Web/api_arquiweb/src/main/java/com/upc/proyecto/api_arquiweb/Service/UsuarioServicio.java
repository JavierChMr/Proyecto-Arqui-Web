package com.upc.proyecto.api_arquiweb.Service;

import com.upc.proyecto.api_arquiweb.Entidades.Usuario;
import com.upc.proyecto.api_arquiweb.EntidadesDTO.UsuarioDTO;
import com.upc.proyecto.api_arquiweb.Interfaces.IUsuarioServicio;
import com.upc.proyecto.api_arquiweb.Repositorio.UsuarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service

public class UsuarioServicio implements IUsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UsuarioDTO registrarusuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        Usuario savedUsuario = usuarioRepositorio.save(usuario);
        return modelMapper.map(savedUsuario, UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO actualizarusuario(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getIdUsuario() != null && usuarioRepositorio.existsById(usuarioDTO.getIdUsuario())) {
            // Convertir el DTO a la entidad
            Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
            // Actualizar el usuario en la base de datos
            Usuario updatedUsuario = usuarioRepositorio.save(usuario);
            // Convertir la entidad actualizada a DTO y devolverlo
            return modelMapper.map(updatedUsuario, UsuarioDTO.class);
        }
        return null;
    }

    @Override
    public void eliminarusuario(Integer id) {
        if (usuarioRepositorio.existsById(id)) {
            usuarioRepositorio.deleteById(id);
        }
    }

    @Override
    public List<UsuarioDTO> listarusuario() {
        return usuarioRepositorio.findAll()
                .stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO encontrarusuarioById(Integer id) {
        Usuario usuario = usuarioRepositorio.findById(id).orElse(null);
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

}
