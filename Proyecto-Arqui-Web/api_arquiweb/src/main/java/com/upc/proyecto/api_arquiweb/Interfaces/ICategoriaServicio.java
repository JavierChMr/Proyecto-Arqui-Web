package com.upc.proyecto.api_arquiweb.Interfaces;

import com.upc.proyecto.api_arquiweb.EntidadesDTO.CategoriaDTO;
import java.util.List;

public interface ICategoriaServicio {
    public CategoriaDTO registrarCategoria(CategoriaDTO categoriaDTO);
    public List<CategoriaDTO> listarCategorias();
    public CategoriaDTO actualizarCategoria(CategoriaDTO categoriaDTO);
    public void eliminarCategoria(Integer idCategoria);
    public CategoriaDTO obtenerCategoriaPorId(Integer idCategoria);
    public List<CategoriaDTO> buscarCategoriasPorNombre(String nombre);
}
