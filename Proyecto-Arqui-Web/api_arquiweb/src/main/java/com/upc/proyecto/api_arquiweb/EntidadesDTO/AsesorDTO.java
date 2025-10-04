package com.upc.proyecto.api_arquiweb.EntidadesDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsesorDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String dni;
    private String correoElectronico;
}
