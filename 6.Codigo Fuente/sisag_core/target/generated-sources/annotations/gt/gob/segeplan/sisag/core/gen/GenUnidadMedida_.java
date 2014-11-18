package gt.gob.segeplan.sisag.core.gen;

import gt.gob.segeplan.sisag.core.poa.PoaMeta;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:22")
@StaticMetamodel(GenUnidadMedida.class)
public class GenUnidadMedida_ { 

    public static volatile SingularAttribute<GenUnidadMedida, BigDecimal> idUnidadMedida;
    public static volatile ListAttribute<GenUnidadMedida, PoaMeta> poaMetaList;
    public static volatile SingularAttribute<GenUnidadMedida, String> descripcion;
    public static volatile SingularAttribute<GenUnidadMedida, Character> restrictiva;

}