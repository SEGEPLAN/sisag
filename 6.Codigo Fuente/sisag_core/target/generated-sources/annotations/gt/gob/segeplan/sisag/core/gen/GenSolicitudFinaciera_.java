package gt.gob.segeplan.sisag.core.gen;

import gt.gob.segeplan.sisag.core.gen.GenEstado;
import gt.gob.segeplan.sisag.core.gen.GenPeriodo;
import gt.gob.segeplan.sisag.core.gen.GenTipoSolicitud;
import gt.gob.segeplan.sisag.core.poa.PoaMeta;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:22")
@StaticMetamodel(GenSolicitudFinaciera.class)
public class GenSolicitudFinaciera_ { 

    public static volatile SingularAttribute<GenSolicitudFinaciera, BigInteger> codigo;
    public static volatile SingularAttribute<GenSolicitudFinaciera, BigDecimal> idSolicitud;
    public static volatile SingularAttribute<GenSolicitudFinaciera, BigInteger> idFuenteFinanciamiento;
    public static volatile SingularAttribute<GenSolicitudFinaciera, String> descripcion;
    public static volatile SingularAttribute<GenSolicitudFinaciera, GenEstado> idEstado;
    public static volatile SingularAttribute<GenSolicitudFinaciera, Date> fechaRealizacion;
    public static volatile SingularAttribute<GenSolicitudFinaciera, Character> restrictiva;
    public static volatile SingularAttribute<GenSolicitudFinaciera, PoaMeta> idMeta;
    public static volatile SingularAttribute<GenSolicitudFinaciera, GenTipoSolicitud> idTipoSolicitud;
    public static volatile SingularAttribute<GenSolicitudFinaciera, Date> fechaPago;
    public static volatile SingularAttribute<GenSolicitudFinaciera, GenPeriodo> idPeriodo;
    public static volatile SingularAttribute<GenSolicitudFinaciera, BigDecimal> monto;

}