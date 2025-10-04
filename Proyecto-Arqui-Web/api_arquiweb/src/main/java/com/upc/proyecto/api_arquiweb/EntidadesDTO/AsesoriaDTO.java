package com.upc.proyecto.api_arquiweb.EntidadesDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsesoriaDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer idEmpresa;
    private Integer idCliente;   // 👈 nuevo
    private Integer idAsesor;    // 👈 opcional si luego lo relacionas
}
