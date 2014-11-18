package gt.gob.segeplan.sisag.core.katun;

import gt.gob.segeplan.sisag.core.katun.KatunEje;
import gt.gob.segeplan.sisag.core.katun.KatunMeta;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:21")
@StaticMetamodel(KatunPrioridad.class)
public class KatunPrioridad_ { 

    public static volatile ListAttribute<KatunPrioridad, KatunEje> katunEjeList;
    public static volatile SingularAttribute<KatunPrioridad, BigDecimal> idKatunPrioridad;
    public static volatile SingularAttribute<KatunPrioridad, KatunMeta> idKatunMeta;
    public static volatile SingularAttribute<KatunPrioridad, String> descripcion;
    public static volatile SingularAttribute<KatunPrioridad, Character> restrictiva;

}