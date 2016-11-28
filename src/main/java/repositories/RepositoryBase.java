package repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

public class RepositoryBase<T> implements IRepositoryBase<T> {

    private static final long serialVersionUID = 23222232L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @PersistenceContext(name = "CondominioVivoPU")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public RepositoryBase(EntityManager mn) {
        this.em = mn;
    }

    public RepositoryBase() {
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Transactional
    @Override
    public void inserir(T obj) {
        try {
            em.persist(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    @Override
    public void remover(T obj) {
        try {
            em.remove(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    @Override
    public T obter(Class<?> t, Integer id) {
        T element;
        element = (T) em.find(t, id);

        return element;
    }

    @Override
    @Transactional
    public void atualizar(T obj) {
        try {
            em.merge(obj);
        } catch (Exception e) {

        }
    }
}
