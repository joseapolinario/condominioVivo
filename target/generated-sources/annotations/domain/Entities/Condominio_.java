package domain.Entities;

import domain.Entities.Morador;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-26T22:16:22")
@StaticMetamodel(Condominio.class)
public class Condominio_ { 

    public static volatile SingularAttribute<Condominio, String> telefoneCondominio;
    public static volatile ListAttribute<Condominio, Morador> moradores;
    public static volatile SingularAttribute<Condominio, String> endereco;
    public static volatile SingularAttribute<Condominio, Integer> idCondominio;
    public static volatile SingularAttribute<Condominio, String> cnpj;
    public static volatile SingularAttribute<Condominio, String> nomeCondominio;

}