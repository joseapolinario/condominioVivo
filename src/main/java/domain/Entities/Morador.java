
package domain.Entities;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "morador")
public class Morador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMorador")
    private Integer idMorador;
    @Size(max = 40)
    @NotNull
    @Pattern(regexp = "^[A-Z][a-z]+([ ][A-Z][a-z]+)*$",message="Nome inválido")
    @Column(name = "nome")
    private String nome;
    @Size(min=2,max = 20)
    @NotNull
    @Column(name = "rg")
    private String rg;
    @Size(max = 15)
    @NotNull
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "apartamento")
    private String apartamento;

    @Column(name="email")
    @NotNull
    @Pattern(regexp = ".+@.+\\.[a-z]+",message = "Digite um email válido")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Morador() {}

    public Integer getIdMorador() {
        return idMorador;
    }

    public void setIdMorador(Integer idMorador) {
        this.idMorador = idMorador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMorador != null ? idMorador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Morador)) {
            return false;
        }
        Morador other = (Morador) object;
        if ((this.idMorador == null && other.idMorador != null) || (this.idMorador != null && !this.idMorador.equals(other.idMorador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Morador[ idMorador=" + idMorador + " ]";
    }
    
    @OneToOne(mappedBy = "morador")
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @ManyToOne
    private Condominio condominio;

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }
}