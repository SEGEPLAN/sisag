/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */ 
package gt.gob.segeplan.sisag.core.web.managed;

import gt.gob.segeplan.sisag.core.web.implement.seguridadImplement;
import gt.gob.segeplan.sisag.core.web.implement.solicitudImplement;
import gt.gob.segeplan.sisag.rrhh.entities.GenDominios;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhNecesidad;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhNecesidadPuesto;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhSolicitudCapacitacion;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhTipoPuesto;
import gt.gob.segeplan.sisag.rrhh.entities.SegUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 * @author layala
 */


public  class solicitudManagedBean implements Serializable{

    private solicitudImplement psSol;
    private seguridadImplement psSeg;
    ResourceBundle datos = ResourceBundle.getBundle("SISAG");
    private SegUsuario usuario = new SegUsuario();


    // listados
    private List<RrhhSolicitudCapacitacion> solicitudesDTC;
    private List<RrhhNecesidad> ListNecesidades;
    
    

    //CATALOGOS
     private List<GenDominios> lstEstado;

     private List<GenDominios> catCaracter;
     private List<GenDominios> catNivelCono;
     private List<GenDominios> catPrioridad;
     private List<GenDominios> catDisponibilidad;


     private List<RrhhNecesidadPuesto> lstNecPuesto;
      private List<RrhhTipoPuesto> lstTipoPuesto;


     private GenDominios creado;
     private GenDominios validado;
     private GenDominios editado;

    // objetos
    private RrhhSolicitudCapacitacion solicitudDTC;
    private RrhhSolicitudCapacitacion solicitudDTCcreada;
    private RrhhSolicitudCapacitacion solicitudDTCaux;

    private RrhhNecesidad necesidadCapa;
    private RrhhNecesidad necesidadCapaAux;


    // band
    private int idCaracter;
    private int idNivelConocimiento;
    private int idPrioridad;
    private int idDisponibilidad;
    private int totalHoras;
    private String problemaNecesidad;
    private String temaPrincipal;


