package gt.gob.segeplan.sisag.core.seg;

import gt.gob.segeplan.sisag.core.seg.SegPagina;
import gt.gob.segeplan.sisag.core.seg.SegPrivilegioPagina;
import gt.gob.segeplan.sisag.core.seg.SegRol;
import gt.gob.segeplan.sisag.core.seg.SegUsuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:21")
@StaticMetamodel(SegPaginaAsignada.class)
public class SegPaginaAsignada_ { 

    public static volatile SingularAttribute<SegPaginaAsignada, SegPagina> idPagina;
    public static volatile SingularAttribute<SegPaginaAsignada, SegUsuario> idUsuario;
    public static volatile SingularAttribute<SegPaginaAsignada, BigDecimal> idAsignacion;
    public static volatile SingularAttribute<SegPaginaAsignada, Character> restrictiva;
    public static volatile ListAttribute<SegPaginaAsignada, SegPrivilegioPagina> segPrivilegioPaginaList;
    public static volatile SingularAttribute<SegPaginaAsignada, SegRol> idRol;

}