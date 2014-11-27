package gt.gob.segeplan.sisag.core.web.utils;

import gt.gob.segeplan.sisag.rrhh.entities.SegUsuario;
import java.io.Serializable;
import java.util.HashSet;

/**
 *
 * @author layala
 */

public class sessionBean implements Serializable {

    private HashSet <SegUsuario> sessionList = new HashSet<SegUsuario>();

   // @ManagedProperty(value = "#{usuarios.usuario_logeado}")
    private SegUsuario objUsuario;

    
    public sessionBean() {
        objUsuario = new SegUsuario();
             
    }
    
     public void addSegUsuario(SegUsuario usuario){
         sessionList.add(usuario);
        
         objUsuario = usuario;
    }
    
    
    
    public SegUsuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(SegUsuario objUsuario) {
        this.objUsuario = objUsuario;
    }

    public HashSet<SegUsuario> getSessionList() {
        return sessionList;
    }

    public void setSessionList(HashSet<SegUsuario> sessionList) {
        this.sessionList = sessionList;
    }

    

    
    
    
}