    public solicitudManagedBean() {
        usuario = ((SegUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"));
        psSol = solicitudImplement.getInstance();
        psSeg = seguridadImplement.getInstance();

        // Asignandoles memoria (instanciandolos objetos)
        solicitudDTC = new RrhhSolicitudCapacitacion();
        solicitudDTCaux = new RrhhSolicitudCapacitacion();
         solicitudDTCcreada = new RrhhSolicitudCapacitacion();

        necesidadCapa = new RrhhNecesidad();
        necesidadCapaAux = new RrhhNecesidad();

        refreshUsr();
        
        if(!usuario.getRrhhSolicitudCapacitacionList().isEmpty())
            solicitudDTCcreada = usuario.getRrhhSolicitudCapacitacionList().get(0);


    }

    // METODOS

    public void newNecDTC(){
        necesidadCapa = new RrhhNecesidad();
    }

    public void refreshUsr(){
        usuario = psSeg.findUsuario(usuario.getIdUsuario().intValue());
    }
    
    public void guardarNecDTC(){
        
        if(solicitudDTCcreada.getIdSolicitudCapacitacion()==null){
            solicitudDTC.setFechaCrea(new Date());
            solicitudDTC.setRestrictiva(Character.MIN_VALUE);
            solicitudDTCcreada = psSol.crearSolicitudDTC(solicitudDTC);
            necesidadCapa.setIdSolicitudCapacitacion(solicitudDTCcreada);
        }
        else {
            necesidadCapa.setIdSolicitudCapacitacion(solicitudDTCcreada);
        }
            getLstEstado();
            necesidadCapa.setIdEstado(creado);

        for (GenDominios car : catCaracter) {
            if(idCaracter == car.getId().intValue()){
                necesidadCapa.setIdCaracter(car);
            }
        }
        
        for (GenDominios prioridad : catPrioridad) {
            if(idPrioridad == prioridad.getId().intValue()){
                necesidadCapa.setIdPrioridad(prioridad);
            }
        }
        
        for (GenDominios nivel : catNivelCono) {
            if(idNivelConocimiento == nivel.getId().intValue()){
                necesidadCapa.setIdNivelConocimiento(nivel);
            }
        }
        
        for (GenDominios dispo : catDisponibilidad) {
            if(idDisponibilidad == dispo.getId().intValue()){
                necesidadCapa.setIdDisponibilidad(dispo);
            }
        }
//        necesidadCapa.setTotalHoras(totalHoras);
//        necesidadCapa.setTemaPrincipal(temaPrincipal);
//        necesidadCapa.setProblemaNecesidad(problemaNecesidad);
        
        ListNecesidades.add(psSol.crearNecSol(necesidadCapa));
        necesidadCapa = new RrhhNecesidad();
        //necesidadCapaAux = new RrhhNecesidad();
        
}
    
    
    
    
    public void editarNecDTC(){
        
            getLstEstado();
            necesidadCapaAux.setIdEstado(editado);
            necesidadCapaAux.setFechaModifica(new Date());
            necesidadCapaAux.setUsrModifica(usuario.getIdUsuario().toBigInteger());

        for (GenDominios car : catCaracter) {
            if(idCaracter == car.getId().intValue()){
                necesidadCapaAux.setIdCaracter(car);
            }
        }
        
        for (GenDominios prioridad : catPrioridad) {
            if(idPrioridad == prioridad.getId().intValue()){
                necesidadCapaAux.setIdPrioridad(prioridad);
            }
        }
        
        for (GenDominios nivel : catNivelCono) {
            if(idNivelConocimiento == nivel.getId().intValue()){
                necesidadCapaAux.setIdNivelConocimiento(nivel);
            }
        }
        
        for (GenDominios dispo : catDisponibilidad) {
            if(idDisponibilidad == dispo.getId().intValue()){
                necesidadCapaAux.setIdDisponibilidad(dispo);
            }
        }
        
//        necesidadCapaAux.setTotalHoras(totalHoras);
//        necesidadCapaAux.setTemaPrincipal(temaPrincipal);
//        necesidadCapaAux.setProblemaNecesidad(problemaNecesidad);
        
        psSol.editarNecSol(necesidadCapaAux);
        ListNecesidades = new ArrayList<RrhhNecesidad>();
        refreshUsr();
        ListNecesidades = usuario.getRrhhSolicitudCapacitacionList().get(0).getRrhhNecesidadList();
        necesidadCapa = new RrhhNecesidad();
        
}


    
    public void borrarCombos(){
        newNecDTC();
        idCaracter = 0;
        idPrioridad = 0;
        idNivelConocimiento = 0;
        idDisponibilidad = 0;
        
        totalHoras = 4;
        problemaNecesidad = "";
        temaPrincipal = "";
    }

    public void onRowSelect(SelectEvent event) {
        necesidadCapaAux = new RrhhNecesidad();
        necesidadCapaAux = (RrhhNecesidad)event.getObject();
        //llenarCombos();
    }
    
    
     public void llenarCombos(){
        idCaracter = necesidadCapaAux.getIdCaracter().getId().intValue();
        idPrioridad = necesidadCapaAux.getIdPrioridad().getId().intValue();
        idNivelConocimiento = necesidadCapaAux.getIdNivelConocimiento().getId().intValue();
        idDisponibilidad = necesidadCapaAux.getIdDisponibilidad().getId().intValue();
        temaPrincipal = necesidadCapaAux.getTemaPrincipal();
        totalHoras = necesidadCapaAux.getTotalHoras().intValue();
        problemaNecesidad = necesidadCapaAux.getProblemaNecesidad();
    }

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

    public RrhhSolicitudCapacitacion getSolicitudDTC() {
        solicitudDTC.setUsrCrea(usuario);

        return solicitudDTC;
    }

    public void setSolicitudDTC(RrhhSolicitudCapacitacion solicitudDTC) {
        this.solicitudDTC = solicitudDTC;
    }

    public RrhhSolicitudCapacitacion getSolicitudDTCaux() {
        return solicitudDTCaux;
    }

    public void setSolicitudDTCaux(RrhhSolicitudCapacitacion solicitudDTCaux) {
        this.solicitudDTCaux = solicitudDTCaux;
    }

    public RrhhNecesidad getNecesidadCapa() {
        return necesidadCapa;
    }

    public void setNecesidadCapa(RrhhNecesidad necesidadCapa) {
        this.necesidadCapa = necesidadCapa;
    }

    public RrhhNecesidad getNecesidadCapaAux() {
        return necesidadCapaAux;
    }

    public void setNecesidadCapaAux(RrhhNecesidad necesidadCapaAux) {
        this.necesidadCapaAux = necesidadCapaAux;
    }


    public int getIdCaracter() {
        return idCaracter;
    }

    public void setIdCaracter(int idCaracter) {
        this.idCaracter = idCaracter;
    }

    public List<RrhhNecesidadPuesto> getLstNecPuesto() {
         if(lstNecPuesto == null){
            lstNecPuesto = new ArrayList<RrhhNecesidadPuesto>();
            lstTipoPuesto = new ArrayList<RrhhTipoPuesto>();

            lstTipoPuesto = psSol.getLstTipoPuesto_by(usuario.getIdUsuario().intValue());

            if(lstTipoPuesto!=null){
                RrhhNecesidadPuesto necPuesto;

                for (RrhhTipoPuesto tp : lstTipoPuesto) {
                     necPuesto = new RrhhNecesidadPuesto();
                     necPuesto.setRrhhTipoPuesto(tp);
                     necPuesto.setRestrictiva(Character.MIN_VALUE);
                     lstNecPuesto.add(necPuesto);
                        }
                    }
         }
        return lstNecPuesto;
    }

    public void setLstNecPuesto(List<RrhhNecesidadPuesto> lstNecPuesto) {
        this.lstNecPuesto = lstNecPuesto;
    }

    public List<RrhhTipoPuesto> getLstTipoPuesto() {
         if(lstTipoPuesto == null){
            lstTipoPuesto = new ArrayList<RrhhTipoPuesto>();
            lstTipoPuesto = psSol.getLstTipoPuesto_by(usuario.getIdUsuario().intValue());
         }
        return lstTipoPuesto;
    }


    public List<GenDominios> getLstEstado() {
        if(lstEstado == null){
            lstEstado = new ArrayList<GenDominios>();
            lstEstado = psSol.getLstCatalogo(17);

            creado = new GenDominios();
            for (GenDominios estado : lstEstado) {
                if(estado.getId().intValue()==18){
                    creado = estado;
                }
                if(estado.getId().intValue()==21){
                    editado = estado;
                }
            }

        }
        return lstEstado;
    }

    public void setLstEstado(List<GenDominios> lstEstado) {
        this.lstEstado = lstEstado;
    }

    public void setLstTipoPuesto(List<RrhhTipoPuesto> lstTipoPuesto) {
        this.lstTipoPuesto = lstTipoPuesto;
    }


    public int getIdNivelConocimiento() {
        return idNivelConocimiento;
    }

    public void setIdNivelConocimiento(int idNivelConocimiento) {
        this.idNivelConocimiento = idNivelConocimiento;
    }

    public int getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(int idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public int getIdDisponibilidad() {
        return idDisponibilidad;
    }

    
    public void setIdDisponibilidad(int idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public List<GenDominios> getCatCaracter() {
        if(catCaracter == null){
            catCaracter = new ArrayList<GenDominios>();
            catCaracter = psSol.getLstCatalogo(1);
         }
        return catCaracter;
    }

    public void setCatCaracter(List<GenDominios> catCaracter) {
        this.catCaracter = catCaracter;
    }

    public List<GenDominios> getCatNivelCono() {
         if(catNivelCono == null){
            catNivelCono = new ArrayList<GenDominios>();
            catNivelCono = psSol.getLstCatalogo(3);
         }
        return catNivelCono;
    }

    public void setCatNivelCono(List<GenDominios> catNivelCono) {
        this.catNivelCono = catNivelCono;
    }

    public List<GenDominios> getCatPrioridad() {
        if(catPrioridad == null){
            catPrioridad = new ArrayList<GenDominios>();
            catPrioridad = psSol.getLstCatalogo(2);
         }
        return catPrioridad;
    }

    public void setCatPrioridad(List<GenDominios> catPrioridad) {
        this.catPrioridad = catPrioridad;
    }

    public List<GenDominios> getCatDisponibilidad() {
        if(catDisponibilidad == null){
            catDisponibilidad = new ArrayList<GenDominios>();
            catDisponibilidad = psSol.getLstCatalogo(4);
         }
        return catDisponibilidad;
    }

    public void setCatDisponibilidad(List<GenDominios> catDisponibilidad) {
        this.catDisponibilidad = catDisponibilidad;
    }

    public List<RrhhNecesidad> getListNecesidades() {
         if(ListNecesidades == null){
            ListNecesidades = new ArrayList<RrhhNecesidad>();
             }
            if(!usuario.getRrhhSolicitudCapacitacionList().isEmpty() &&  !usuario.getRrhhSolicitudCapacitacionList().get(0).getRrhhNecesidadList().isEmpty()){
                ListNecesidades = usuario.getRrhhSolicitudCapacitacionList().get(0).getRrhhNecesidadList();
            }
        return ListNecesidades;
    }

    public void setListNecesidades(List<RrhhNecesidad> ListNecesidades) {
        this.ListNecesidades = ListNecesidades;
    }

    public int getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(int totalHoras) {
        this.totalHoras = totalHoras;
    }

    public String getProblemaNecesidad() {
        return problemaNecesidad;
    }

    public void setProblemaNecesidad(String problemaNecesidad) {
        this.problemaNecesidad = problemaNecesidad;
    }

    public String getTemaPrincipal() {
        return temaPrincipal;
    }

    public void setTemaPrincipal(String temaPrincipal) {
        this.temaPrincipal = temaPrincipal;
    }



}
