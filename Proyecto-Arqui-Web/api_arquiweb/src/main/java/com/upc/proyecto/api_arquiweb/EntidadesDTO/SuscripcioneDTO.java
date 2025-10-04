package com.upc.proyecto.api_arquiweb.EntidadesDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuscripcioneDTO {
    private Integer id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private Integer idPlan;
    private Integer idUsuario;
    private Integer idCliente;
    private Integer idAsesor;
}
