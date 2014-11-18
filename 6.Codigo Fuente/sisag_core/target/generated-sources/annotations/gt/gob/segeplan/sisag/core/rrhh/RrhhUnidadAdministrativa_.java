package gt.gob.segeplan.sisag.core.rrhh;

import gt.gob.segeplan.sisag.core.poa.PoaMetaDireccion;
import gt.gob.segeplan.sisag.core.rrhh.RrhhSolicitudCapacitacion;
import gt.gob.segeplan.sisag.core.seg.SegRol;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:22")
@StaticMetamodel(RrhhUnidadAdministrativa.class)
public class RrhhUnidadAdministrativa_ { 

    public static volatile SingularAttribute<RrhhUnidadAdministrativa, String> nombre;
    public static volatile ListAttribute<RrhhUnidadAdministrativa, PoaMetaDireccion> poaMetaDireccionList;
    public static volatile ListAttribute<RrhhUnidadAdministrativa, SegRol> segRolList;
    public static volatile SingularAttribute<RrhhUnidadAdministrativa, BigDecimal> idUnidadAdmin;
    public static volatile SingularAttribute<RrhhUnidadAdministrativa, String> descripcion;
    public static volatile SingularAttribute<RrhhUnidadAdministrativa, Character> restrictiva;
    public static volatile SingularAttribute<RrhhUnidadAdministrativa, BigInteger> idSubordinado;
    public static volatile ListAttribute<RrhhUnidadAdministrativa, RrhhSolicitudCapacitacion> rrhhSolicitudCapacitacionList;

}