/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */ 
package gt.gob.segeplan.sisag.core.web.managed;

import org.apache.log4j.Logger;

/**
 * @author layala
 */


public  class NavegacionManagedBean {
    private static Logger log = Logger.getLogger(NavegacionManagedBean.class);
    private static String paginaActual="contenido.xhtml";
    
    public NavegacionManagedBean() {
    }

    public void navegar(String nombrePagina){
        log.info("NAVEGAR HACIA: "+nombrePagina);
        NavegacionManagedBean.paginaActual = nombrePagina;
    }
    
    
    
    public String getPaginaActual() {
        return paginaActual;
    }

    public void setPaginaActual(String paginaActual) {
        NavegacionManagedBean.paginaActual = paginaActual;
    }
    
    
    
}
