package domain.Entities;

import domain.Entities.Condominio;
import domain.Entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-26T22:16:22")
@StaticMetamodel(Morador.class)
public class Morador_ { 

    public static volatile SingularAttribute<Morador, String> apartamento;
    public static volatile SingularAttribute<Morador, String> telefone;
    public static volatile SingularAttribute<Morador, String> rg;
    public static volatile SingularAttribute<Morador, Condominio> condominio;
    public static volatile SingularAttribute<Morador, String> nome;
    public static volatile SingularAttribute<Morador, Usuario> usuario;
    public static volatile SingularAttribute<Morador, String> email;
    public static volatile SingularAttribute<Morador, Integer> idMorador;

}