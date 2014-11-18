package gt.gob.segeplan.sisag.core.gen;

import gt.gob.segeplan.sisag.core.gen.GenPeriodo;
import gt.gob.segeplan.sisag.core.gen.GenSolicitudFinaciera;
import gt.gob.segeplan.sisag.core.poa.PoaMetaPeriodo;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:21")
@StaticMetamodel(GenPeriodo.class)
public class GenPeriodo_ { 

    public static volatile ListAttribute<GenPeriodo, GenSolicitudFinaciera> genSolicitudFinacieraList;
    public static volatile ListAttribute<GenPeriodo, PoaMetaPeriodo> poaMetaPeriodoList;
    public static volatile SingularAttribute<GenPeriodo, String> mes;
    public static volatile SingularAttribute<GenPeriodo, String> descripcion;
    public static volatile ListAttribute<GenPeriodo, GenPeriodo> genPeriodoList;
    public static volatile SingularAttribute<GenPeriodo, GenPeriodo> perIdPeriodo;
    public static volatile SingularAttribute<GenPeriodo, Character> restrictiva;
    public static volatile SingularAttribute<GenPeriodo, BigDecimal> idPeriodo;

}