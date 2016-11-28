package domain.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "comunicado")
public class Comunicado implements Serializable {

    private static final long serialVersionUID = 05731L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idComunicado")
    private Integer idComunicado;
    @Column(name = "comunicado")
    @NotNull
    @Size(min = 5, max = 100)
    private String comunicado;
    @Column(name = "dataComunicado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataComunicado;

    @Column(name = "nomeComunicao")
    @Size(min = 3, max = 15, message = "O nome do comunidao deve ter entre 3 e 15 caracteres")
    private String nomeComunicado;

    public Comunicado() {
    }

    public Integer getIdComunicado() {
        return idComunicado;
    }

    public void setIdComunicado(Integer idComunicado) {
        this.idComunicado = idComunicado;
    }

    public String getComunicado() {
        return comunicado;
    }

    public void setComunicado(String comunicado) {
        this.comunicado = comunicado;
    }

    public Date getDataComunicado() {
        return dataComunicado;
    }

    public void setDataComunicado(Date dataComunicado) {
        this.dataComunicado = dataComunicado;
    }

    public String getNomeComunicado() {
        return nomeComunicado;
    }

    public void setNomeComunicado(String nomeComunicado) {
        this.nomeComunicado = nomeComunicado;
    }

}
