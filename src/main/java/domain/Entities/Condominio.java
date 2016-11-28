/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author js
 */
@Entity
@Table(name = "condominio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Condominio.findAll", query = "SELECT c FROM Condominio c"),
    @NamedQuery(name = "Condominio.findByIdCondominio", query = "SELECT c FROM Condominio c WHERE c.idCondominio = :idCondominio"),
    @NamedQuery(name = "Condominio.findByCnpj", query = "SELECT c FROM Condominio c WHERE c.cnpj = :cnpj"),
    @NamedQuery(name = "Condominio.findByEndereco", query = "SELECT c FROM Condominio c WHERE c.endereco = :endereco"),
    @NamedQuery(name = "Condominio.findByNomeCondominio", query = "SELECT c FROM Condominio c WHERE c.nomeCondominio = :nomeCondominio"),
    @NamedQuery(name = "Condominio.findByTelefoneCondominio", query = "SELECT c FROM Condominio c WHERE c.telefoneCondominio = :telefoneCondominio")})
public class Condominio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCondominio")
    private Integer idCondominio;
    @Size(min=14,max = 14, message="O campo CNPJ deve ter 14 caracteres")
    @Column(name = "CNPJ")
    @NotNull(message="O campo CNPJ deve ser preenchido obrigatoriamente")
    private String cnpj;
    @Size(min=3,max = 40, message="Preencha o campo endereço com pelo menos 3 caracteres")
    @Column(name = "Endereco")
    @NotNull
    private String endereco;
    @Size(min= 3,max = 30,message = "o nome do condominio deve ter entre 3 e 30 caracteres")
    @Column(name = "nomeCondominio")
    private String nomeCondominio;
    @Size(min = 8,max = 14, message="O campo telefone deve ter entre 8 e 14 caracteres")
    @Column(name = "telefoneCondominio")
    @NotNull(message="O campo telefone deve ser preenchido obrigatoriamente")
    private String telefoneCondominio;

    public Condominio() {
    }

    public Condominio(Integer idCondominio) {
        this.idCondominio = idCondominio;
    }

    public Integer getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(Integer idCondominio) {
        this.idCondominio = idCondominio;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNomeCondominio() {
        return nomeCondominio;
    }

    public void setNomeCondominio(String nomeCondominio) {
        this.nomeCondominio = nomeCondominio;
    }

    public String getTelefoneCondominio() {
        return telefoneCondominio;
    }

    public void setTelefoneCondominio(String telefoneCondominio) {
        this.telefoneCondominio = telefoneCondominio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCondominio != null ? idCondominio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Condominio)) {
            return false;
        }
        Condominio other = (Condominio) object;
        if ((this.idCondominio == null && other.idCondominio != null) || (this.idCondominio != null && !this.idCondominio.equals(other.idCondominio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Condominio[ idCondominio=" + idCondominio + " ]";
    }
    @OneToMany(mappedBy = "condominio",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Morador> moradores;

    public List<Morador> getMoradores() {
        return moradores;
    }

    public void setMoradores(List<Morador> moradores) {
        this.moradores = moradores;
    }    
}