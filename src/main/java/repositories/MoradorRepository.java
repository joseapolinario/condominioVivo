package repositories;

import domain.Entities.Morador;
import java.util.List;
import javax.persistence.Query;
import javax.transaction.Transactional;

public class MoradorRepository extends RepositoryBase<Morador> {

    @Transactional
    public List listarMoradores() {
        Query q = getEm().createQuery("select m from Morador m", Morador.class);
        List<Morador> moradores = q.getResultList();

        return moradores;
    }
}