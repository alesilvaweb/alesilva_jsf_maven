
package com.alesilva.model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.ForeignKey;


@Entity
public class cidade implements Serializable{
     private static final long SerialVersionUID = 1L;
     
     @Id
     @GeneratedValue
     @Column(nullable = false)
     private Long idCidade;
     @Column(name = "ds_cidade",unique = true)
     private String cidade;
     
     @OneToMany
     @ForeignKey(name = "CidadeEndereco")
     private List<Endereco> enderecos;

    public cidade() {
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
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
        hash = 71 * hash + Objects.hashCode(this.idCidade);
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
        if (!Objects.equals(this.idCidade, other.idCidade)) {
            return false;
        }
        return true;
    }
   
}
