package domain.managedbeans;

import domain.Entities.Condominio;
import domain.Entities.Ocorrencia;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import repositories.CondominioRepository;
import services.ProdutorMensagensJSF;

@Named
@ViewScoped
public class MnCadastroCondominio implements Serializable {

    private static final long serialVersionUID = 984394L;

    @Inject
    private CondominioRepository cr;
    private List condominios;

    @Inject
    private Condominio condominio;

    @Inject
    private Ocorrencia ocorrencia;

    @Inject
    private ProdutorMensagensJSF mensagemJsf;
    
    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MnCadastroCondominio other = (MnCadastroCondominio) obj;
        return true;
    }
    @Inject
    public Condominio getCondominio() {
        return condominio;
    }

    @Inject
    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public List getCondominios() {
        return condominios;
    }

    public void setCondominios(List condominios) {
        this.condominios = condominios;
    }

    public MnCadastroCondominio() {
    }

    public void cadastrar() {
        cr.inserir(condominio);
        System.out.println(condominio.toString());
        //condominio = new Condominio();
        mensagemJsf.mostrarMensagem("Condominio cadastrado com sucesso");
    }

    public void visualizar() {
        condominio = (Condominio) cr.obter(Condominio.class, 1);
    }

    public void show(){
        System.out.println("O maldito botão foi pressionado");
        System.out.println(condominio.getNomeCondominio());
    }
    
    public void alterar() {
    }

    public void excluir(Condominio c) {
        try {
            cr.excluir(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void init() {
        try {
            condominios = (List) cr.listarCondominios();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String editar(){
        return "";
    }
}