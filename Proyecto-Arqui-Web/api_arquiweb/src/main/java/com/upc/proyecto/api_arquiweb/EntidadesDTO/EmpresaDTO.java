package com.upc.proyecto.api_arquiweb.EntidadesDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDTO {
    private Integer id;
    private String nombre;
    private String correoElectronico;
    private Integer idUsuario;   // FK Usuario
    private Integer idAsesor;    // FK Asesor
    private Integer idCliente;   // FK Cliente
}
