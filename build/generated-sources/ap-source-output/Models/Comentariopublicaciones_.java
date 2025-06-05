package Models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-05T16:55:08")
@StaticMetamodel(Comentariopublicaciones.class)
public class Comentariopublicaciones_ { 

    public static volatile SingularAttribute<Comentariopublicaciones, Date> fechaComentario;
    public static volatile SingularAttribute<Comentariopublicaciones, String> correo;
    public static volatile SingularAttribute<Comentariopublicaciones, byte[]> imagen;
    public static volatile SingularAttribute<Comentariopublicaciones, String> comentario;
    public static volatile SingularAttribute<Comentariopublicaciones, Integer> idPublicacion;
    public static volatile SingularAttribute<Comentariopublicaciones, Integer> idComentario;

}