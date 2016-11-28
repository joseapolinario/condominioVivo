
package repositories;
import domain.Entities.Ocorrencia;
import java.util.List;
import javax.persistence.Query;

public class OcorrenciaRepository extends RepositoryBase<Ocorrencia>{
    public List listarOcorrencia(){
        Query query = getEm().createQuery("select c from Ocorrencia c",Ocorrencia.class);
        List ocorrencias = query.getResultList();
        
        return ocorrencias;
    }
    
    public void inserirOcorrencia(Ocorrencia ocorrencia){
        
    }
}
