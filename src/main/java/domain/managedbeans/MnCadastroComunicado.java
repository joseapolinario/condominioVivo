package domain.managedbeans;

import domain.Entities.Comunicado;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import repositories.ComunicadoRepository;
import services.EmailCondominio;

@ManagedBean
@RequestScoped
public class MnCadastroComunicado implements Serializable {

    private static final long serialVersionUID = 984394L;

    @Inject
    private ComunicadoRepository cr;

    @Inject
    private Comunicado comunicado;

    private List<Comunicado> comunicados;

    public List<Comunicado> getComunicados() {
        return comunicados;
    }

    public void setComunicados(List<Comunicado> comunicados) {
        this.comunicados = comunicados;
    }
    
    public void cadastarComunicado() {
        Calendar c = Calendar.getInstance();
        comunicado.setDataComunicado(c.getTime());
        cr.inserir(comunicado);
        comunicado = new Comunicado();
        EmailCondominio email = new EmailCondominio();
    }

    public Comunicado getComunicado() {
        return comunicado;
    }

    public void setComunicado(Comunicado comunicado) {
        this.comunicado = comunicado;
    }
    
    @PostConstruct
    public void init(){
        comunicados = cr.listaComunicados();
    }
}