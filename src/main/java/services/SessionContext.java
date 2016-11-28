/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Entities.Usuario;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.Session;

public class SessionContext {

    private static SessionContext instance;

    public static SessionContext getInstance() {
        if (instance == null) {
            instance = new SessionContext();
        }
        return instance;
    }
    
    public SessionContext(){
        
    }
    
    private ExternalContext currentExternalContext(){
        if(FacesContext.getCurrentInstance() == null){
            throw new RuntimeException("O facescontext não pode ser chamado fora de uma requisição http");
        }else{
            return FacesContext.getCurrentInstance().getExternalContext();
        }
    }
    public Usuario getUsuarioLogado(){
        return (Usuario) getAttribute("usuarioLogado");
    }
    public void setUsuarioLogado(Usuario usuario){
        setAttribute("usuarioLogado",usuario);
    }
    public void encerrarSessao(){
        currentExternalContext().invalidateSession();
    }
    public Object getAttribute(String nome){
        return currentExternalContext().getSessionMap().get(nome);
    }
    public void setAttribute(String nome, Object valor){
        currentExternalContext().getSessionMap().put(nome, valor);
    }
}
