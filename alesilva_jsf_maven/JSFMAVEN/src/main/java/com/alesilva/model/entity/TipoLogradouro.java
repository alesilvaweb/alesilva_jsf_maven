
package com.alesilva.model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "tipo_logradouro")
public class TipoLogradouro implements Serializable{
 private static final long SerialVersionUID = 1L;
 
 @Id
 @GeneratedValue
 @Column(name = "id_tipo_logradouro", nullable = false)
 private Long id;
 @Column(name = "ds_tipo_logradoruro")
 private String tipologradouro;
 
 @OneToMany
     @ForeignKey(name = "TipoLogradouroEndereco")
     private List<Endereco> enderecos;

    public TipoLogradouro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return tipologradouro;
    }

    public void setLogradouro(String logradouro) {
        this.tipologradouro = logradouro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoLogradouro other = (TipoLogradouro) obj;
        return Objects.equals(this.id, other.id);
    }
 
 
}
