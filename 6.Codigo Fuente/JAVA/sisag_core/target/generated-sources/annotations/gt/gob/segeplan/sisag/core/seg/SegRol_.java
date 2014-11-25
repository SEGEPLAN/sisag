package gt.gob.segeplan.sisag.core.seg;

import gt.gob.segeplan.sisag.core.rrhh.RrhhUnidadAdministrativa;
import gt.gob.segeplan.sisag.core.seg.SegPaginaAsignada;
import gt.gob.segeplan.sisag.core.seg.SegRolUsuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:22")
@StaticMetamodel(SegRol.class)
public class SegRol_ { 

    public static volatile SingularAttribute<SegRol, String> nombre;
    public static volatile ListAttribute<SegRol, SegPaginaAsignada> segPaginaAsignadaList;
    public static volatile ListAttribute<SegRol, SegRolUsuario> segRolUsuarioList;
    public static volatile SingularAttribute<SegRol, String> descripcion;
    public static volatile SingularAttribute<SegRol, RrhhUnidadAdministrativa> idUnidadAdmin;
    public static volatile SingularAttribute<SegRol, Character> restrictiva;
    public static volatile SingularAttribute<SegRol, BigDecimal> idRol;

}