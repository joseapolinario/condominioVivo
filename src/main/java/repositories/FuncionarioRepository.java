package repositories;

import domain.Entities.Funcionario;
import java.util.List;
import javax.persistence.Query;
import javax.transaction.Transactional;

public class FuncionarioRepository extends RepositoryBase<Funcionario> {

    @Transactional
    public List listarFuncionarios() {
        Query q = getEm().createQuery("select c from Funcionario c", Funcionario.class);
        List<Funcionario> funcionarios = q.getResultList();

        return funcionarios;
    }
}
