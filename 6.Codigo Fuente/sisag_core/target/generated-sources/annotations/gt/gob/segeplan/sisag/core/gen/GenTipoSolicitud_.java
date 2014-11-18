package gt.gob.segeplan.sisag.core.gen;

import gt.gob.segeplan.sisag.core.gen.GenSolicitudFinaciera;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:22")
@StaticMetamodel(GenTipoSolicitud.class)
public class GenTipoSolicitud_ { 

    public static volatile SingularAttribute<GenTipoSolicitud, String> nombre;
    public static volatile ListAttribute<GenTipoSolicitud, GenSolicitudFinaciera> genSolicitudFinacieraList;
    public static volatile SingularAttribute<GenTipoSolicitud, Character> restrictiva;
    public static volatile SingularAttribute<GenTipoSolicitud, BigDecimal> idTipoSolicitud;

}