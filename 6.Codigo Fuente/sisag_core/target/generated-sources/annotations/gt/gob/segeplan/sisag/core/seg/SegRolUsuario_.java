package gt.gob.segeplan.sisag.core.seg;

import gt.gob.segeplan.sisag.core.seg.SegRol;
import gt.gob.segeplan.sisag.core.seg.SegRolUsuarioPK;
import gt.gob.segeplan.sisag.core.seg.SegUsuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:22")
@StaticMetamodel(SegRolUsuario.class)
public class SegRolUsuario_ { 

    public static volatile SingularAttribute<SegRolUsuario, SegRolUsuarioPK> segRolUsuarioPK;
    public static volatile SingularAttribute<SegRolUsuario, SegUsuario> segUsuario;
    public static volatile SingularAttribute<SegRolUsuario, Character> restrictiva;
    public static volatile SingularAttribute<SegRolUsuario, SegRol> segRol;

}