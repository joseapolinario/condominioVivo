package domain.managedbeans;

import domain.Entities.Funcionario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import repositories.FuncionarioRepository;
import services.ProdutorMensagensJSF;

@ManagedBean(name = "mnCadastroFuncionario")
public class MnCadastroFuncionario implements Serializable {

    private static final long serialVersionUID = 988938884L;

    @Inject
    private FuncionarioRepository fr;
    
    @Inject
    private ProdutorMensagensJSF mensagemJsf;
    
    @Inject
    private Funcionario funcionario;
    
    private List funcionarios;
    
    public void cadastrarFuncionario() {
        fr.inserir(funcionario);
        mensagemJsf.mostrarMensagem("Funcionario cadastrado com sucesso !");
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    @PostConstruct
    public void init(){
        funcionarios = fr.listarFuncionarios();
    }
}
