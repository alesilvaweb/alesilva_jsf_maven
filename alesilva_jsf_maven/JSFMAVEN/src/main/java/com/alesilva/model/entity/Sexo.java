
package com.alesilva.model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="sexo")
public class Sexo implements Serializable{
   
    private static final long SerialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "id_sexo" , nullable = false)
    private Long idSexo;
    @Column(name = "ds_sexo" , unique = true)
    private String descricao;
    
    @OneToMany(mappedBy = "sexo",fetch = FetchType.LAZY)
    @ForeignKey(name = "PessoaSexo")
    private List<Pessoa> pessoas;
    

    public Sexo() {
    }
    

    public Long getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Long idSexo) {
        this.idSexo = idSexo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.idSexo);
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
        final Sexo other = (Sexo) obj;
        return Objects.equals(this.idSexo, other.idSexo);
    }
     
}
