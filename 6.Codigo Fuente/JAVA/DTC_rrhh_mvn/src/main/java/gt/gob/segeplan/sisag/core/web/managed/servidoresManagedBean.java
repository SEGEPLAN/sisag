/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */ 
package gt.gob.segeplan.sisag.core.web.managed;

import gt.gob.segeplan.sisag.core.web.implement.servidoresImplement;
import gt.gob.segeplan.sisag.rrhh.entities.DtiDispositivo;
import gt.gob.segeplan.sisag.rrhh.entities.DtiGabinete;
import gt.gob.segeplan.sisag.rrhh.entities.DtiServidor;
import gt.gob.segeplan.sisag.rrhh.entities.SegUsuario;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.mindmap.DefaultMindmapNode;
import org.primefaces.model.mindmap.MindmapNode;

/**
 * @author layala
 */


public  class servidoresManagedBean implements Serializable{

    private servidoresImplement psSer;
    
    ResourceBundle datos = ResourceBundle.getBundle("SISAG");
    private SegUsuario usuario = new SegUsuario();


    // listados
    List<DtiGabinete> lstGabinete;
    List<DtiDispositivo> lstDispositivo;
    
    //OBJETOS
    private DtiGabinete gabineteAux;
    private DtiDispositivo dispositivoAux;
    
    
    
      private MindmapNode root;
     
    private MindmapNode selectedNode;
  

