package gt.gob.segeplan.sisag.core.seg;

import gt.gob.segeplan.sisag.core.rrhh.RrhhPersona;
import gt.gob.segeplan.sisag.core.rrhh.RrhhSolicitudCapacitacion;
import gt.gob.segeplan.sisag.core.seg.SegPaginaAsignada;
import gt.gob.segeplan.sisag.core.seg.SegRolUsuario;
import gt.gob.segeplan.sisag.core.seg.SegSesion;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:21")
@StaticMetamodel(SegUsuario.class)
public class SegUsuario_ { 

    public static volatile ListAttribute<SegUsuario, SegPaginaAsignada> segPaginaAsignadaList;
    public static volatile SingularAttribute<SegUsuario, Long> telefono;
    public static volatile SingularAttribute<SegUsuario, Character> restrictiva;
    public static volatile SingularAttribute<SegUsuario, String> respuesta;
    public static volatile SingularAttribute<SegUsuario, String> nombre;
    public static volatile SingularAttribute<SegUsuario, String> pregunta;
    public static volatile SingularAttribute<SegUsuario, String> pwd;
    public static volatile ListAttribute<SegUsuario, SegSesion> segSesionList;
    public static volatile SingularAttribute<SegUsuario, BigDecimal> idUsuario;
    public static volatile SingularAttribute<SegUsuario, Character> estado;
    public static volatile SingularAttribute<SegUsuario, String> email;
    public static volatile ListAttribute<SegUsuario, SegRolUsuario> segRolUsuarioList;
    public static volatile SingularAttribute<SegUsuario, RrhhPersona> idPersona;
    public static volatile ListAttribute<SegUsuario, RrhhSolicitudCapacitacion> rrhhSolicitudCapacitacionList;

}