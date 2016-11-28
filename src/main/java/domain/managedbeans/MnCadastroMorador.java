package domain.managedbeans;

import domain.Entities.Morador;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import repositories.MoradorRepository;
import services.ProdutorMensagensJSF;

@ManagedBean(name = "mnMorador")
@RequestScoped
public class MnCadastroMorador implements Serializable {

    private static final long serialVersionUID = 984394L;

    @Inject
    private MoradorRepository mr;

    @Inject
    private ProdutorMensagensJSF mensagemJsf;
    
    private List moradores;
    
    @Inject
    private Morador morador;

    public void cadastrarMorador() {
        mr.inserir(morador);
        mensagemJsf.mostrarMensagem("Morador cadastrado com sucesso !");
    }

    public Morador getMorador() {
        return this.morador;
    }

    @PostConstruct
    public void listarMoradores(){
        moradores = mr.listarMoradores();
    }
    
    public void setMorador(Morador morador) {
        this.morador = morador;
    }

    public List getMoradores() {
        return moradores;
    }

    public void setMoradores(List moradores) {
        this.moradores = moradores;
    }
}
