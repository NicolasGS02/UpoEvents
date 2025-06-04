package Models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-05T01:12:00")
@StaticMetamodel(Eventos.class)
public class Eventos_ { 

    public static volatile SingularAttribute<Eventos, Integer> idOrganizacion;
    public static volatile SingularAttribute<Eventos, Date> fecha;
    public static volatile SingularAttribute<Eventos, String> ubicacion;
    public static volatile SingularAttribute<Eventos, String> informacion;
    public static volatile SingularAttribute<Eventos, Integer> idEvento;
    public static volatile SingularAttribute<Eventos, Integer> capacidad;

}