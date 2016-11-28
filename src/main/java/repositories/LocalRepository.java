package repositories;
import domain.Entities.Local;
import domain.Entities.Morador;
import java.util.List;
import javax.persistence.Query;
import javax.transaction.Transactional;

public class LocalRepository extends RepositoryBase<Local> {
    @Transactional
    public List listarLocais() {
        Query q = getEm().createQuery("select m from Local m", Morador.class);
        List<Local> moradores = q.getResultList();

        return moradores;
    }
}