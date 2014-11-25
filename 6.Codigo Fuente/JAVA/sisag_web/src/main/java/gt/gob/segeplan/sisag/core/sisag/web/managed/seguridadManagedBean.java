/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */ 
package gt.gob.segeplan.sisag.core.sisag.web.managed;

import gt.gob.segeplan.sisag.core.seg.SegModulo;
import gt.gob.segeplan.sisag.core.seg.SegPagina;
import gt.gob.segeplan.sisag.core.seg.SegPaginaAsignada;
import gt.gob.segeplan.sisag.core.seg.SegRol;
import gt.gob.segeplan.sisag.core.seg.SegUsuario;
import gt.gob.segeplan.sisag.core.sisag.web.implement.seguridadImplement;
import gt.gob.segeplan.sisag.core.sisag.web.utils.aplicationBean;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.model.menu.Submenu;




/**
 * @author layala
 */


public  class seguridadManagedBean implements Serializable{

    private String value;  
    
    private int cont;
    private int prueba_login;
    
    private seguridadImplement psUsr;
    
    private SegUsuario usuario;
    private SegUsuario usuario_logeado;
    
    private String findString;
    private String NIP;
   
   //  banderas
    private boolean mostrar;
    private boolean expira = false;
    private boolean logeado = false;
    private boolean ensesion = false;
    private boolean activo;
    private boolean pwdChange;
    private boolean nuevoIngreso = false;
    private boolean render;
    private boolean bandFecExp;
    private boolean Usr_upd;
     private boolean existe;
   //  filtros
    private Integer filter = 0;
    private Integer filterRoles = 0;
    private int filterSelecModulo;
    private int selectedModulo;
     
    int num_mod = 0;
    private String url = null;
    private String expiracion = null;
    private String PWD_DECODE;
    private String PWD_DECODE2;
      
   
    private MenuModel model;
    private String cp;
    
    private String Nombres;
    private String Apellidos;
    private String primerApellido;
    private String Telefono;
   // private String Correo;
    private String Profesion;
    
    
    ResourceBundle datos = ResourceBundle.getBundle("SISAG");
    private String path;
    
    
    // seguridad
    
    
    private int tipoUsuario = 0;
    private String mail;
    private  BigDecimal usr;
    
    
    // filtros
    private Integer selRol = 0;
    private Integer selFuncion = 0;
    private Integer selSede = 0;
    private Integer seleDepto= 0;
    private Integer seleMun= 0;
    private Integer estado = 0;
    
    private String porNombre;
    private String porNip;
    
    private int opcionSearch = 0;
    
    private int FunPadre;
    
    
    
     private HashSet<SegPagina> funciones_Usr = new HashSet<SegPagina>();
     private List<SegPagina> funcion_usr;
     private List<SegRol> roles_usr;
     private List<SegModulo> modulo_usr;
     private List<SegPagina> principal;
    
    
    
    public seguridadManagedBean() {
        
        psUsr = seguridadImplement.getInstance();
        usuario = new SegUsuario();
        
        // captura del context path y URL
        HttpServletRequest ct = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        cp = ct.getContextPath() + ct.getServletPath();
    }
    
    public void relogin(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(cp+"/login.xhtml");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(seguridadManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void navegar(String url) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        NavegacionManagedBean nmb = (NavegacionManagedBean) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "navegacion");
        nmb.navegar(url);

    }
    
    public void irReiniciarPwd() throws IOException{
        usuario_logeado = new SegUsuario();
        render = false;
        FacesContext.getCurrentInstance().getExternalContext().redirect(cp+"/resetPwd.xhtml");
    }
    
    
//    public void recuperarPwd() throws IOException, Exception {
//        FacesMessage msg = null;
//        SegUsuario usrReco = new SegUsuario();
//       usrReco = psUsr.findByUsuario(usuario_logeado.getUsuario());
//        
//       if(usrReco.getRespuesta().contentEquals(usuario_logeado.getRespuesta())){
//            
//                    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "La respuesta es correcta", "Escriba su nueva contraseña");
//                    FacesContext.getCurrentInstance().addMessage(null, msg);
//            
//                   existe = true;
//       }else {
//                    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "La Respuesta no es correcta", "Intente de nuevo o consulte al Administrador del Sistema");
//                    FacesContext.getCurrentInstance().addMessage(null, msg);
//                    existe = false;
//       }
//       
//    }
    
