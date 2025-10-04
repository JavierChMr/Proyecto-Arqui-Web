package com.upc.proyecto.api_arquiweb.Service;
import com.upc.proyecto.api_arquiweb.Entidades.Cliente;
import com.upc.proyecto.api_arquiweb.EntidadesDTO.ClienteDTO;
import com.upc.proyecto.api_arquiweb.Interfaces.IClienteServicio;
import com.upc.proyecto.api_arquiweb.Repositorio.ClienteRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ClienteServicio implements  IClienteServicio {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClienteDTO findById(Integer id) {
        Cliente cliente = clienteRepositorio.findById(id).orElse(null);
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    @Override
    public ClienteDTO findBycorreo(String correo) {
        Cliente cliente = clienteRepositorio.findByCorreoElectronico(correo);
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    @Override
    public ClienteDTO findBynombre(String nombre) {
        List<Cliente> clientes = clienteRepositorio.findByNombreContaining(nombre);
        if (clientes.isEmpty()) {
            return null;
        }
        return modelMapper.map(clientes.get(0), ClienteDTO.class);
    }

    @Override
    public List<ClienteDTO> listarPornombrealfabetico(String nombre) {
        return clienteRepositorio.findByNombreContainingOrderByNombreAsc(nombre)
                .stream().map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO registrar(ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        return modelMapper.map(clienteRepositorio.save(cliente), ClienteDTO.class);
    }

    @Override
    public ClienteDTO actualizar(ClienteDTO clienteDTO) {
        if (clienteDTO.getId() != null && clienteRepositorio.existsById(clienteDTO.getId())) {
            Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
            return modelMapper.map(clienteRepositorio.save(cliente), ClienteDTO.class);
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        clienteRepositorio.deleteById(id);
    }

    @Override
    public List<ClienteDTO> listar() {
        return clienteRepositorio.findAll()
                .stream().map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
                .collect(Collectors.toList());
    }

}
