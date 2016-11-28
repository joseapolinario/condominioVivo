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
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ocorrencia")
public class Ocorrencia implements Serializable {

    private static final long serialVersionUID = 32323232L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOcorrencia")
    private Integer idOcorrencia;

    @Column(name = "tituloOcorrencia")
    @NotNull
    private String tituloOcorrencia;

    @Column(name = "ocorrencia")
    @NotNull
    @Size(min = 5, max = 150, message = "A ocorrencia deve ter entre 5 e 150 caracteres")
    private String ocorrencia;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Version
    @Column(name = "versao")
    private Integer versao;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIdOcorrencia() {
        return idOcorrencia;
    }

    public void setIdOcorrencia(Integer idOcorrencia) {
        this.idOcorrencia = idOcorrencia;
    }

    public String getTituloOcorrencia() {
        return tituloOcorrencia;
    }

    public void setTituloOcorrencia(String tituloOcorrencia) {
        this.tituloOcorrencia = tituloOcorrencia;
    }

    public String getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public Ocorrencia() {
    }

    public Ocorrencia(Integer idOcorrencia, String tituloOcorrencia) {
        this.idOcorrencia = idOcorrencia;
        this.tituloOcorrencia = tituloOcorrencia;
    }
}