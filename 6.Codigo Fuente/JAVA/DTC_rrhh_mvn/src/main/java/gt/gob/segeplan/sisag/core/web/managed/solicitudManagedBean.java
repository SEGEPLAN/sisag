/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */ 
package gt.gob.segeplan.sisag.core.web.managed;

import gt.gob.segeplan.sisag.core.web.implement.solicitudImplement;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhSolicitudCapacitacion;
import gt.gob.segeplan.sisag.rrhh.entities.SegUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 * @author layala
 */


public  class solicitudManagedBean implements Serializable{

    private solicitudImplement psSol;
    ResourceBundle datos = ResourceBundle.getBundle("SISAG");
    private SegUsuario usuario = new SegUsuario();
    
    
    // listados
    List<RrhhSolicitudCapacitacion> solicitudesDTC;

    public solicitudManagedBean() {
        usuario = ((SegUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"));
        psSol = solicitudImplement.getInstance();
        
    }
    
    // METODOS
    // GETTER Y SETTER
    public List<RrhhSolicitudCapacitacion> getSolicitudesDTC() {
        if(solicitudesDTC == null)
            solicitudesDTC = new ArrayList<RrhhSolicitudCapacitacion>();
        solicitudesDTC = psSol.getListSolicitudDTC_byUsr(0, usuario.getIdUsuario().intValue());
        return solicitudesDTC;
    }

    public void setSolicitudesDTC(List<RrhhSolicitudCapacitacion> solicitudesDTC) {
        this.solicitudesDTC = solicitudesDTC;
    }
    
    
    
}
