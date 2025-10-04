package com.upc.proyecto.api_arquiweb.Entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago", nullable = false)
    private Integer id;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "metodo_pago", length = Integer.MAX_VALUE)
    private String metodoPago;

    @Column(name = "fecha_pago")
    private LocalDate fechaPago;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_asesoria", nullable = false)
    private Asesoria idAsesoria;



}