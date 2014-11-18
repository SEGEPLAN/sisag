package gt.gob.segeplan.sisag.core.poa;

import gt.gob.segeplan.sisag.core.gen.GenSolicitudFinaciera;
import gt.gob.segeplan.sisag.core.gen.GenUnidadMedida;
import gt.gob.segeplan.sisag.core.katun.KatunMeta;
import gt.gob.segeplan.sisag.core.poa.PoaMetaDireccion;
import gt.gob.segeplan.sisag.core.poa.PoaMetaPeriodo;
import gt.gob.segeplan.sisag.core.poa.PoaSubProducto;
import gt.gob.segeplan.sisag.core.rrhh.RrhhSolicitudCapacitacion;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:22")
@StaticMetamodel(PoaMeta.class)
public class PoaMeta_ { 

    public static volatile ListAttribute<PoaMeta, GenSolicitudFinaciera> genSolicitudFinacieraList;
    public static volatile SingularAttribute<PoaMeta, GenUnidadMedida> idUnidadMedida;
    public static volatile ListAttribute<PoaMeta, PoaMetaPeriodo> poaMetaPeriodoList;
    public static volatile SingularAttribute<PoaMeta, BigInteger> resultadoEsperado;
    public static volatile ListAttribute<PoaMeta, PoaMetaDireccion> poaMetaDireccionList;
    public static volatile SingularAttribute<PoaMeta, KatunMeta> idKatunMeta;
    public static volatile SingularAttribute<PoaMeta, String> descripcion;
    public static volatile SingularAttribute<PoaMeta, PoaSubProducto> idSubProducto;
    public static volatile SingularAttribute<PoaMeta, Character> restrictiva;
    public static volatile SingularAttribute<PoaMeta, BigDecimal> idMeta;
    public static volatile ListAttribute<PoaMeta, RrhhSolicitudCapacitacion> rrhhSolicitudCapacitacionList;

}