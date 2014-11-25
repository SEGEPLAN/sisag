package gt.gob.segeplan.sisag.core.seg;

import gt.gob.segeplan.sisag.core.seg.SegBitacora;
import gt.gob.segeplan.sisag.core.seg.SegUsuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:22")
@StaticMetamodel(SegSesion.class)
public class SegSesion_ { 

    public static volatile SingularAttribute<SegSesion, SegUsuario> idUsuario;
    public static volatile SingularAttribute<SegSesion, Date> horaInicio;
    public static volatile ListAttribute<SegSesion, SegBitacora> segBitacoraList;
    public static volatile SingularAttribute<SegSesion, Date> horaFin;
    public static volatile SingularAttribute<SegSesion, BigDecimal> idSesion;
    public static volatile SingularAttribute<SegSesion, Date> fechaSesion;
    public static volatile SingularAttribute<SegSesion, Character> restrictiva;

}