    public void validarUsr(){
        FacesMessage msg = null;
        usuario_logeado = psUsr.findByUsuario(usuario_logeado.getNombre());
        
        if(usuario_logeado.getIdUsuario()!=null){
            render = true;
            usuario_logeado.setRespuesta("");
        }else{
            render = false;
        }
       
    }
    
  
    public String login(){

        FacesMessage msg = null;
        logeado = false;
        boolean bloqueado = false;
        boolean Activo = true;
        boolean existe = false;
        nuevoIngreso = false;

        SegUsuario u = new SegUsuario();
        
        u =  psUsr.findByUsuario(usuario.getNombre());
//         1. VALIDA QUE EXISTA EL USUARIO EN LA DB
        if (u.getIdUsuario() != null) {
            existe = true;

           //  2. VALIDAD EL ESTADO SI ESTA BLOQUEADO NO PUEDE INGRESAR
            if (u.getEstado().toString().equalsIgnoreCase("0") ) {
                    bloqueado = false;
            } else {
                    bloqueado = true;
                    
                  //   3. VALIDA QUE LA CONTRASEÑA SEA VALIDA
                    if (usuario.getPwd()!= null
                            && usuario.getPwd().equals(u.getPwd())) {

                        //    envia usuario a Session Bean Y APLICATION BEAN
                        FacesContext facesContext = FacesContext.getCurrentInstance();
                        aplicationBean appBean = (aplicationBean) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "aplicationBean");

                        logeado = true;
                        usuario_logeado = u;

                       //  4. VERIFICA SI ES PRIMERA VEZ QUE TRATA DE INGRESAR DESDE QUE SE CREO SU CUENTA
                        if (u.getSegSesionList().isEmpty()) {
                            nuevoIngreso = true;
                            usuario_logeado.setPwd("");
                        }
                        int band = datos.getString("multiSesion").equals("N")?0:1;
                            ensesion = appBean.addSegUsuario(u,band);

                      //   5. SE SUBEN VARIABLES DE SESION DE USUARIO.
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", u);
                        usr = u.getIdUsuario(); 
                         
                        //    6. SE TRAEN LOS ROLES Y PRIVILEGIOS DEL USUARIO
                        funciones_usr(u);
                        if (!funciones_Usr.isEmpty()) {
                            //if (funciones_Usr.size() > 1) {
                               creaMenu();
                               url = cp+"/Frontend/Inicio.xhtml";

//                            } 
//                            else {
//                                 for (Iterator it = priv_Usr_log.iterator(); it.hasNext();) {
//                                    SegFuncion objeto = (SegFuncion) it.next();
//                                    if(objeto.getIdTipoFuncion().getIdTipoFuncion()==1)
//                                        url = cp + objeto.getUrl();
//                                }
//                            }
                        } else {
                            creaMenu();
                            url = cp+"/Frontend/noAcces.xhtml";
                        }
                        
                        // SE REINICIA EL NUMERO DE INTENTOS DE LOGIN A 0
                        cont = 0;
                        //   u.setIntentos(0);
                        //u.setRestrictiva("0");
                         psUsr.editarUsuario(u);

                        try {

                         //    SUBE SESION AL CONTEXTO DE LA APLICACION
                            HttpSession sesion = null;
                            sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                            sesion.setAttribute("usuario", u);

                        } catch (Exception e) {
                        }
                    } else {

                    //  CONTEO DE PRUEBAS DE LOGEO
                        logeado = false;

                        if (cont < prueba_login) {
                            cont = cont + 1;
                            bloqueado = true;
                            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Contraseña incorrecta, Ha intentado " + cont + " veces, de "+prueba_login+" permitidas", "");
                        } else {
                            //u.setEstado(0);
                            psUsr.editarUsuario(u);
                            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sobrepaso el numero de intentos", "su SegUsuario estara bloqueado Temporalmente");
                            bloqueado = true;
                        }
                    }
                }
        } else {
            existe = false;
        }

        //  MANEJO DE MENSAJES SI NO SE LOGEO CORRECTAMENTE
        if (!ensesion) {
            if (logeado) {
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", usuario_logeado.getNombre());
            } else {
                if (!bloqueado && !Activo)
                    msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "No se pudo iniciar sesión",
                            "Credenciales no válidas");
                if (!existe)
                    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "El nombre de usuario no existe ", "vuelva a intentarlo");
               
