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
import gt.gob.segeplan.sisag.rrhh.entities.RrhhPersona;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhSolicitudCapacitacion;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhTemaCurso;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhTipoPuesto;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhUnidadAdministrativa;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhUnidadPersona;
import gt.gob.segeplan.sisag.rrhh.entities.SegUsuario;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.UUID;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
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
    
    private List<RrhhNecesidad> LstNecPuesto;
    
    private List<RrhhUnidadAdministrativa> LstSolicitudesValidadas;
    private List<RrhhUnidadAdministrativa> LstUnidadesAdmin;
    
    private List<RrhhNecesidadPuesto> necPuesto;
    private List<RrhhNecesidad> ListNecesidades;
    
    private List<RrhhNecesidadPuesto> lstNecesidadesPuesto;
    
    

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
     private GenDominios enviado;
     private GenDominios editado;

    // objetos
    private RrhhSolicitudCapacitacion solicitudDTC;
    private RrhhSolicitudCapacitacion solicitudDTCcreada;
    private RrhhSolicitudCapacitacion solicitudDTCaux;

    private RrhhNecesidad necesidadCapa;
    private RrhhNecesidad necesidadCapaAux;
    private RrhhUnidadAdministrativa unidad;
    private int totalUnidad;
    private int idTemaCurso;
    private int fecha;
   
     private List<RrhhPersona> lstPersonasByUnidad;
     private String cadena ="";
    


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

        if(usuario.getIdPersona().getRrhhUnidadPersonaList()!=null)
            
        unidad = usuario.getDependencia();
        
        //lstPersonasByUnidad = psSeg.getLstPersonas_byUnidad(unidad);
        //totalUnidad = lstPersonasByUnidad.size();
