package gt.gob.segeplan.sisag.core.sisag.web.utils;



import gt.gob.segeplan.sisag.core.seg.SegUsuario;
import gt.gob.segeplan.sisag.core.sisag.web.implement.seguridadImplement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

// * @author layala

public class aplicationBean implements Serializable {

    private List<SegUsuario> usr_sesion = new ArrayList<SegUsuario>();
    private boolean loger;
    //  @ManagedProperty(value = "#{usuarios.usuario_logeado}")
    private seguridadImplement psUsr;
//
    public aplicationBean() {
//
        psUsr = seguridadImplement.getInstance();
     //   sesion = new Sesion();
 
    }

    public boolean addSegUsuario(SegUsuario usuario, int Band) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        sessionBean sessionBean = (sessionBean) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "sessionBean");
        
if(Band == 0){
        if (usr_sesion.contains(usuario)) {
            // ya existe 
            loger = true;
        } else {
            
            sessionBean.addSegUsuario(usuario);

            try {
                HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                String ip = httpServletRequest.getRemoteAddr();
                String host = httpServletRequest.getRemoteHost();

            } catch (Exception e) {
                e.printStackTrace();
            }
            usr_sesion.add(usuario);
            loger = false;
        }
        }
        else{
            
            sessionBean.addSegUsuario(usuario);
    
                    usr_sesion.add(usuario);
                    loger = false;
        }
        return loger;


    }

    public boolean removeSegUsuario(SegUsuario usuario) {

//        Sesion aux = new Sesion();

//        for (Sesion s : lst_usr_sesion) {
//            if (s.getIdSesion().intValue() == usuario.getIdUsr().intValue()){
//                aux = s;
//            }
//        }
//
//        if (aux.getIdSesion() != null) {
//            lst_usr_sesion.remove(aux);
//        }

        usr_sesion.remove(usuario);
        loger = false;

        return loger;
    }

    public List<SegUsuario> getUsr_sesion() {
        return usr_sesion;
    }

    public void setUsr_sesion(List<SegUsuario> usr_sesion) {
        this.usr_sesion = usr_sesion;
    }

//    public Sesion getSesion() {
//        return sesion;
//    }
//
//    public void setSesion(Sesion sesion) {
//        this.sesion = sesion;
//    }
//
//    public List<Sesion> getLst_sesion() {
//
//        if (lst_sesion == null) {
//            ActionResponse<List<Sesion>> response = psL.getLstCesiones();
//                if (response.getStatus() == ActionStatus.OK) 
//			lst_sesion =  response.getResult();
//            
//        }
//        return lst_sesion;
//    }
//
//    public void setLst_sesion(List<Sesion> lst_sesion) {
//        this.lst_sesion = lst_sesion;
//    }
//
//    public List<Sesion> getLst_usr_sesion() {
//        return lst_usr_sesion;
//    }
//
//    public void setLst_usr_sesion(List<Sesion> lst_usr_sesion) {
//        this.lst_usr_sesion = lst_usr_sesion;
//    }
}
