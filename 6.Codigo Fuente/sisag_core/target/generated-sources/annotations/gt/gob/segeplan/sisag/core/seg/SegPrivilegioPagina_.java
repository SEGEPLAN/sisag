package gt.gob.segeplan.sisag.core.seg;

import gt.gob.segeplan.sisag.core.seg.SegPaginaAsignada;
import gt.gob.segeplan.sisag.core.seg.SegPrivilegio;
import gt.gob.segeplan.sisag.core.seg.SegPrivilegioPaginaPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:22")
@StaticMetamodel(SegPrivilegioPagina.class)
public class SegPrivilegioPagina_ { 

    public static volatile SingularAttribute<SegPrivilegioPagina, SegPrivilegioPaginaPK> segPrivilegioPaginaPK;
    public static volatile SingularAttribute<SegPrivilegioPagina, Character> restrictiva;
    public static volatile SingularAttribute<SegPrivilegioPagina, SegPrivilegio> segPrivilegio;
    public static volatile SingularAttribute<SegPrivilegioPagina, SegPaginaAsignada> segPaginaAsignada;

}