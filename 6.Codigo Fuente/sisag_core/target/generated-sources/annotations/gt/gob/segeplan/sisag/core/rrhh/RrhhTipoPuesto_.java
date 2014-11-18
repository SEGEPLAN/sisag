package gt.gob.segeplan.sisag.core.rrhh;

import gt.gob.segeplan.sisag.core.rrhh.RrhhPersona;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:21")
@StaticMetamodel(RrhhTipoPuesto.class)
public class RrhhTipoPuesto_ { 

    public static volatile SingularAttribute<RrhhTipoPuesto, String> nombre;
    public static volatile SingularAttribute<RrhhTipoPuesto, BigDecimal> idTipoPuesto;
    public static volatile SingularAttribute<RrhhTipoPuesto, String> descripcion;
    public static volatile SingularAttribute<RrhhTipoPuesto, Character> restrictiva;
    public static volatile ListAttribute<RrhhTipoPuesto, RrhhPersona> rrhhPersonaList;

}