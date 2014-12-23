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
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;

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
    
// 
    private HorizontalBarChartModel horizontalBarModel;
    
    //OBJETOS
    
    private RrhhTemaCurso Curso;
    private RrhhTemaCurso CursoAux;
    
    //CATALOGOS
     


    public catalogosManagedBean() {
        usuario = ((SegUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"));
        psCat = catalogosImplement.getInstance();
        psSeg = seguridadImplement.getInstance();

        // Asignandoles memoria (instanciandolos objetos)
         Curso = new RrhhTemaCurso();
         CursoAux = new RrhhTemaCurso();
          
    }

    // METODOS
    
    public void newCurso(){
       Curso = new RrhhTemaCurso();

    }
    
     public void llenarCombos(){
           FacesMessage msg = null;
         if(Curso.getIdTema()==null){
              msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"No se ha seleccionado", "Una fila de la tabla");
              FacesContext.getCurrentInstance().addMessage(null, msg);
         }
     }
    
    public void onRowSelect(SelectEvent event) {
        Curso = new RrhhTemaCurso();
        Curso = (RrhhTemaCurso)event.getObject();
        //llenarCombos();
    }
    
    public void guardarCurso(){
        Curso.setRestrictiva(1);
        lstCursos.add(psCat.crearTemaCurso(Curso));
        Curso = new RrhhTemaCurso();
}
    
    public void editarCurso(){
        psCat.editarTemaCurso(Curso);
        lstCursos = new ArrayList<RrhhTemaCurso>();
            lstCursos = psCat.getListTemaCurso();
             Curso = new RrhhTemaCurso();
        }
    
    public void eliminarCurso() {
        String band ="";
        String objeto;
         FacesMessage msg = null;
        if(Curso!=null){
            lstCursos.remove(Curso);
            Curso.setRestrictiva(0);
            psCat.editarTemaCurso(Curso);
             band = "SI";
            //band = psCat.borrarTemaCurso(CursoAux);
            objeto = Curso.getNombre();

            if(band.contentEquals("NO")){
                lstCursos.add(Curso);
            }
            lstCursos = psCat.getListTemaCurso();
             Curso = new RrhhTemaCurso();
             msg = new FacesMessage(FacesMessage.SEVERITY_INFO,band+" se pudo borrar el curso ", objeto);
        } else {
            band = "No ha seleccionado ninguna fila";
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, band, null);
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
     private void createHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();
        ChartSeries curso = new ChartSeries();
        for(RrhhTemaCurso t : lstCursos){
            if(!t.getRrhhNecesidadList().isEmpty()){
                curso.setLabel("Curso");
                curso.set(t.getNombre().substring(0, 10), t.getRrhhNecesidadList().size());
            }
        }
        horizontalBarModel.addSeries(curso);
        
        horizontalBarModel.setTitle("Grafica de Cursos");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setAnimate(true);
        horizontalBarModel.setZoom(true);
         
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("Total de Asignaciones");
        
//        xAxis.setMin(0);
        xAxis.setMax(100);
         
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("Cursos");    
        
              
    }
    
    
    //GETTER Y SETTER
    public List<RrhhTemaCurso> getLstCursos() {
        if(lstCursos == null){
           // Curso = new RrhhTemaCurso();
            lstCursos = new ArrayList<RrhhTemaCurso>();
            lstCursos = psCat.getListTemaCurso();
        }
            
            createHorizontalBarModel();
            
            
        return lstCursos;
    }

    public void setLstCursos(List<RrhhTemaCurso> lstCursos) {
        this.lstCursos = lstCursos;
    }

   

    public RrhhTemaCurso getCurso() {
        return Curso;
    }

    public void setCurso(RrhhTemaCurso Curso) {
        this.Curso = Curso;
    }
    
public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }

    public void setHorizontalBarModel(HorizontalBarChartModel horizontalBarModel) {
        this.horizontalBarModel = horizontalBarModel;
    }

    public RrhhTemaCurso getCursoAux() {
        return CursoAux;
    }

    public void setCursoAux(RrhhTemaCurso CursoAux) {
        this.CursoAux = CursoAux;
    }


}
