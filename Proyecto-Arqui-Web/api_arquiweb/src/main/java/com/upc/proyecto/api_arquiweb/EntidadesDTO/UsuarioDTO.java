package com.upc.proyecto.api_arquiweb.EntidadesDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Integer idUsuario;
    private Integer idCliente;
    private Integer idAsesor;
}
