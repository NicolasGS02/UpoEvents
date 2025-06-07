package Models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-07T13:27:19")
@StaticMetamodel(Publicaciones.class)
public class Publicaciones_ { 

    public static volatile SingularAttribute<Publicaciones, Integer> idOrganizacion;
    public static volatile SingularAttribute<Publicaciones, String> contenido;
    public static volatile SingularAttribute<Publicaciones, byte[]> imagen;
    public static volatile SingularAttribute<Publicaciones, String> titulo;
    public static volatile SingularAttribute<Publicaciones, Date> fechaPublicacion;
    public static volatile SingularAttribute<Publicaciones, Integer> idPublicacion;

}