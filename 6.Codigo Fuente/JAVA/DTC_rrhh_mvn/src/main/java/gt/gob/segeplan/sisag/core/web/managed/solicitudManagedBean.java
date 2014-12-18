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
import gt.gob.segeplan.sisag.rrhh.entities.RrhhNecesidadPuestoPK;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhSolicitudCapacitacion;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhTemaCurso;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhTipoPuesto;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhUnidadAdministrativa;
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
    private List<RrhhSolicitudCapacitacion> LstSolicitudesCapa;
    private List<RrhhNecesidadPuesto> necPuesto;
    private List<RrhhNecesidad> ListNecesidades;
    
    

    //CATALOGOS
     private List<GenDominios> lstEstado;

     private List<GenDominios> catCaracter;
     private List<GenDominios> catNivelCono;
     private List<GenDominios> catPrioridad;
     private List<GenDominios> catDisponibilidad;
     
     private List<RrhhTemaCurso> catCursos;

     private List<RrhhNecesidadPuesto> lstNecPuesto;
     private List<RrhhNecesidadPuesto> lstNecPuestoAux;
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
    private RrhhUnidadAdministrativa unidad;
    private int totalUnidad;


    // band
    private int idCaracter;
    private int idNivelConocimiento;
    private int idPrioridad;
    private int idDisponibilidad;
    private int idTemaCurso;
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
        
        unidad = usuario.getIdPersona().getIdUnidad();
        

    }

    // METODOS
    
    
     public void navegar(String url) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        seguridadManagedBean nmb = (seguridadManagedBean) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "seguridad");
        nmb.navegar(url);

    }

     
     public void llenarCombos(){
         FacesMessage msg = null;
         if(necesidadCapa!=null){
             refreshUsr();
            getCatCursos();
             
             lstNecPuesto = new ArrayList<RrhhNecesidadPuesto>();
        idCaracter = necesidadCapa.getIdCaracter().getId().intValue();
        idPrioridad = necesidadCapa.getIdPrioridad().getId().intValue();
        idNivelConocimiento = necesidadCapa.getIdNivelConocimiento().getId().intValue();
        idDisponibilidad = necesidadCapa.getIdDisponibilidad().getId().intValue();
        
        catCursos.add(necesidadCapa.getIdTema());
        
        idTemaCurso = necesidadCapa.getIdTema().getIdTema().intValue();
        temaPrincipal = necesidadCapa.getIdTema().getNombre();
        totalHoras = necesidadCapa.getTotalHoras().intValue();
        problemaNecesidad = necesidadCapa.getProblemaNecesidad();
        lstNecPuesto = necesidadCapa.getRrhhNecesidadPuestoList();
        lstTipoPuesto = new ArrayList<RrhhTipoPuesto>();
        
            for(RrhhNecesidadPuesto n: lstNecPuesto){
                RrhhTipoPuesto tp = new RrhhTipoPuesto();
                tp = n.getRrhhTipoPuesto();
                 tp.setTotal(n.getTotal());
                 lstTipoPuesto.add(tp);
        }        

            
            
            
          } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No ha seleccionado ninguna fila", null);
             FacesContext.getCurrentInstance().addMessage(null, msg);
         }
    }

     public void borrarCombos(){
        newNecDTC();
        idCaracter = 0;
        idPrioridad = 0;
        idNivelConocimiento = 0;
        idDisponibilidad = 0;
        idTemaCurso = 0;
        temaPrincipal = "";
        totalHoras = 0;
        problemaNecesidad = "";
        lstNecPuesto = new ArrayList<RrhhNecesidadPuesto>();
        lstTipoPuesto = new ArrayList<RrhhTipoPuesto>();
        lstTipoPuesto = psSol.getLstTipoPuesto();
        necesidadCapa = new RrhhNecesidad();
        refreshUsr();
            getCatCursos();
    }

    public void onRowSelect(SelectEvent event) {
        necesidadCapa = new RrhhNecesidad();
        necesidadCapa = (RrhhNecesidad)event.getObject();
    }
     
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
        
         for (RrhhTemaCurso t : catCursos) {
            if(idTemaCurso == t.getIdTema().intValue()){
                necesidadCapa.setIdTema(t);
            }
        }
         
         psSol.crearNecSol(necesidadCapa);
         
          if(lstTipoPuesto!=null){
            lstNecPuesto = new ArrayList<RrhhNecesidadPuesto>();
                RrhhNecesidadPuesto necPuesto;
                RrhhNecesidadPuestoPK necPuestoPK;
                for (RrhhTipoPuesto tp : lstTipoPuesto) {
                     necPuesto = new RrhhNecesidadPuesto();
                     necPuestoPK = new RrhhNecesidadPuestoPK();
                     
                     necPuestoPK.setIdNecesidad(necesidadCapa.getIdNecesidad().toBigInteger());
                     necPuestoPK.setIdTipoPuesto(tp.getIdTipoPuesto().toBigInteger());
                     
                     necPuesto.setRrhhTipoPuesto(tp);
                     if(tp.getTotal()==0){
                         necPuesto.setTotal(0);
                     }else{
                         necPuesto.setTotal(tp.getTotal());
                     }
                     necPuesto.setRrhhNecesidadPuestoPK(necPuestoPK);
                     necPuesto.setRestrictiva(Character.MIN_VALUE);
                     lstNecPuesto.add(necPuesto);
                     
                     
                        }
                    }
        
        necesidadCapa.setRrhhNecesidadPuestoList(lstNecPuesto);
        psSol.editarNecSol(necesidadCapa);
        ListNecesidades.add(necesidadCapa);
       newNecDTC();
       refreshUsr();
       getCatCursos();
        
}
    
    
    
    
    public void editarNecDTC(){
        
            getLstEstado();
            necesidadCapa.setIdEstado(editado);
            necesidadCapa.setFechaModifica(new Date());
            necesidadCapa.setUsrModifica(usuario.getIdUsuario().toBigInteger());

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
        
        for (RrhhTemaCurso t : catCursos) {
            if(idTemaCurso == t.getIdTema().intValue()){
                necesidadCapa.setIdTema(t);
            }
        }
        
        
        
        if(lstTipoPuesto!=null){
            lstNecPuesto = new ArrayList<RrhhNecesidadPuesto>();
                RrhhNecesidadPuesto necPuesto;
                RrhhNecesidadPuestoPK necPuestoPK;
                for (RrhhTipoPuesto tp : lstTipoPuesto) {
                     necPuesto = new RrhhNecesidadPuesto();
                     necPuestoPK = new RrhhNecesidadPuestoPK();
                     
                     necPuestoPK.setIdNecesidad(necesidadCapa.getIdNecesidad().toBigInteger());
                     necPuestoPK.setIdTipoPuesto(tp.getIdTipoPuesto().toBigInteger());
                                          
                     necPuesto.setRrhhTipoPuesto(tp);
                     
                     if(tp.getTotal()==0){
                         necPuesto.setTotal(0);
                     }else{
                         necPuesto.setTotal(tp.getTotal());
                     }
                     necPuesto.setRrhhNecesidadPuestoPK(necPuestoPK);
                     necPuesto.setRestrictiva(Character.MIN_VALUE);
                     lstNecPuesto.add(necPuesto);
                        }
                    }
        
        necesidadCapa.setRrhhNecesidadPuestoList(lstNecPuesto);
        
        psSol.editarNecSol(necesidadCapa);
        ListNecesidades = new ArrayList<RrhhNecesidad>();
        refreshUsr();
        ListNecesidades = usuario.getRrhhSolicitudCapacitacionList().get(0).getRrhhNecesidadList();
        newNecDTC();
        
        getCatCursos();
        
}


    
    public void eliminarNecesidad() {
        String band ="";
        String objeto;
         FacesMessage msg = null;
        if(necesidadCapa!=null){
            
            objeto = necesidadCapa.getIdTema().getNombre();
            ListNecesidades.remove(necesidadCapa);
            band = psSol.borrarNecSol(necesidadCapa);
            refreshUsr();
            getCatCursos();
            if(band.contentEquals("NO")){
                ListNecesidades.add(necesidadCapa);
            }
             newNecDTC();
             msg = new FacesMessage(FacesMessage.SEVERITY_INFO,band+" Se pudo borrar la necesidad ", objeto);
        } else {
            band = "No ha seleccionado ninguna fila";
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, band, null);
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
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
    
    public List<RrhhTipoPuesto> getLstTipoPuesto() {
         if(lstTipoPuesto == null){
            lstTipoPuesto = new ArrayList<RrhhTipoPuesto>();
             lstTipoPuesto = psSol.getLstTipoPuesto();
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

    public List<RrhhTemaCurso> getCatCursos() {
         if(catCursos == null){
            catCursos = new ArrayList<RrhhTemaCurso>();
         }
            catCursos = psSol.getLstCursosDNC();
            if(!usuario.getRrhhSolicitudCapacitacionList().isEmpty()){
            for(RrhhNecesidad n : usuario.getRrhhSolicitudCapacitacionList().get(0).getRrhhNecesidadList()){
                catCursos.remove(n.getIdTema());
                }
            }
        return catCursos;
    }

    public void setCatCursos(List<RrhhTemaCurso> catCursos) {
        this.catCursos = catCursos;
    }

    public int getIdTemaCurso() {
        return idTemaCurso;
    }

    public void setIdTemaCurso(int idTemaCurso) {
        this.idTemaCurso = idTemaCurso;
    }

    public List<RrhhNecesidadPuesto> getNecPuesto() {
         if(necPuesto == null){
            necPuesto = new ArrayList<RrhhNecesidadPuesto>();
         }
            necPuesto = psSol.getLstNecCursoDist();
            
        return necPuesto;
    }

    public int getAllWins() {
        int sum = 0;
         
        for(RrhhNecesidadPuesto s : necPuesto) {
            sum += s.getTotal();
        }
         
        return sum;
    }
    
    
    public void setNecPuesto(List<RrhhNecesidadPuesto> necPuesto) {
        this.necPuesto = necPuesto;
    }

    public List<RrhhSolicitudCapacitacion> getLstSolicitudesCapa() {
        if(LstSolicitudesCapa == null)
            LstSolicitudesCapa = new ArrayList<RrhhSolicitudCapacitacion>();
        LstSolicitudesCapa = psSol.getLstAllSolicitudesCapa();
        
        return LstSolicitudesCapa;
    }

    public void setLstSolicitudesCapa(List<RrhhSolicitudCapacitacion> LstSolicitudesCapa) {
        this.LstSolicitudesCapa = LstSolicitudesCapa;
    }

    
    
}
