package gt.gob.segeplan.sisag.core.seg;

import gt.gob.segeplan.sisag.core.seg.SegPagina;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:22")
@StaticMetamodel(SegModulo.class)
public class SegModulo_ { 

    public static volatile SingularAttribute<SegModulo, String> nombre;
    public static volatile SingularAttribute<SegModulo, BigDecimal> idModulo;
    public static volatile SingularAttribute<SegModulo, String> descripcion;
    public static volatile ListAttribute<SegModulo, SegPagina> segPaginaList;
    public static volatile SingularAttribute<SegModulo, Character> restrictiva;

}