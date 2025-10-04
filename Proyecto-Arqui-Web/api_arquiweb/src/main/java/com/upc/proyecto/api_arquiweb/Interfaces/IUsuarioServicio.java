package com.upc.proyecto.api_arquiweb.Interfaces;

import com.upc.proyecto.api_arquiweb.EntidadesDTO.UsuarioDTO;
import java.util.List;
public interface IUsuarioServicio {
    public UsuarioDTO registrarusuario(UsuarioDTO usuarioDTO);
    public UsuarioDTO actualizarusuario(UsuarioDTO usuarioDTO);
    public void eliminarusuario(Integer id);
    public List<UsuarioDTO> listarusuario();
    public UsuarioDTO encontrarusuarioById(Integer id);

}