//       for(RrhhUnidadPersona up: unidad.getRrhhUnidadPersonaList()){
//           if(up.getRestrictiva().contentEquals("N")){
//               totalUnidad++;
//           }
//       }
       
    }

    // METODOS
    
    public void enviarFecha(int fechaRecibida){
        usuario = ((SegUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"));
        fecha = fechaRecibida;
        Calendar c = Calendar.getInstance();
        //refreshUsr();
        getLstEstado();
        if(!usuario.getRrhhSolicitudCapacitacionList().isEmpty()){
            solicitudDTCcreada = devuelveSolicitud(usuario.getRrhhSolicitudCapacitacionList());
            solicitudDTC = solicitudDTCcreada;
        }else{
            solicitudDTC = new RrhhSolicitudCapacitacion();
            solicitudDTC.setFechaCrea(new Date());
            solicitudDTC.setIdEstado(creado);
            solicitudDTC.setUsrCrea(usuario);
            solicitudDTC.setAnio(c.get(Calendar.YEAR));
            solicitudDTC.setRestrictiva(Character.MIN_VALUE);
            solicitudDTCcreada = psSol.crearSolicitudDTC(solicitudDTC);
            //necesidadCapa.setIdSolicitudCapacitacion(solicitudDTCcreada);
        
        }
            getListNecesidades();
            //borrarCombos();
    }
    
    // Devuelve la solicitud del año en curso
    public RrhhSolicitudCapacitacion devuelveSolicitud(List<RrhhSolicitudCapacitacion> listado){
        RrhhSolicitudCapacitacion auxSol = new RrhhSolicitudCapacitacion();
        for(RrhhSolicitudCapacitacion sc : listado){
                if(sc.getAnio() == fecha){
                    auxSol = sc;
                }else{
                    auxSol = new RrhhSolicitudCapacitacion();
                    auxSol.setRrhhNecesidadList(new ArrayList<RrhhNecesidad>());
                }
            }
        return auxSol;
    
    }
            
            
     public void navegar(String url) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        seguridadManagedBean nmb = (seguridadManagedBean) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "seguridad");
        nmb.navegar(url);

    }

     
      public void verSolicitud() {
          FacesMessage msg = null;
          if(solicitudDTCaux.getIdSolicitudCapacitacion()!=null){
           System.out.println("Se selecciono la solicitud--->"+solicitudDTCaux.getUsrCrea().getNombre());
          }
           msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No ha seleccionado ninguna fila", null);
             FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
      
      public int validateNec(){
       
        int band = 0;
        
          if((necesidadCapa.getIdCaracter()==null) ||
                  (necesidadCapa.getIdCaracter().getId().intValue() == 0)){
           cadena+=" Caracter, ";
           band = 1;
          }
           if((necesidadCapa.getIdNivelConocimiento()==null) ||
                  (necesidadCapa.getIdNivelConocimiento().getId().intValue() == 0)){
           cadena+=" Nivel Conocimiento, ";
           band = 1;
          }
            if((necesidadCapa.getIdDisponibilidad()==null) ||
                  (necesidadCapa.getIdDisponibilidad().getId().intValue() == 0)){
           cadena+=" Disponibilidad,";
           band = 1;
          }
             if((necesidadCapa.getIdPrioridad()==null) ||
                  (necesidadCapa.getIdPrioridad().getId().intValue() == 0)){
           cadena+=" Prioridad,";
           band = 1;
          }
              if((necesidadCapa.getIdTema()==null) ||
                  (necesidadCapa.getIdTema().getIdTema().intValue() == 0)){
           cadena+=" Curso,";
          }
               if((necesidadCapa.getProblemaNecesidad()==null) ||
                  (necesidadCapa.getProblemaNecesidad().contains(""))){
           cadena+=" Problematica,";
           band = 1;
          }
           if((necesidadCapa.getTotalHoras()==null) ||
                  (necesidadCapa.getTotalHoras().intValue() == 0)){
           cadena+=" Total Horas,";
           band = 1;
          }
           
           
           
           return band;
        }
      
     public void llenarCombos(){
         FacesMessage msg = null;
         if(necesidadCapa.getIdNecesidad()!=null){
             //refreshUsr();
            getCatCursos();
             
             lstNecPuesto = new ArrayList<RrhhNecesidadPuesto>();

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
//        refreshUsr();
        getCatCursos();
       necesidadCapa = new RrhhNecesidad();
        idTemaCurso = 0;
        lstNecPuesto = new ArrayList<RrhhNecesidadPuesto>();
         lstTipoPuesto = new ArrayList<RrhhTipoPuesto>();
         
         lstTipoPuesto = psSol.getLstTipoPuesto();
        
       
    }

    public void onRowSelect(SelectEvent event) {
        necesidadCapa = new RrhhNecesidad();
        necesidadCapa = (RrhhNecesidad)event.getObject();
        
        lstNecPuesto = new ArrayList<RrhhNecesidadPuesto>();

        lstNecPuesto = necesidadCapa.getRrhhNecesidadPuestoList();
        
        lstTipoPuesto = new ArrayList<RrhhTipoPuesto>();
            for(RrhhNecesidadPuesto n: lstNecPuesto){
                RrhhTipoPuesto tp = new RrhhTipoPuesto();
                tp = n.getRrhhTipoPuesto();
                 tp.setTotal(n.getTotal());
                 lstTipoPuesto.add(tp);
        }     
    }
    
    
    public void onRowSelectSoli(SelectEvent event) {
        solicitudDTCaux = new RrhhSolicitudCapacitacion();
        solicitudDTCaux = (RrhhSolicitudCapacitacion)event.getObject();
    }
     
    public void newNecDTC(){
        necesidadCapa = new RrhhNecesidad();
    }
    
    public void newSoliDTC(){
        solicitudDTCaux = new RrhhSolicitudCapacitacion();
    }

    public void refreshUsr(){
        usuario = psSeg.findUsuario(usuario.getIdUsuario().intValue());
    }
    
    public void guardarNecDTC(){

        Calendar c = Calendar.getInstance();
        
        if(solicitudDTCcreada.getIdSolicitudCapacitacion()==null){
            solicitudDTC.setFechaCrea(new Date());
            solicitudDTC.setIdEstado(creado);
            solicitudDTC.setAnio(c.get(Calendar.YEAR));
            solicitudDTC.setRestrictiva(Character.MIN_VALUE);
            solicitudDTC.setUsrCrea(usuario);
            solicitudDTCcreada = psSol.crearSolicitudDTC(solicitudDTC);
            necesidadCapa.setIdSolicitudCapacitacion(solicitudDTCcreada);
        }
        else {
            necesidadCapa.setIdSolicitudCapacitacion(solicitudDTCcreada);
        }
            getLstEstado();
            necesidadCapa.setIdEstado(creado);
        
            for (RrhhTemaCurso t : catCursos) {
            if(idTemaCurso == t.getIdTema().intValue()){
                necesidadCapa.setIdTema(t);
            }
        }
         if(necesidadCapa.getTotalHoras().intValue()>100)
            necesidadCapa.setTotalHoras(new BigInteger("100"));
            
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
        
        solicitudDTCcreada.setRrhhNecesidadList(ListNecesidades);
        solicitudDTC = solicitudDTCcreada;
        
//        refreshUsr();
//       //getCatCursos();
//      
//       solicitudDTCcreada = devuelveSolicitud(usuario.getRrhhSolicitudCapacitacionList());
//             solicitudDTCcreada.setRrhhNecesidadList(new ArrayList<RrhhNecesidad>());
//       solicitudDTCcreada.setRrhhNecesidadList(ListNecesidades);
//       solicitudDTC = solicitudDTCcreada;
//       
//       
//       solicitudDTCcreada = devuelveSolicitud(usuario.getRrhhSolicitudCapacitacionList());
//            solicitudDTC = solicitudDTCcreada;
//       ListNecesidades = solicitudDTCcreada.getRrhhNecesidadList();
       necesidadCapa = new RrhhNecesidad();
       idTemaCurso = 0;
//        }
}
    
    
    
    
    public void editarNecDTC(){
//        
            //getLstEstado();
            necesidadCapa.setIdEstado(editado);
            necesidadCapa.setFechaModifica(new Date());
            necesidadCapa.setUsrModifica(usuario.getIdUsuario().toBigInteger());
            
            
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
//        if(necesidadCapa.getTotalHoras().intValue()>100)
//            necesidadCapa.setTotalHoras(new BigInteger("100"));
        
        necesidadCapa.setRrhhNecesidadPuestoList(lstNecPuesto);
        
        psSol.editarNecSol(necesidadCapa);
        
        RrhhNecesidad borrarNec = new RrhhNecesidad();
        for (RrhhNecesidad nece : ListNecesidades) {
            if(nece.getIdNecesidad()==necesidadCapa.getIdNecesidad()){
                borrarNec = nece;
                
            }
            
        }
        ListNecesidades.remove(borrarNec);
        ListNecesidades.add(necesidadCapa);
        
//         solicitudDTCcreada = devuelveSolicitud(usuario.getRrhhSolicitudCapacitacionList());
//       
//             solicitudDTCcreada.setRrhhNecesidadList(new ArrayList<RrhhNecesidad>());
       solicitudDTCcreada.setRrhhNecesidadList(ListNecesidades);
       solicitudDTC = solicitudDTCcreada;
       necesidadCapa = new RrhhNecesidad();
        
//        ListNecesidades = new ArrayList<RrhhNecesidad>();
//        refreshUsr();
//        solicitudDTCcreada = devuelveSolicitud(usuario.getRrhhSolicitudCapacitacionList());
//            solicitudDTC = solicitudDTCcreada;
//        
//        ListNecesidades = solicitudDTCcreada.getRrhhNecesidadList();
       // getCatCursos();
//        }
}


    
    public void eliminarNecesidad() {
        String band ="";
        String objeto;
         FacesMessage msg = null;
        if(necesidadCapa.getIdNecesidad()!=null){
            
            objeto = necesidadCapa.getIdTema().getNombre();
            ListNecesidades.remove(necesidadCapa);
            band = psSol.borrarNecSol(necesidadCapa);
            //refreshUsr();
            //getCatCursos();
            if(band.contentEquals("NO")){
                ListNecesidades.add(necesidadCapa);
            }
            solicitudDTCcreada.setRrhhNecesidadList(ListNecesidades);
             msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Se borro la necesidad "+objeto, null);
             necesidadCapa = new RrhhNecesidad();
        } else {
            band = "No ha seleccionado ninguna fila";
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, band, null);
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
     
    public void validarSolicitud() {
          FacesMessage msg = null;
        solicitudDTCcreada.setIdEstado(validado);
        solicitudDTCcreada.setUsrCrea(usuario);
        solicitudDTCcreada.setFechaCrea(new Date());
        psSol.editarSolicitudDTC(solicitudDTCcreada);
        // refreshUsr();
         msg = new FacesMessage(FacesMessage.SEVERITY_INFO," Se envio la solicitud ", "Exitosamente");
         FacesContext.getCurrentInstance().addMessage(null, msg);
         //solicitudDTCcreada = devuelveSolicitud(usuario.getRrhhSolicitudCapacitacionList());
            solicitudDTC = solicitudDTCcreada;
            
         navegar("RegistrarDNC.xhtml");
    }
    
    
    
    public void downloadPDF(){
    Map hm = new HashMap();

        String fileName = "C:\\repositorio\\sisag_clone\\sisag\\6.Codigo Fuente\\JAVA\\DTC_rrhh_mvn\\src\\main\\webapp\\REPORTES\\report1.jasper";
                UUID uu = new UUID(3, 4);

                String outFileName =  "C:\\TempReport\\" + UUID.randomUUID().toString() + ".pdf";

        try {
           
            
            JasperPrint print = JasperFillManager.fillReport(
                            fileName,
                            hm,
                            new JREmptyDataSource());
                    JRExporter exporter =
                    new net.sf.jasperreports.engine.export.JRPdfExporter();
                    exporter.setParameter(
                    JRExporterParameter.OUTPUT_FILE_NAME,
                    outFileName);
                    exporter.setParameter(
                    JRExporterParameter.JASPER_PRINT, print);
                    JasperExportManager.exportReportToPdfFile(print, outFileName);
                    print = null;
                    exporter = null;
                    JasperViewer.viewReport(print,false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }
    
    
    // GETTER Y SETTER
    public List<RrhhSolicitudCapacitacion> getSolicitudesDTC() {
        if(solicitudesDTC == null){
            solicitudesDTC = new ArrayList<RrhhSolicitudCapacitacion>();
            getLstEstado();
        }
        solicitudesDTC = psSol.getListSolicitudDTC_byUsr(0, usuario.getIdUsuario().intValue());
        
        return solicitudesDTC;
    }

    public void setSolicitudesDTC(List<RrhhSolicitudCapacitacion> solicitudesDTC) {
        this.solicitudesDTC = solicitudesDTC;
    }

    public RrhhSolicitudCapacitacion getSolicitudDTC() {
        solicitudDTC.setUsrCrea(usuario);
        solicitudDTC = devuelveSolicitud(usuario.getRrhhSolicitudCapacitacionList());
        if(solicitudDTC.getIdSolicitudCapacitacion()==null){
            solicitudDTC.setUsrCrea(usuario);
            solicitudDTC.setIdEstado(creado);
            
        }
        
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
    
    public List<RrhhTipoPuesto> getLstTipoPuesto() {
         if(lstTipoPuesto == null){
            lstTipoPuesto = new ArrayList<RrhhTipoPuesto>();
//             lstTipoPuesto = psSol.getLstTipoPuesto();
             }
           
        return lstTipoPuesto;
    }


    public List<GenDominios> getLstEstado() {
        if(lstEstado == null){
            creado = new GenDominios();
            enviado = new GenDominios();
            validado = new GenDominios();
            editado = new GenDominios();
            
            lstEstado = new ArrayList<GenDominios>();
            lstEstado = psSol.getLstCatalogo(17);

            for (GenDominios estado : lstEstado) {
                if(estado.getId().intValue()==18){
                    creado = estado;
                }
                if(estado.getId().intValue()==19){
                    validado = estado;
                }
                if(estado.getId().intValue()==20){
                    enviado = estado;
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
            if(!usuario.getRrhhSolicitudCapacitacionList().isEmpty() &&  !usuario.getRrhhSolicitudCapacitacionList().get(0).getRrhhNecesidadList().isEmpty()){
                ListNecesidades = devuelveSolicitud(usuario.getRrhhSolicitudCapacitacionList()).getRrhhNecesidadList();
            }
         
         }
//            if(!usuario.getRrhhSolicitudCapacitacionList().isEmpty() &&  !usuario.getRrhhSolicitudCapacitacionList().get(0).getRrhhNecesidadList().isEmpty()){
//                ListNecesidades = devuelveSolicitud(usuario.getRrhhSolicitudCapacitacionList()).getRrhhNecesidadList();
//            }
        return ListNecesidades;
    }

    public void setListNecesidades(List<RrhhNecesidad> ListNecesidades) {
        this.ListNecesidades = ListNecesidades;
    }

   

    
    public List<RrhhTemaCurso> getCatCursos() {
         if(catCursos == null){
            catCursos = new ArrayList<RrhhTemaCurso>();
            catCursos = psSol.getLstCursosDNC();
         }
            if(!usuario.getRrhhSolicitudCapacitacionList().isEmpty()){
            
            for(RrhhNecesidad n : devuelveSolicitud(usuario.getRrhhSolicitudCapacitacionList()).getRrhhNecesidadList()){
                catCursos.remove(n.getIdTema());
                }
            }
            if(necesidadCapa.getIdNecesidad()!=null){
                catCursos.add(necesidadCapa.getIdTema());
            }
        return catCursos;
    }

    public void setCatCursos(List<RrhhTemaCurso> catCursos) {
        this.catCursos = catCursos;
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

    public List<RrhhNecesidad> getLstNecPuesto() {
        if(LstNecPuesto == null){
            LstNecPuesto = new ArrayList<RrhhNecesidad>();
            LstNecPuesto = psSol.getLstNecValid(fecha);
        }
        return LstNecPuesto;
    }

    public void setLstNecPuesto(List<RrhhNecesidad> LstNecPuesto) {
        this.LstNecPuesto = LstNecPuesto;
    }

    
    
    public List<RrhhSolicitudCapacitacion> getLstSolicitudesCapa() {
        if(LstSolicitudesCapa == null){
            LstSolicitudesCapa = new ArrayList<RrhhSolicitudCapacitacion>();
            LstSolicitudesCapa = psSol.getLstAllSolicitudesCapaValid(fecha);
        }
        return LstSolicitudesCapa;
    }

    public void setLstSolicitudesCapa(List<RrhhSolicitudCapacitacion> LstSolicitudesCapa) {
        this.LstSolicitudesCapa = LstSolicitudesCapa;
    }

    public int getTotalUnidad() {
        return totalUnidad;
    }

    public void setTotalUnidad(int totalUnidad) {
        this.totalUnidad = totalUnidad;
    }

    public List<RrhhUnidadAdministrativa> getLstSolicitudesValidadas() {
         List<RrhhSolicitudCapacitacion> LstSolicitudesCapaAux = new ArrayList<RrhhSolicitudCapacitacion>();
         LstSolicitudesCapaAux = psSol.getLstAllSolicitudesCapa(fecha);
          List<RrhhUnidadAdministrativa> LstUnidadFaltantes = new ArrayList<RrhhUnidadAdministrativa>();
         LstSolicitudesValidadas = new ArrayList<RrhhUnidadAdministrativa>();
         getLstUnidadesAdmin();
         
         if(!LstSolicitudesCapaAux.isEmpty()){
        for(RrhhSolicitudCapacitacion sol : LstSolicitudesCapaAux){
            if(sol.getIdEstado().getId().intValue()==19){
                //LstUnidadFaltantes.add(sol.getUsrCrea().getIdPersona().getRrhhUnidadPersonaList().getRrhhUnidadAdmin());
                sol.getUsrCrea().getDependencia().setSolicitudDNC(sol);
                    LstSolicitudesValidadas.add(sol.getUsrCrea().getDependencia());
            }
            }
        
        for(RrhhUnidadAdministrativa u : LstSolicitudesValidadas){
            for(RrhhUnidadAdministrativa un : LstUnidadesAdmin){
                if(un.getIdUnidadAdmin().intValue() == u.getIdUnidadAdmin().intValue()){
                    LstUnidadFaltantes.add(un);
                }
            }
            LstUnidadesAdmin.removeAll(LstUnidadFaltantes);
            //if(LstUnidadesAdmin.contains(u))
                
           //LstUnidadesAdmin.remove(LstUnidadFaltantes);
        }
         }
         
        return LstSolicitudesValidadas;
    }

    public void setLstSolicitudesValidadas(List<RrhhUnidadAdministrativa> LstSolicitudesValidadas) {
        this.LstSolicitudesValidadas = LstSolicitudesValidadas;
    }

    public List<RrhhUnidadAdministrativa> getLstUnidadesAdmin() {
         if(LstUnidadesAdmin == null){
             LstUnidadesAdmin = new ArrayList<RrhhUnidadAdministrativa>();
         LstUnidadesAdmin = psSol.getLstUsrXUnidadCreadas();
         }
        return LstUnidadesAdmin;
    }

    public void setLstUnidadesAdmin(List<RrhhUnidadAdministrativa> LstUnidadesAdmin) {
        this.LstUnidadesAdmin = LstUnidadesAdmin;
    }

    public List<RrhhNecesidadPuesto> getLstNecesidadesPuesto() {
         if(lstNecesidadesPuesto == null)
            lstNecesidadesPuesto = new ArrayList<RrhhNecesidadPuesto>();
        lstNecesidadesPuesto = psSol.getLstAllNecesidadesPuesto();
        return lstNecesidadesPuesto;
    }

    public void setLstNecesidadesPuesto(List<RrhhNecesidadPuesto> lstNecesidadesPuesto) {
        this.lstNecesidadesPuesto = lstNecesidadesPuesto;
    }

    public int getIdTemaCurso() {
        return idTemaCurso;
    }

    public void setIdTemaCurso(int idTemaCurso) {
        this.idTemaCurso = idTemaCurso;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public List<RrhhPersona> getLstPersonasByUnidad() {
         if(lstPersonasByUnidad == null)
            lstPersonasByUnidad = new ArrayList<RrhhPersona>();
        return lstPersonasByUnidad;
    }

    public void setLstPersonasByUnidad(List<RrhhPersona> lstPersonasByUnidad) {
        this.lstPersonasByUnidad = lstPersonasByUnidad;
    }

    
    
}