    public servidoresManagedBean() {
        usuario = ((SegUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"));
        psSer = servidoresImplement.getInstance();
        gabineteAux = new DtiGabinete();
        // Asignandoles memoria (instanciandolos objetos)
        
    }
    
    
    // METODOS
    
    public void verDispositivos(){
//         FacesMessage msg = null;
          if(gabineteAux.getDtiDispositivoList().size()>0){
                System.out.println("Se selecciono la solicitud--->"+gabineteAux.getNombre());
                lstDispositivo = gabineteAux.getDtiDispositivoList();
                
          }else{
              lstDispositivo = new ArrayList<DtiDispositivo>();
              //root = new DefaultMindmapNode();
//                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No contiene dispositivos actualmente", null);
//                FacesContext.getCurrentInstance().addMessage(null, msg);
          }
           
    }
    
    
    public void onRowSelect(SelectEvent event) {
        dispositivoAux = new DtiDispositivo();
        dispositivoAux = (DtiDispositivo)event.getObject();
        
       root = new DefaultMindmapNode(dispositivoAux.getIdTipoDispositivo().getDescripcion(), dispositivoAux.getDtiServidorList().size(), "FFCC00", false);
         if(dispositivoAux.getDtiServidorList().size()>0){
              for(DtiServidor d:  dispositivoAux.getDtiServidorList()){
                   MindmapNode servidor  = new DefaultMindmapNode("Servidor"+d.getId(), d.getNombre(), "6e9ebf", true);
                     root.addNode(servidor);
              }
         }  
    }
    
    public void verDiagrama(){
        root = new DefaultMindmapNode(dispositivoAux.getIdTipoDispositivo().getDescripcion(), dispositivoAux.getDtiServidorList().size(), "FFCC00", false);
         if(dispositivoAux.getDtiServidorList().size()>0){
              for(DtiServidor d:  dispositivoAux.getDtiServidorList()){
                   MindmapNode servidor  = new DefaultMindmapNode("Servidor"+d.getId(), d.getNombre(), "6e9ebf", true);
                     root.addNode(servidor);
              }
         }else{
             
         }
       
    }
    
    
    public StreamedContent streamedById(Long id) {
    DefaultStreamedContent image = null;

    System.out.println("[ID imagen]: " + id);

    
    for (DtiGabinete i : lstGabinete) {
        if (i.getId().equals(id)) {
            byte[] foto = i.getImagen();
            if (foto != null) {
                System.out.println("   [Foto]: " + foto);
                image = new DefaultStreamedContent(new ByteArrayInputStream(foto), "image/png");
                break;
            }
        }


    }
    if (image == null) {
        System.out.println("       [Image null]");
        byte[] foto = lstGabinete.get(0).getImagen();
        image = new DefaultStreamedContent(new ByteArrayInputStream(foto), "image/png");
    }

    System.out.println("   [Foto Streamed]: " + image);

    return image;

}
    
    
    public void mapViewCreat(){
        root = new DefaultMindmapNode("SEGEPLAN", "Data Center", "FFCC00", false);
        for(DtiGabinete g:  lstGabinete){
            MindmapNode gabinete  = new DefaultMindmapNode("Gabinete"+g.getId(), g.getNombre(), "6e9ebf", true);
            root.addNode(gabinete);
        }
        
//        root = new DefaultMindmapNode("google.com", "Google WebSite", "FFCC00", false);
//         
//        MindmapNode ips = new DefaultMindmapNode("IPs", "IP Numbers", "6e9ebf", true);
//        MindmapNode ns = new DefaultMindmapNode("NS(s)", "Namespaces", "6e9ebf", true);
//        MindmapNode malware = new DefaultMindmapNode("Malware", "Malicious Software", "6e9ebf", true);
         
//        root.addNode(gabinete);
//        root.addNode(ns);
//        root.addNode(malware);
    }
    
    
    // getter y setter

    public List<DtiGabinete> getLstGabinete() {
        if(lstGabinete == null){
            lstGabinete = new ArrayList<DtiGabinete>();
            lstGabinete = psSer.getListGabinete("todo", 0);
//            StreamedContent content; 
//            List<DtiGabinete> lstAux = new ArrayList<DtiGabinete>();
//            for(DtiGabinete g : lstGabinete){
//                
//                if (g.getImagen() != null) {
//                    InputStream is = new ByteArrayInputStream(g.getImagen());
//                    content = new DefaultStreamedContent(is, "", g.getNombre());
//                    System.out.println("ddd ------------------------------- " + content);
//                    g.setGrafico(content);
//                }
//                lstAux.add(g);
//            }
//            lstGabinete = new ArrayList<DtiGabinete>();
//            lstGabinete = lstAux;
            
            mapViewCreat();
        }
        return lstGabinete;
    }

    public void setLstGabinete(List<DtiGabinete> lstGabinete) {
        this.lstGabinete = lstGabinete;
    }

    public DtiGabinete getGabineteAux() {
        return gabineteAux;
    }

    public void setGabineteAux(DtiGabinete gabineteAux) {
        this.gabineteAux = gabineteAux;
    }
    
    public MindmapNode getRoot() {
        return root;
    }
 
    public MindmapNode getSelectedNode() {
        return selectedNode;
    }
    public void setSelectedNode(MindmapNode selectedNode) {
        this.selectedNode = selectedNode;
    }
 
    public void onNodeSelect(SelectEvent event) {
        MindmapNode node = (MindmapNode) event.getObject();
         
        //populate if not already loaded
        if(node.getChildren().isEmpty()) {
            Object label = node.getLabel();
 
            if(label.equals("NS(s)")) {
                for(int i = 0; i < 25; i++) {
                    node.addNode(new DefaultMindmapNode("ns" + i + ".google.com", "Namespace " + i + " of Google", "82c542", false));
                }
            }
            else if(label.equals("IPs")) {
                for(int i = 0; i < 18; i++) {
                    node.addNode(new DefaultMindmapNode("1.1.1."  + i, "IP Number: 1.1.1." + i, "fce24f", false));
                }
            }
            else if(label.equals("Malware")) {
                for(int i = 0; i < 18; i++) {
                    String random = UUID.randomUUID().toString();
                    node.addNode(new DefaultMindmapNode("Malware-"  + random, "Malicious Software: " + random, "3399ff", false));
                }
            }
        }  
    }
     
    public void onNodeDblselect(SelectEvent event) {
        this.selectedNode = (MindmapNode) event.getObject();       
    }

    public List<DtiDispositivo> getLstDispositivo() {
         if(lstDispositivo == null){
            lstDispositivo = new ArrayList<DtiDispositivo>();
         }
        return lstDispositivo;
    }

    public void setLstDispositivo(List<DtiDispositivo> lstDispositivo) {
        this.lstDispositivo = lstDispositivo;
    }

    public DtiDispositivo getDispositivoAux() {
        return dispositivoAux;
    }

    public void setDispositivoAux(DtiDispositivo dispositivoAux) {
        this.dispositivoAux = dispositivoAux;
    }
    
    
    
}


