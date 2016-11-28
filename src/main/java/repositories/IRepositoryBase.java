
package repositories;

public interface IRepositoryBase<T> {
    public void inserir(T obj);
    public void remover(T obj);
    public void atualizar(T obj);
    public T obter(Class<?> t,Integer id);
}