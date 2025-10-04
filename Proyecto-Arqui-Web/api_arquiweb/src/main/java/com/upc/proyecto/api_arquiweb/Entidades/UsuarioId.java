package com.upc.proyecto.api_arquiweb.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable

public class UsuarioId implements Serializable {
    private static final long serialVersionUID = 245133498200749150L;
    @NotNull
    @ColumnDefault("nextval('usuarios_id_usuario_seq')")
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @NotNull
    @Column(name = "id_cliente", nullable = false)
    private Integer idCliente;

    @NotNull
    @Column(name = "id_asesor", nullable = false)
    private Integer idAsesor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsuarioId entity = (UsuarioId) o;
        return Objects.equals(this.idCliente, entity.idCliente) &&
                Objects.equals(this.idUsuario, entity.idUsuario) &&
                Objects.equals(this.idAsesor, entity.idAsesor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, idUsuario, idAsesor);
    }

}