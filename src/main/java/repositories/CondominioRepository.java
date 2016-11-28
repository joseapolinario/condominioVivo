package repositories;

import domain.Entities.Condominio;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Stateful
public class CondominioRepository extends RepositoryBase<Condominio> {

    @PersistenceContext(name = "CondominioVivoPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    public CondominioRepository() {
        super.setEm(em);
    }

    @Transactional
    public List listarCondominios() {
        Query q = getEm().createQuery("select c from Condominio c", Condominio.class);
        List<Condominio> condominios = q.getResultList();

        return condominios;
    }

    @Transactional
    public void excluir(Condominio com) {
        getEm().remove(com);
    }
}