/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */ 
package gt.gob.segeplan.sisag.core.web.managed;

import java.io.IOException;
import java.util.logging.Level;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;

/**
 * @author layala
 */


public  class NavegacionManagedBean {
    private static Logger log = Logger.getLogger(NavegacionManagedBean.class);
    private static String paginaActual="accesos_directos.xhtml";
    
    public NavegacionManagedBean() {
    }

    public void navegar(String nombrePagina){
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(nombrePagina);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(NavegacionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        log.info("NAVEGAR HACIA: "+nombrePagina);
//        NavegacionManagedBean.paginaActual = nombrePagina;
    }
    
    
    
    public String getPaginaActual() {
        return paginaActual;
    }

    public void setPaginaActual(String paginaActual) {
        NavegacionManagedBean.paginaActual = paginaActual;
    }
    
    
    
}
