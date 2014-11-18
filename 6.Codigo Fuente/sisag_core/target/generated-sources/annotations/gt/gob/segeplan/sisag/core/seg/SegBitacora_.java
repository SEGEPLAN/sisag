package gt.gob.segeplan.sisag.core.seg;

import gt.gob.segeplan.sisag.core.seg.SegPagina;
import gt.gob.segeplan.sisag.core.seg.SegSesion;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:21")
@StaticMetamodel(SegBitacora.class)
public class SegBitacora_ { 

    public static volatile SingularAttribute<SegBitacora, Date> fechaCrea;
    public static volatile SingularAttribute<SegBitacora, String> operacion;
    public static volatile SingularAttribute<SegBitacora, SegPagina> idPagina;
    public static volatile SingularAttribute<SegBitacora, String> tablas;
    public static volatile SingularAttribute<SegBitacora, BigDecimal> idBitacora;
    public static volatile SingularAttribute<SegBitacora, SegSesion> idSesion;
    public static volatile SingularAttribute<SegBitacora, Character> restrictiva;
    public static volatile SingularAttribute<SegBitacora, Date> fechaMod;

}