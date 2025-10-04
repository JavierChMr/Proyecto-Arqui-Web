package com.upc.proyecto.api_arquiweb.Entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario_asesoria")
public class UsuarioAsesoria {

    @EmbeddedId
    private UsuarioAsesoriaId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("idAsesoria")
    @JoinColumn(name = "id_asesoria", referencedColumnName = "id_asesoria", nullable = false)
    private Asesoria asesoria;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    private Usuario usuario;

}
