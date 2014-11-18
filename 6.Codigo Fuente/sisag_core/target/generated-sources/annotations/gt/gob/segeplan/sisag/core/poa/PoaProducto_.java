package gt.gob.segeplan.sisag.core.poa;

import gt.gob.segeplan.sisag.core.poa.PoaSubProducto;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:22")
@StaticMetamodel(PoaProducto.class)
public class PoaProducto_ { 

    public static volatile ListAttribute<PoaProducto, PoaSubProducto> poaSubProductoList;
    public static volatile SingularAttribute<PoaProducto, BigDecimal> idProducto;
    public static volatile SingularAttribute<PoaProducto, String> descripcion;
    public static volatile SingularAttribute<PoaProducto, BigInteger> inciso;
    public static volatile SingularAttribute<PoaProducto, Character> restrictiva;

}