package gt.gob.segeplan.sisag.core.rrhh;

import gt.gob.segeplan.sisag.core.gen.GenEstado;
import gt.gob.segeplan.sisag.core.poa.PoaMeta;
import gt.gob.segeplan.sisag.core.rrhh.RrhhDetalleCapacitacion;
import gt.gob.segeplan.sisag.core.rrhh.RrhhUnidadAdministrativa;
import gt.gob.segeplan.sisag.core.seg.SegUsuario;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:22")
@StaticMetamodel(RrhhSolicitudCapacitacion.class)
public class RrhhSolicitudCapacitacion_ { 

    public static volatile SingularAttribute<RrhhSolicitudCapacitacion, SegUsuario> usrCrea;
    public static volatile SingularAttribute<RrhhSolicitudCapacitacion, BigDecimal> idSolicitudCapacitacion;
    public static volatile SingularAttribute<RrhhSolicitudCapacitacion, BigInteger> totalPersonal;
    public static volatile SingularAttribute<RrhhSolicitudCapacitacion, GenEstado> idEstado;
    public static volatile SingularAttribute<RrhhSolicitudCapacitacion, Character> restrictiva;
    public static volatile ListAttribute<RrhhSolicitudCapacitacion, RrhhDetalleCapacitacion> rrhhDetalleCapacitacionList;
    public static volatile SingularAttribute<RrhhSolicitudCapacitacion, PoaMeta> idMeta;
    public static volatile SingularAttribute<RrhhSolicitudCapacitacion, RrhhUnidadAdministrativa> idUnidadAdministrativa;
    public static volatile SingularAttribute<RrhhSolicitudCapacitacion, String> correlativo;

}