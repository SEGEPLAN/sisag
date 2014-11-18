package gt.gob.segeplan.sisag.core.seg;

import gt.gob.segeplan.sisag.core.seg.SegPrivilegioPagina;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:22")
@StaticMetamodel(SegPrivilegio.class)
public class SegPrivilegio_ { 

    public static volatile SingularAttribute<SegPrivilegio, String> nombre;
    public static volatile SingularAttribute<SegPrivilegio, BigDecimal> idPrivilegio;
    public static volatile SingularAttribute<SegPrivilegio, String> descripcion;
    public static volatile SingularAttribute<SegPrivilegio, Character> restrictiva;
    public static volatile ListAttribute<SegPrivilegio, SegPrivilegioPagina> segPrivilegioPaginaList;

}