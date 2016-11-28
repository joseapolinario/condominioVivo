package domain.managedbeans;

import domain.Entities.Usuario;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import repositories.LoginRepository;
import services.ProdutorMensagensJSF;

@ManagedBean
public class MnLogin {

    private String email;
    private String senha;

    @Inject
    private LoginRepository lr;

    public String realizarLogin() {
        Usuario usuario = lr.login(email, senha);
        if (usuario == null) {
            ProdutorMensagensJSF messa = new ProdutorMensagensJSF();
            messa.mostrarMensagem("Usuario inválido");
        }
        services.SessionContext.getInstance().setAttribute("usuario", usuario);

        return "/faces/index.xhtml?faces-redirect=true";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String sair() {
        services.SessionContext.getInstance().encerrarSessao();
        return "/faces/login.xhtml?faces-redirect=true";
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
