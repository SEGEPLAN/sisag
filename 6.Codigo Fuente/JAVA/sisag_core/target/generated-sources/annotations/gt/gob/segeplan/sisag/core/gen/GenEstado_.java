package gt.gob.segeplan.sisag.core.gen;

import gt.gob.segeplan.sisag.core.gen.GenSolicitudFinaciera;
import gt.gob.segeplan.sisag.core.rrhh.RrhhSolicitudCapacitacion;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:21")
@StaticMetamodel(GenEstado.class)
public class GenEstado_ { 

    public static volatile SingularAttribute<GenEstado, String> nombre;
    public static volatile ListAttribute<GenEstado, GenSolicitudFinaciera> genSolicitudFinacieraList;
    public static volatile SingularAttribute<GenEstado, String> descripcion;
    public static volatile SingularAttribute<GenEstado, BigDecimal> idEstado;
    public static volatile SingularAttribute<GenEstado, Character> restrictiva;
    public static volatile ListAttribute<GenEstado, RrhhSolicitudCapacitacion> rrhhSolicitudCapacitacionList;

}