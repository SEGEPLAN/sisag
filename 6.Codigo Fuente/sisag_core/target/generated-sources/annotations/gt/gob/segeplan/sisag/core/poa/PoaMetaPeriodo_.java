package gt.gob.segeplan.sisag.core.poa;

import gt.gob.segeplan.sisag.core.gen.GenPeriodo;
import gt.gob.segeplan.sisag.core.poa.PoaMeta;
import gt.gob.segeplan.sisag.core.poa.PoaMetaPeriodoPK;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:22")
@StaticMetamodel(PoaMetaPeriodo.class)
public class PoaMetaPeriodo_ { 

    public static volatile SingularAttribute<PoaMetaPeriodo, BigInteger> resultadoProgramado;
    public static volatile SingularAttribute<PoaMetaPeriodo, BigInteger> resultadoEjecutado;
    public static volatile SingularAttribute<PoaMetaPeriodo, Character> restrictiva;
    public static volatile SingularAttribute<PoaMetaPeriodo, PoaMetaPeriodoPK> poaMetaPeriodoPK;
    public static volatile SingularAttribute<PoaMetaPeriodo, String> observaciones;
    public static volatile SingularAttribute<PoaMetaPeriodo, PoaMeta> poaMeta;
    public static volatile SingularAttribute<PoaMetaPeriodo, GenPeriodo> genPeriodo;

}