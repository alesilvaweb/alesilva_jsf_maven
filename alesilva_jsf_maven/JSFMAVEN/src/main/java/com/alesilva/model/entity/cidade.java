
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
@Table
public class cidade implements Serializable{
     private static final long SerialVersionUID = 1L;
     
     @Id
     @GeneratedValue
     @Column(name = "id_cidade",nullable = false)
     private Long id;
     @Column(name = "ds_cidade",unique = true)
     private String cidade;
     
     @OneToMany
     @ForeignKey(name = "CidadeEndereco")
     private List<Endereco> enderecos;

    public cidade() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final cidade other = (cidade) obj;
        return Objects.equals(this.id, other.id);
    }
     
     
     
     
}
