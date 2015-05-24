package com.alesilva.model.entity;

import java.io.Serializable;
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
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{
   private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "id_endereco",nullable = false)
    private Long idEndereco;
    @Column(name = "ds_bairro")
    private String bairro;
    @Column(name = "ds_logradouro")
    private String nomeLogradouro;
    @Column(name="ds_cep")
    private String  cep;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "ds_complemento")
    private String complemento;
    
    
    @OneToOne(optional = true , fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoPessoa")
    @JoinColumn(name = "id_pessoa",referencedColumnName = "idPessoa")
    private Pessoa pessoa ;
    
    @ManyToOne(optional = false ,fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoEstado_fk")
    @JoinColumn(name = "idEstado",referencedColumnName = "idEstado")
    private Estado estado;
    

   @ManyToOne(optional = false,fetch = FetchType.LAZY)
   @ForeignKey(name = "EnderecoTipoEndereco")
   @JoinColumn(name = "idTipoEndereco",referencedColumnName = "idTipoEndererco")
   private TipoEndereco   tipoendereco;
   
   @ManyToOne(optional = false,fetch = FetchType.LAZY)
   @ForeignKey(name = "EnderecoTipoLogradouro")
   @JoinColumn(name = "idTipoLogradouro",referencedColumnName = "idTipoLogradouro")
   private TipoLogradouro tipologradouro;
   
   @ManyToOne(optional = false,fetch = FetchType.LAZY)
   @ForeignKey(name = "Enderecocidade")
   @JoinColumn(name = "idCidade",referencedColumnName = "idCidade")
   private cidade  cidade;
    

    public Endereco() {
        this.cidade = new cidade();
        this.estado = new Estado();
        this.tipologradouro = new TipoLogradouro();
        this.tipoendereco = new TipoEndereco();
        this.pessoa = new Pessoa();  
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public TipoLogradouro getTipologradouro() {
        return tipologradouro;
    }

    public void setTipologradouro(TipoLogradouro tipologradouro) {
        this.tipologradouro = tipologradouro;
    }
    

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoEndereco getTipoendereco() {
        return tipoendereco;
    }

    public void setTipoendereco(TipoEndereco tipoendereco) {
        this.tipoendereco = tipoendereco;
    }

    public cidade getCidade() {
        return cidade;
    }

    public void setCidade(cidade cidade) {
        this.cidade = cidade;
    }
    
    
    
    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.idEndereco);
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
        final Endereco other = (Endereco) obj;
        return Objects.equals(this.idEndereco, other.idEndereco);
    }
    
    
    
}
