package gt.gob.segeplan.sisag.core.seg;

import gt.gob.segeplan.sisag.core.seg.SegBitacora;
import gt.gob.segeplan.sisag.core.seg.SegModulo;
import gt.gob.segeplan.sisag.core.seg.SegPaginaAsignada;
import gt.gob.segeplan.sisag.core.seg.SegTipoPagina;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:22")
@StaticMetamodel(SegPagina.class)
public class SegPagina_ { 

    public static volatile SingularAttribute<SegPagina, String> nombre;
    public static volatile SingularAttribute<SegPagina, SegTipoPagina> idTipoPagina;
    public static volatile SingularAttribute<SegPagina, BigDecimal> idPagina;
    public static volatile ListAttribute<SegPagina, SegPaginaAsignada> segPaginaAsignadaList;
    public static volatile SingularAttribute<SegPagina, SegModulo> idModulo;
    public static volatile ListAttribute<SegPagina, SegBitacora> segBitacoraList;
    public static volatile SingularAttribute<SegPagina, String> descripcion;
    public static volatile SingularAttribute<SegPagina, Character> restrictiva;
    public static volatile SingularAttribute<SegPagina, String> url;

}