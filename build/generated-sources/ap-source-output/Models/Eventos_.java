package Models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-07T15:19:18")
@StaticMetamodel(Eventos.class)
public class Eventos_ { 

    public static volatile SingularAttribute<Eventos, String> nombreEvento;
    public static volatile SingularAttribute<Eventos, Integer> idOrganizacion;
    public static volatile SingularAttribute<Eventos, Date> fecha;
    public static volatile SingularAttribute<Eventos, String> ubicacion;
    public static volatile SingularAttribute<Eventos, String> informacion;
    public static volatile SingularAttribute<Eventos, Integer> idEvento;
    public static volatile SingularAttribute<Eventos, byte[]> imagen;
    public static volatile SingularAttribute<Eventos, Integer> capacidad;

}