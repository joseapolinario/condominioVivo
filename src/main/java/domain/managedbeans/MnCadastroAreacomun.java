/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.managedbeans;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import domain.Entities.Local;
import javax.inject.Inject;
import repositories.LocalRepository;

@ManagedBean
@RequestScoped
public class MnCadastroAreacomun {
    
    @Inject 
    private Local local;
    
    
    
    @Inject
    private LocalRepository lr;

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
    public void cadastrarLocal(){
        lr.inserir(local);   
    }
}
