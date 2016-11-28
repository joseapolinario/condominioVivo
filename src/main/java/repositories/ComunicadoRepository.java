package repositories;

import domain.Entities.Comunicado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ComunicadoRepository extends RepositoryBase<Comunicado> {
    
    public ComunicadoRepository() {
    }

    public List listaComunicados(){
        Query q = getEm().createQuery("select c from Comunicado c",Comunicado.class);
        List comunicados = q.getResultList();
        
        return comunicados;
    }
    
    public ComunicadoRepository(EntityManager n) {
        super(n);
    }
}