                if (nuevoIngreso)
                    msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Es la primera vez que inicia sesión",
                            " cambie su contraseña y vuelva a ingresar");
                
                if (((!bloqueado && Activo)) && existe) 
                    msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Su cuenta esta bloqueada temporalmente",
                            "consulte al Administrador");
                }
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Su cuenta esta en sesion en otra maquina",
                    "debe cerrar sesion para entrar");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "";
    }

    public void login_user() throws IOException, ParseException {

      //   METODO DE LOGEO
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        // NUMERO DE INTENTOS
        prueba_login = Integer.parseInt(datos.getString("pruebas"));
        
        login();
      //   sesion unica de usuario si bandera viene TRUE
        
        if (!ensesion) {
            if (logeado) {
                try {
                    Thread.sleep(1000);
                    if (nuevoIngreso) {
                       
//                        aplicationBean appBean = (aplicationBean) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "aplicationBean");
//                        ensesion = appBean.removeSegUsuario(usuario_logeado);
                        PWD_DECODE = "";
                        FacesContext.getCurrentInstance().getExternalContext().redirect(cp+"/newPwd.xhtml");
                    } else {
                        FacesContext.getCurrentInstance().getExternalContext().redirect(url);
                    }

                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
    
   //  CERRAR SESION
    public void logout() {
       //  DESTRUCCION DE LA SESION  
        FacesContext facesContext = FacesContext.getCurrentInstance();
        //aplicationBean appBean = (aplicationBean) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "aplicationBean");

       // ensesion = appBean.removeSegUsuario(usuario_logeado);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        try {
          //   REDIRECCION A PAGINA DE LOGIN
            FacesContext.getCurrentInstance().getExternalContext().redirect(cp+"/login.xhtml");
        } catch (Exception e) {
        }
        logeado = false;
    }
   
    
    public void funciones_usr(SegUsuario u){
    
        roles_usr = psUsr.getLstRol_By(u.getIdUsuario().intValue(),"byUsuario");
        funcion_usr = psUsr.getLstPagina_By(u.getIdUsuario().intValue(), "byUsuario");
        modulo_usr = psUsr.getLstModulo_By(u.getIdUsuario().intValue(), "byUsuario");
                      
                      if(roles_usr.size()>0)
                        for (SegRol r : roles_usr) {
                            for(SegPaginaAsignada pAsigRol : r.getSegPaginaAsignadaList()){
                                funciones_Usr.add(pAsigRol.getIdPagina());
                            }
                        }
                      
                      if(funcion_usr.size()>0)
                        for (SegPagina pAsigUsr : funcion_usr) {
                               funciones_Usr.add(pAsigUsr);
                        }
    }
    
    
    public int creaMenu() {
        model = new DefaultMenuModel();
       ArrayList<String> lstMenu = new ArrayList<String>();
       ArrayList<String> lstMenuFinal = new ArrayList<String>();
        try {
            List<SegModulo> lstPadres = modulo_usr;
                
            Iterator<SegModulo> iterador = lstPadres.iterator();
            
                while (iterador.hasNext()) {
                    SegModulo aux = iterador.next();
                    Submenu submenu = new DefaultSubMenu(aux.getNombre());
                    lstMenu = creaSubMenu(submenu, aux, usr.intValue());
                        for (int i = 0; i < lstMenu.size(); i++) {
                            lstMenuFinal.add(lstMenu.get(i));
                        }
                model.addElement(submenu);
                }
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("LstMenu", lstMenuFinal);
                
                principal = psUsr.getLstPagina_By(1, "byTipo");
                
                for (SegPagina s : principal) {
                    lstMenuFinal.add("/faces/"+s.getUrl());
                 }
               FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("LstMenu", lstMenuFinal); 
          } 
        catch (Exception obj) {
               System.out.println(obj);
        }
        
        return 0;
    }
    
    public void updadeModelMenu(){
        funciones_usr(usuario_logeado);
        creaMenu();
    }
    
    
    public ArrayList<String> creaSubMenu(Submenu pSubmenu, SegModulo pMenu, int usr) {
        Set<SegPagina> menus = new HashSet<SegPagina>();
         ArrayList<String> lstMenu = new ArrayList<String>();

         for(SegPagina f : psUsr.getLstPaginaAsignada(pMenu.getIdModulo().intValue(), usr))
                    menus.add(f);
        try {
                Iterator<SegPagina> iterador = menus.iterator();
                while (iterador.hasNext()) {
                SegPagina aux = iterador.next();
//
//                List<SegPagina> subMenus =  psUsr.getLstPaginaAsignada(aux.getIdFuncion(), "misHijos", usr);
//                
//                if (subMenus.iterator().hasNext()) {
//                    Submenu submenu = new DefaultSubMenu(aux.getEtiqueta());
//                    creaSubMenu(submenu, aux, usr);
//                    pSubmenu.getElements().add(submenu);
//                    
//                } else {
                    DefaultMenuItem item = new DefaultMenuItem(aux.getNombre());               
                    item.setValue(aux.getNombre());
                    item.setHref("/faces/"+aux.getUrl());
                    item.setTarget("contenidos");
                    item.setIcon("ui-icon-wrench");
                    pSubmenu.getElements().add(item);
                    funciones_Usr.remove(aux);
                    //
                     lstMenu.add(item.getHref());
                
              }
        } catch (Exception obj) {
            System.out.println(obj);
        }

        return lstMenu;

    }

   
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void nuevoSegUsuario() {
        usuario = new SegUsuario();

    }
    
    
    public void resumenUsr(String paginaNavegar) throws Exception {
            bandFecExp = true;
            expiracion = "SI";
        navegar("resumenUsuario.xhtml");
    }
    
     

   
    
    public int getFilterSelecModulo() {
        return filterSelecModulo;
    }

    public void setFilterSelecModulo(int filterSelecModulo) {
        this.filterSelecModulo = filterSelecModulo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

   

    public String getExpiracion() {
        return expiracion;
    }

    public void setExpiracion(String expiracion) {
        this.expiracion = expiracion;
    }

    public SegUsuario getUsuario_logeado() {
        return usuario_logeado;
    }

    public void setUsuario_logeado(SegUsuario usuario_logeado) {
        this.usuario_logeado = usuario_logeado;
    }

    

    public boolean isRender() {
        return render;
    }

    public void setRender(boolean render) {
        this.render = render;
    }

    
    
    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public String getFindString() {
        return findString;
    }

    public void setFindString(String findString) {
        this.findString = findString;
    }

    public String getPWD_DECODE() {
        return PWD_DECODE;
    }

    public void setPWD_DECODE(String PWD_DECODE) {
        this.PWD_DECODE = PWD_DECODE;
    }

    public boolean isBandFecExp() {
        return bandFecExp;
    }

    public void setBandFecExp(boolean bandFecExp) {
        this.bandFecExp = bandFecExp;
    }

    public boolean isPwdChange() {
        return pwdChange;
    }

    public void setPwdChange(boolean pwdChange) {
        this.pwdChange = pwdChange;
    }

    public String getPWD_DECODE2() {
        return PWD_DECODE2;
    }

    public void setPWD_DECODE2(String PWD_DECODE2) {
        this.PWD_DECODE2 = PWD_DECODE2;
    }

    

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

//    public String getCorreo() {
//        return Correo;
//    }
//
//    public void setCorreo(String Correo) {
//        this.Correo = Correo;
//    }

    public String getProfesion() {
        return Profesion;
    }

    public void setProfesion(String Profesion) {
        this.Profesion = Profesion;
    }

    public SegUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(SegUsuario usuario) {
        this.usuario = usuario;
    }
    
      
    public void onComplete() {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Verificacón de usuario completada", "Verificacón de usuario completada"));  
    }  

   
    public String getValue() {  
        return value;  
    }  
  
    public void setValue(String value) {  
        this.value = value;  
    }  
    
    

    
    public void validateEmail() {
        if(mail.length()!=0)
        if (!isValid(mail)) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
                    mail + " no es un e-mail valido"));
        }
    }
    
    
 
    boolean isValid(String email) {
 
        // Reqular expression pattern to validate the format submitted
            String validator = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,12})$";
            boolean retval=true;
        if (!email.matches(validator)) {
            retval = false;
            return retval;
        }
 
        String[] parts = email.split("@");
 
//        
//        
        try {
//            Hashtable<String, String> env = new Hashtable<String, String>();
//            env.put("java.naming.factory.initial",
//                    "com.sun.jndi.dns.DnsContextFactory");
//            DirContext context = new InitialDirContext(env);
//            Attributes attributes =
//                    context.getAttributes(parts[1], new String[]{"MX"});
//            Attribute attribute = attributes.get("MX");
//            if (attribute== null || attribute.size() == 0) {
//               retval=false;
//            }
//            context.close();
            return retval;
 
        } catch (Exception exception) {
           retval = false;
            return retval;
        }        
    }
    
    
}
