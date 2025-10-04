package com.upc.proyecto.api_arquiweb.Interfaces;

import com.upc.proyecto.api_arquiweb.EntidadesDTO.ClienteDTO;
import java.util.List;
public interface IClienteServicio {
    public ClienteDTO findById(Integer id);
    public ClienteDTO findBycorreo(String correo);
    public ClienteDTO findBynombre(String nombre);
    public List<ClienteDTO> listarPornombrealfabetico(String nombre);
    public ClienteDTO registrar(ClienteDTO clienteDTO);
    public ClienteDTO actualizar(ClienteDTO clienteDTO);
    public void eliminar(Integer id);
    public List<ClienteDTO> listar();


}
