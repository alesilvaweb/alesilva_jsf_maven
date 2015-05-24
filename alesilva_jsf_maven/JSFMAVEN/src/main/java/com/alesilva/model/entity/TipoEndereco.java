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
@Table(name = "tipo_endereco")
public class TipoEndereco implements Serializable{
     private static final long SerialVersionUID = 1L;
     
     @Id
     @GeneratedValue
     @Column(name ="id_tipo_endereco",nullable = false)
     private Long id;
     @Column(name = "ds_tipo_endereco")
     private String endereco;
     
     @OneToMany
     @ForeignKey(name = "tipoEnderecoEndereco")
     private List<Endereco> enderecos;

    public TipoEndereco() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final TipoEndereco other = (TipoEndereco) obj;
        return Objects.equals(this.id, other.id);
    }
     
     
    
}
