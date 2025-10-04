package com.upc.proyecto.api_arquiweb.EntidadesDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResenhaDTO {
    private Integer id;
    private Integer puntaje;
    private String comentario;
    private LocalDate fecha;
    private Integer idAsesoria;
    private Integer idCliente;
}
