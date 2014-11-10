package gt.gob.segeplan.sisag.core.poa;

import gt.gob.segeplan.sisag.core.poa.PoaMeta;
import gt.gob.segeplan.sisag.core.poa.PoaProducto;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:22")
@StaticMetamodel(PoaSubProducto.class)
public class PoaSubProducto_ { 

    public static volatile ListAttribute<PoaSubProducto, PoaMeta> poaMetaList;
    public static volatile SingularAttribute<PoaSubProducto, String> descripcion;
    public static volatile SingularAttribute<PoaSubProducto, PoaProducto> idProducto;
    public static volatile SingularAttribute<PoaSubProducto, BigDecimal> idSubProducto;
    public static volatile SingularAttribute<PoaSubProducto, Character> restrictiva;

}