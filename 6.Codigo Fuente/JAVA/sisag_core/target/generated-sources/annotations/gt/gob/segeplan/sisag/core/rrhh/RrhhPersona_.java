package gt.gob.segeplan.sisag.core.rrhh;

import gt.gob.segeplan.sisag.core.rrhh.RrhhAsignaCapacitacion;
import gt.gob.segeplan.sisag.core.rrhh.RrhhPersona;
import gt.gob.segeplan.sisag.core.rrhh.RrhhTipoPuesto;
import gt.gob.segeplan.sisag.core.seg.SegUsuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:21")
@StaticMetamodel(RrhhPersona.class)
public class RrhhPersona_ { 

    public static volatile SingularAttribute<RrhhPersona, String> direccion;
    public static volatile SingularAttribute<RrhhPersona, String> correoElectronico;
    public static volatile SingularAttribute<RrhhPersona, String> nombres;
    public static volatile SingularAttribute<RrhhPersona, String> apellidos;
    public static volatile ListAttribute<RrhhPersona, RrhhAsignaCapacitacion> rrhhAsignaCapacitacionList;
    public static volatile SingularAttribute<RrhhPersona, RrhhTipoPuesto> idTipoPuesto;
    public static volatile SingularAttribute<RrhhPersona, Long> telefono;
    public static volatile ListAttribute<RrhhPersona, SegUsuario> segUsuarioList;
    public static volatile SingularAttribute<RrhhPersona, Character> restrictiva;
    public static volatile SingularAttribute<RrhhPersona, BigDecimal> idPersona;
    public static volatile SingularAttribute<RrhhPersona, RrhhPersona> idEncargado;
    public static volatile ListAttribute<RrhhPersona, RrhhPersona> rrhhPersonaList;

}