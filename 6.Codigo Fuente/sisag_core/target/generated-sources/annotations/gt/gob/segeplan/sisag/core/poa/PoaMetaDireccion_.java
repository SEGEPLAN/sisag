package gt.gob.segeplan.sisag.core.poa;

import gt.gob.segeplan.sisag.core.poa.PoaMeta;
import gt.gob.segeplan.sisag.core.poa.PoaMetaDireccionPK;
import gt.gob.segeplan.sisag.core.rrhh.RrhhUnidadAdministrativa;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T16:19:21")
@StaticMetamodel(PoaMetaDireccion.class)
public class PoaMetaDireccion_ { 

    public static volatile SingularAttribute<PoaMetaDireccion, Character> restrictiva;
    public static volatile SingularAttribute<PoaMetaDireccion, PoaMetaDireccionPK> poaMetaDireccionPK;
    public static volatile SingularAttribute<PoaMetaDireccion, String> observaciones;
    public static volatile SingularAttribute<PoaMetaDireccion, PoaMeta> poaMeta;
    public static volatile SingularAttribute<PoaMetaDireccion, RrhhUnidadAdministrativa> rrhhUnidadAdministrativa;

}