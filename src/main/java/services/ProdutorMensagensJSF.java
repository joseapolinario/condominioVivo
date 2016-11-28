
package services;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class ProdutorMensagensJSF {
      FacesContext context = FacesContext.getCurrentInstance();
      FacesMessage facesMessage;
      
      public void mostrarMensagem(String mensagem){
          facesMessage = new FacesMessage(mensagem);
          context.addMessage(null, facesMessage);
      }
}
