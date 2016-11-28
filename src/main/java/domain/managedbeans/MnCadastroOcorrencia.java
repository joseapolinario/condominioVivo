
package domain.managedbeans;

import domain.Entities.Ocorrencia;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import repositories.OcorrenciaRepository;

@Named
public class MnCadastroOcorrencia {
    @Inject private OcorrenciaRepository or;
    @Inject private Ocorrencia ocorrencia;
    
    private List<Ocorrencia> ocorrencias;

    public List<Ocorrencia> getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(List<Ocorrencia> ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }
    
    public void cadastar(){
        or.inserir(ocorrencia);
    }
    
    @PostConstruct
    public void init(){
        ocorrencias = or.listarOcorrencia();
    }
}