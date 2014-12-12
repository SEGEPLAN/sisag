/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */ 
package gt.gob.segeplan.sisag.core.web.managed;

import gt.gob.segeplan.sisag.core.web.implement.catalogosImplement;
import gt.gob.segeplan.sisag.core.web.implement.seguridadImplement;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhNecesidad;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhTemaCurso;
import gt.gob.segeplan.sisag.rrhh.entities.SegUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 * @author layala
 */


public  class catalogosManagedBean implements Serializable{

    private catalogosImplement psCat;
    private seguridadImplement psSeg;
    ResourceBundle datos = ResourceBundle.getBundle("SISAG");
    private SegUsuario usuario = new SegUsuario();


    // listados
    private List<RrhhTemaCurso> lstCursos;
    

    //OBJETOS
    private RrhhTemaCurso CursoAux;
    private RrhhTemaCurso Curso;
    
    //CATALOGOS
     


    public catalogosManagedBean() {
        usuario = ((SegUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"));
        psCat = catalogosImplement.getInstance();
        psSeg = seguridadImplement.getInstance();

        // Asignandoles memoria (instanciandolos objetos)
         Curso = new RrhhTemaCurso();
          
    }

    // METODOS
    
    public void newCurso(){
       Curso = new RrhhTemaCurso();
        if(lstCursos != null){
                 CursoAux = lstCursos.get(0);
             }
    }
    
     public void llenarCombos(){
           FacesMessage msg = null;
         if(CursoAux==null){
              msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"No se ha seleccionado", "Una fila de la tabla");
              FacesContext.getCurrentInstance().addMessage(null, msg);
         }
     }
    
    public void onRowSelect(SelectEvent event) {
        CursoAux = new RrhhTemaCurso();
        CursoAux = (RrhhTemaCurso)event.getObject();
        //llenarCombos();
    }
    
    public void guardarCurso(){
        Curso.setRestrictiva(1);
        lstCursos.add(psCat.crearTemaCurso(Curso));
        Curso = new RrhhTemaCurso();
}
    
    public void editarCurso(){
        psCat.editarTemaCurso(CursoAux);
        lstCursos = new ArrayList<RrhhTemaCurso>();
            lstCursos = psCat.getListTemaCurso();
             Curso = new RrhhTemaCurso();
        }
    
    public void eliminarCurso() {
        String band ="";
        String objeto;
         FacesMessage msg = null;
        if(CursoAux!=null){
            lstCursos.remove(CursoAux);
            CursoAux.setRestrictiva(0);
            psCat.editarTemaCurso(CursoAux);
             band = "SI";
            //band = psCat.borrarTemaCurso(CursoAux);
            objeto = CursoAux.getNombre();

            if(band.contentEquals("NO")){
                lstCursos.add(CursoAux);
            }
             msg = new FacesMessage(FacesMessage.SEVERITY_INFO,band+" se pudo borrar el curso ", objeto);
        } else {
            band = "No ha seleccionado ninguna fila";
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, band, null);
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    //GETTER Y SETTER
    public List<RrhhTemaCurso> getLstCursos() {
        if(lstCursos == null){
            CursoAux = new RrhhTemaCurso();
            lstCursos = new ArrayList<RrhhTemaCurso>();
            lstCursos = psCat.getListTemaCurso();
            
        }
        return lstCursos;
    }

    public void setLstCursos(List<RrhhTemaCurso> lstCursos) {
        this.lstCursos = lstCursos;
    }

    public RrhhTemaCurso getCursoAux() {
        return CursoAux;
    }

    public void setCursoAux(RrhhTemaCurso CursoAux) {
        this.CursoAux = CursoAux;
    }

    public RrhhTemaCurso getCurso() {
        return Curso;
    }

    public void setCurso(RrhhTemaCurso Curso) {
        this.Curso = Curso;
    }
    


}
