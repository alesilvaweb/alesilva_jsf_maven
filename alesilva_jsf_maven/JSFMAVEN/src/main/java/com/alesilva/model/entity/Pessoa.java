
package com.alesilva.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;




@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable {
    
    private static final long SerialVersionUID = 1L;
    
   @Id
   @GeneratedValue
   @Column(name = "id_pessoa", nullable = false)
   private Long idPessoa;
   @Column(name = "nm_nome")
   private String nome;
   @Column(name = "ds_email")
   private String email;
   @Column(name = "nr_telefone")
   private String fone;
   @Column(name = "nr_cpf")
   private String cpf;
   @Column(name = "dt_nascimento")
   @Temporal(javax.persistence.TemporalType.DATE)
   private Date dataNascimento;
   @Column(name = "dt_cadastro")
   @Temporal(javax.persistence.TemporalType.TIMESTAMP)
   private Date dataCadastro;
   
   
   @OneToOne(mappedBy = "pessoa",fetch = FetchType.LAZY)
   @ForeignKey(name = "EnderecoPessoa")
   private Endereco endereco;

    
   
   @ManyToOne(optional = false)
   @ForeignKey(name = "PessoaSexo")
   @JoinColumn(name = "idSexo")
   private Sexo sexo;

   
   public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
   

    public Pessoa() {
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idPessoa);
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
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.idPessoa, other.idPessoa);
    }
   
   
   
}
