package com.upc.proyecto.api_arquiweb.Entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = Integer.MAX_VALUE)
    private String nombre;

    @Column(name = "apellido", length = Integer.MAX_VALUE)
    private String apellido;

    @Column(name = "telefono", length = Integer.MAX_VALUE)
    private String telefono;

    @Column(name = "dni", length = Integer.MAX_VALUE)
    private String dni;

    @Column(name = "correo_electronico", length = Integer.MAX_VALUE)
    private String correoElectronico;

}