/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import domain.Entities.Usuario;
import javax.persistence.Query;

public class LoginRepository extends RepositoryBase<Usuario> {

    public Usuario login(String email, String senha) {
        Usuario usuario = null;
        try {
            String jpql = "select u from Usuario u where u.email = :email and u.senha = :senha";
            Query query = getEm().createQuery(jpql, Usuario.class);
            query.setParameter("email", email);
            query.setParameter("senha", senha);

            usuario = (Usuario) query.getResultList().get(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
