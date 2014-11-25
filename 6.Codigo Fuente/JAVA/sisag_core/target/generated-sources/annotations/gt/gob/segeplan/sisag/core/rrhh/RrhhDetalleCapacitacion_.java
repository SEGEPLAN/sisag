package gt.gob.segeplan.sisag.core.rrhh;

import gt.gob.segeplan.sisag.core.rrhh.RrhhAsignaCapacitacion;
import gt.gob.segeplan.sisag.core.rrhh.RrhhCaracterCapacitacion;
import gt.gob.segeplan.sisag.core.rrhh.RrhhSolicitudCapacitacion;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:22")
@StaticMetamodel(RrhhDetalleCapacitacion.class)
public class RrhhDetalleCapacitacion_ { 

    public static volatile SingularAttribute<RrhhDetalleCapacitacion, RrhhCaracterCapacitacion> rrhhCaracterCapacitacion;
    public static volatile SingularAttribute<RrhhDetalleCapacitacion, Character> nivelEconomico;
    public static volatile SingularAttribute<RrhhDetalleCapacitacion, RrhhSolicitudCapacitacion> idSolicitudCapacitacion;
    public static volatile SingularAttribute<RrhhDetalleCapacitacion, BigDecimal> idDetalle;
    public static volatile ListAttribute<RrhhDetalleCapacitacion, RrhhAsignaCapacitacion> rrhhAsignaCapacitacionList;
    public static volatile SingularAttribute<RrhhDetalleCapacitacion, String> problematica;
    public static volatile SingularAttribute<RrhhDetalleCapacitacion, String> tema;
    public static volatile SingularAttribute<RrhhDetalleCapacitacion, Character> prioridad;
    public static volatile SingularAttribute<RrhhDetalleCapacitacion, String> idCaracter;
    public static volatile SingularAttribute<RrhhDetalleCapacitacion, Character> restrictiva;
    public static volatile SingularAttribute<RrhhDetalleCapacitacion, BigDecimal> duracion;

}