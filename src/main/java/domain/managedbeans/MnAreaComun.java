/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.managedbeans;

import domain.Entities.Local;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import repositories.LocalRepository;

@ManagedBean
@RequestScoped
public class MnAreaComun {
    
    private List<Local> locais;
    @Inject
    private LocalRepository lr;
    
    @PostConstruct
    public void init(){
        locais = lr.listarLocais();
    }

    public List<Local> getLocais() {
        return locais;
    }

    public void setLocais(List<Local> locais) {
        this.locais = locais;
    }
}
