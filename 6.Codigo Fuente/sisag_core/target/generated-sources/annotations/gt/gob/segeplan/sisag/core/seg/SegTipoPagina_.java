package gt.gob.segeplan.sisag.core.seg;

import gt.gob.segeplan.sisag.core.seg.SegPagina;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:21")
@StaticMetamodel(SegTipoPagina.class)
public class SegTipoPagina_ { 

    public static volatile SingularAttribute<SegTipoPagina, String> nombre;
    public static volatile SingularAttribute<SegTipoPagina, BigDecimal> idTipoPagina;
    public static volatile SingularAttribute<SegTipoPagina, String> descripcion;
    public static volatile ListAttribute<SegTipoPagina, SegPagina> segPaginaList;

}