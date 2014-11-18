package gt.gob.segeplan.sisag.core.katun;

import gt.gob.segeplan.sisag.core.katun.KatunPrioridad;
import gt.gob.segeplan.sisag.core.poa.PoaMeta;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:22")
@StaticMetamodel(KatunMeta.class)
public class KatunMeta_ { 

    public static volatile ListAttribute<KatunMeta, PoaMeta> poaMetaList;
    public static volatile SingularAttribute<KatunMeta, BigDecimal> idKatunMeta;
    public static volatile SingularAttribute<KatunMeta, String> descripcion;
    public static volatile ListAttribute<KatunMeta, KatunPrioridad> katunPrioridadList;
    public static volatile SingularAttribute<KatunMeta, Character> restrictiva;

}