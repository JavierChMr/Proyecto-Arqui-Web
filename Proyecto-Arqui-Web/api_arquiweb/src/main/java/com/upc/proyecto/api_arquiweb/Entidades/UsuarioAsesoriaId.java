package com.upc.proyecto.api_arquiweb.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable

public class UsuarioAsesoriaId implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "id_asesoria", nullable = false)
    private Integer idAsesoria;

    @NotNull
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsuarioAsesoriaId entity = (UsuarioAsesoriaId) o;
        return Objects.equals(this.idAsesoria, entity.idAsesoria) &&
                Objects.equals(this.idUsuario, entity.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAsesoria, idUsuario);
    }
}