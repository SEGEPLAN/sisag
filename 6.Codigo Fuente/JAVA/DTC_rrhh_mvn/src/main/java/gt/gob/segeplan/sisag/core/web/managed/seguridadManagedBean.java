/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.web.managed;

import gt.gob.segeplan.sisag.core.web.implement.seguridadImplement;
import gt.gob.segeplan.sisag.core.web.utils.aplicationBean;
import gt.gob.segeplan.sisag.core.web.utils.encriptarAES256;
import gt.gob.segeplan.sisag.core.web.utils.themeCustomer;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhPersona;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhUnidadAdministrativa;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhUnidadPersona;
import gt.gob.segeplan.sisag.rrhh.entities.SegModulo;
import gt.gob.segeplan.sisag.rrhh.entities.SegPagina;
import gt.gob.segeplan.sisag.rrhh.entities.SegPaginaAsignada;
import gt.gob.segeplan.sisag.rrhh.entities.SegRol;
import gt.gob.segeplan.sisag.rrhh.entities.SegRolUsuario;
import gt.gob.segeplan.sisag.rrhh.entities.SegRolUsuarioPK;
import gt.gob.segeplan.sisag.rrhh.entities.SegUsuario;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.model.menu.Submenu;

/**
 * @author layala
 */
public class seguridadManagedBean implements Serializable {

    private String value;

    private int cont;
    private int prueba_login;

    private seguridadImplement psUsr;

    private SegUsuario usuario;
    private SegUsuario usuario_logeado;

    private String findString;
    private String NIP;

    //  banderas
    private boolean logeado = false;
    private boolean ensesion = false;
    private boolean activo;
    private boolean nuevoIngreso = false;
    private boolean render;
    private boolean existe;
    //  filtros
    
    private int filterSelecModulo;

    int num_mod = 0;
    private String url = null;
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
    private RrhhUnidadAdministrativa unidad;

    // seguridad
    encriptarAES256 pwd = new encriptarAES256();

    private String mail;
    private BigDecimal usr;

    // filtros


    private HashSet<SegPagina> funciones_Usr = new HashSet<SegPagina>();
    private List<SegPagina> funcion_usr;
    private List<SegRol> roles_usr;
    private List<SegModulo> modulo_usr;

//    private List<SegPagina> principal;

    // roles y accesos
    private List<RrhhUnidadPersona> lstPersonas;
    private List<RrhhPersona> lstPersonasAsig;

    private List<SegUsuario> lstUsrActivos;

    private List<RrhhUnidadPersona> selectedPersonas;
    private SegRol rolGestNC;
    
    
    
    // ADMIN ROLES
    private List<SegRol> lstRoles;
    private int filteRol;
    
    private DualListModel<SegUsuario> usuariosRol;
    private List<SegUsuario> lstUsrRol;
     private List<SegUsuario> usrRolSource = new ArrayList<SegUsuario>();
       private  List<SegUsuario> usrRolTarget = new ArrayList<SegUsuario>();
    private SegRol rolSelected;
    

    public seguridadManagedBean() {

        psUsr = seguridadImplement.getInstance();
        usuario = new SegUsuario();

        // captura del context path y URL
        HttpServletRequest ct = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        cp = ct.getContextPath() + ct.getServletPath();

        if (rolGestNC == null) {
            rolGestNC = psUsr.findRol(2);
        }
        if (lstPersonasAsig == null) {
            lstPersonasAsig = psUsr.getLstPersonasAsig();
        }

    }

    public void relogin() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(cp + "/login.xhtml");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(seguridadManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void navegar(String url) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        NavegacionManagedBean nmb = (NavegacionManagedBean) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "navegacion");
        nmb.navegar(url);

    }

    public void irReiniciarPwd() throws IOException {
        usuario_logeado = new SegUsuario();
        render = false;
        FacesContext.getCurrentInstance().getExternalContext().redirect(cp + "/resetPwd.xhtml");
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
   

    public String login() {

        FacesMessage msg = null;
        logeado = false;
        boolean bloqueado = false;
        boolean Activo = true;
        boolean existe = false;
        nuevoIngreso = false;

        SegUsuario u = new SegUsuario();

        u = psUsr.findByUsuario(usuario.getNombre().trim());
//         1. VALIDA QUE EXISTA EL USUARIO EN LA DB
        if (u.getIdUsuario() != null) {
            existe = true;

            //  2. VALIDAD EL ESTADO SI ESTA BLOQUEADO NO PUEDE INGRESAR
            if (u.getEstado() == 0) {
                bloqueado = false;
            } else {
                bloqueado = true;

                //   3. VALIDA QUE LA CONTRASEÑA SEA VALIDA
                if (usuario.getPwd() != null
                        && usuario.getPwd().trim().equals(u.getPwd())) {

                    //    envia usuario a Session Bean Y APLICATION BEAN
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    aplicationBean appBean = (aplicationBean) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "aplicationBean");

                    logeado = true;
                    usuario_logeado = u;

                    //  4. VERIFICA SI ES PRIMERA VEZ QUE TRATA DE INGRESAR DESDE QUE SE CREO SU CUENTA
//                        if (u.getSegSesionList().isEmpty()) {
//                            nuevoIngreso = true;
//                            usuario_logeado.setPwd("");
//                        }
                    int band = datos.getString("multiSesion").equals("N") ? 0 : 1;
                    ensesion = appBean.addSegUsuario(u, band);
                   
                    
                    //   5. SE SUBEN VARIABLES DE SESION DE USUARIO.
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", u);
                    usr = u.getIdUsuario();
                    if (u.getDependencia() != null) {
                        unidad = u.getDependencia();
                    }

                    
                    //    6. SE TRAEN LOS ROLES Y PRIVILEGIOS DEL USUARIO
                    funciones_usr(u);
                    if (!funciones_Usr.isEmpty()) {
                        creaMenu();
                        url = cp + "/FrontEnd/Inicio.xhtml";

                    } else {
                        themeCustomer tema = (themeCustomer) facesContext.
                                getApplication().getELResolver().
                                getValue(facesContext.getELContext(), null, "cambiadorTemas");
                        tema.initTheme(datos.getString("tema"));

                        //creaMenu();
                        url = cp + "/FrontEnd/noAcces.xhtml";
                    }

                    // SE REINICIA EL NUMERO DE INTENTOS DE LOGIN A 0
                    cont = 0;
                        //   u.setIntentos(0);
                    //u.setRestrictiva("0");
                    // psUsr.editarUsuario(u);

                    try {

                        //    SUBE SESION AL CONTEXTO DE LA APLICACION
                        HttpSession sesion = null;
                        sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                        sesion.setAttribute("usuario", u);

                        solicitudManagedBean solMB = (solicitudManagedBean) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "solicitud");
                        Date fecha = new Date();
                        Calendar c = Calendar.getInstance();
                        solMB.enviarFecha(c.get(Calendar.YEAR));
                    } catch (Exception e) {
                    }
                } else {

                    //  CONTEO DE PRUEBAS DE LOGEO
                    logeado = false;

                    if (cont < prueba_login) {
                        cont = cont + 1;
                        bloqueado = true;
                        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Contraseña incorrecta, Ha intentado " + cont + " veces, de " + prueba_login + " permitidas", "");
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
                if (!bloqueado && !Activo) {
                    msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "No se pudo iniciar sesión",
                            "Credenciales no válidas");
                }
                if (!existe) {
                    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "El nombre de usuario no existe ", "vuelva a intentarlo");
                }

                if (nuevoIngreso) {
                    msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Es la primera vez que inicia sesión",
                            " cambie su contraseña y vuelva a ingresar");
                }

                if (((!bloqueado && Activo)) && existe) {
                    msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Su cuenta esta bloqueada temporalmente",
                            "consulte al Administrador");
                }
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

                if (nuevoIngreso) {

//                        aplicationBean appBean = (aplicationBean) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "aplicationBean");
//                        ensesion = appBean.removeSegUsuario(usuario_logeado);
                    PWD_DECODE = "";
                    FacesContext.getCurrentInstance().getExternalContext().redirect(cp + "/newPwd.xhtml");
                } else {
                    FacesContext.getCurrentInstance().getExternalContext().redirect(url);
                }

            }
        }
    }

    //  CERRAR SESION
    public void logout() {
        //  DESTRUCCION DE LA SESION  
        FacesContext facesContext = FacesContext.getCurrentInstance();
        aplicationBean appBean = (aplicationBean) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "aplicationBean");

        ensesion = appBean.removeSegUsuario(usuario_logeado);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        try {
            //   REDIRECCION A PAGINA DE LOGIN
            FacesContext.getCurrentInstance().getExternalContext().redirect(cp + "/login.xhtml");
        } catch (Exception e) {
        }
        logeado = false;
    }

    public void funciones_usr(SegUsuario u) {
        modulo_usr = new ArrayList<SegModulo>();
        roles_usr = psUsr.getLstRol_By(u.getIdUsuario().intValue(), "byUsuario");
        funcion_usr = psUsr.getLstPagina_By(u.getIdUsuario().intValue(), "byUsuario");
        //modulo_usr = psUsr.getLstModulo_By(u.getIdUsuario().intValue(), "byUsuario");

        if (roles_usr.size() > 0) {
            for (SegRol r : roles_usr) {
                for (SegPaginaAsignada pAsigRol : r.getSegPaginaAsignadaList()) {
                    funciones_Usr.add(pAsigRol.getIdPagina());

                    if (modulo_usr.isEmpty() || !modulo_usr.contains(pAsigRol.getIdPagina().getIdModulo())) {
                        modulo_usr.add(pAsigRol.getIdPagina().getIdModulo());
                    }

                }
            }
        }

        if (funcion_usr.size() > 0) {
            for (SegPagina pAsigUsr : funcion_usr) {
                funciones_Usr.add(pAsigUsr);

                if (modulo_usr.isEmpty() || !modulo_usr.contains(pAsigUsr.getIdModulo())) {
                    modulo_usr.add(pAsigUsr.getIdModulo());
                }
            }
        }

    }

    public int creaMenu() {
        model = new DefaultMenuModel();
        ArrayList<String> lstMenu = new ArrayList<String>();
        ArrayList<String> lstMenuFinal = new ArrayList<String>();
        try {
            Comparator<SegModulo> comparador = new Comparator<SegModulo>() {
                @Override
                public int compare(SegModulo a, SegModulo b) {
                    int resultado = Integer.compare(a.getOrden(), b.getOrden());
                    if (resultado != 0) {
                        return resultado;
                    }
                    return resultado;
                }
            };

            System.out.printf("Antes: %s%n", modulo_usr);
            Collections.sort(modulo_usr, comparador);
            System.out.printf("Despues: %s%n", modulo_usr);

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

//            principal = psUsr.getLstPagina_By(1, "byTipo");
//
//            for (SegPagina s : principal) {
//                lstMenuFinal.add("/faces/" + s.getUrl());
//            }
//            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("LstMenu", lstMenuFinal);
        } catch (Exception obj) {
            System.out.println(obj);
        }

        return 0;
    }

    public void updadeModelMenu() {
        funciones_usr(usuario_logeado);
        creaMenu();
    }

    public ArrayList<String> creaSubMenu(Submenu pSubmenu, SegModulo pMenu, int usr) {
        Set<SegPagina> menus = new HashSet<SegPagina>();
        ArrayList<String> lstMenu = new ArrayList<String>();

        for (SegPagina p : funciones_Usr) {
            if (p.getIdModulo() == pMenu) {
                menus.add(p);
            }
        }
        try {
            Iterator<SegPagina> iterador = menus.iterator();
            while (iterador.hasNext()) {
                SegPagina aux = iterador.next();

                DefaultMenuItem item = new DefaultMenuItem(aux.getNombre());
                item.setValue(aux.getNombre());
                item.setHref("/faces/" + aux.getUrl());
                item.setTarget("contenidos");
                item.setIcon("ui-icon-arrow-1-e");
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

    public void asignarRol() {
        FacesMessage msg = null;

        if (!selectedPersonas.isEmpty()) {
            for (RrhhUnidadPersona p : selectedPersonas) {
                List<SegRolUsuario> lstRUsr = new ArrayList<SegRolUsuario>();

                SegUsuario usrAux = new SegUsuario();
                String clave = "";
                String nombres[] = p.getRrhhPersona().getNombres().split(" ");
                String apellidos[] = p.getRrhhPersona().getApellidos().split(" ");

                for (String nombre : nombres) {
                    clave += nombre.substring(0, 1);
                }

                clave += apellidos[0];

//            if(!apellidos[1].isEmpty())
//                clave+=apellidos[1];
                clave = clave.replaceAll("á", "A");
                clave = clave.replaceAll("Á", "A");
                clave = clave.replaceAll("é", "E");
                clave = clave.replaceAll("É", "E");
                clave = clave.replaceAll("í", "I");
                clave = clave.replaceAll("Í", "I");
                clave = clave.replaceAll("ó", "O");
                clave = clave.replaceAll("Ó", "O");
                clave = clave.replaceAll("ú", "U");
                clave = clave.replaceAll("Ú", "U");
                clave = clave.replaceAll("Ñ", "N");
                clave = clave.replaceAll("ñ", "N");

                usrAux.setNombre(clave);
                String PWD_MD5 = pwd.encriptaEnMD5(clave);
                usrAux.setPwd(PWD_MD5);
                usrAux.setIdPersona(p.getRrhhPersona());
                usrAux.setEmail(p.getRrhhPersona().getCorreoElectronico());
                usrAux.setEstado(1);
                usrAux.setPregunta("Pregunta secreta?");
                usrAux.setRespuesta("12345");
                
                for(RrhhUnidadPersona up : p.getRrhhPersona().getRrhhUnidadPersonaList()){
                    if(up.getRestrictiva().contains("N")){
                        usrAux.setDependencia(up.getRrhhUnidadAdmin());
                    }
                }

                psUsr.crearUsuario(usrAux);

                SegRolUsuario rUsr = new SegRolUsuario();
                SegRolUsuarioPK rUsrPK = new SegRolUsuarioPK();
                rUsr.setSegRol(rolGestNC);
                rUsr.setRestrictiva(1);
                rUsr.setSegUsuario(usrAux);

                rUsrPK.setIdRol(rolGestNC.getIdRol().toBigInteger());
                rUsrPK.setIdUsuario(usrAux.getIdUsuario().toBigInteger());

                rUsr.setSegRolUsuarioPK(rUsrPK);
                lstRUsr.add(rUsr);

                usrAux.setSegRolUsuarioList(lstRUsr);

                psUsr.editarUsuario(usrAux);
                lstPersonasAsig.add(usrAux.getIdPersona());

            }
            navegar("usuariosCreados.xhtml");
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No ha seleccionado ninguna fila", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    
    
    public void selRol(ValueChangeEvent e) {
     int band = 0;
      rolSelected = new SegRol();
     
     if(Integer.parseInt(e.getNewValue().toString()) != 0){
         //band = Integer.parseInt(e.getNewValue().toString());
         for (SegRol r : lstRoles) {
             band = Integer.parseInt(e.getNewValue().toString());
             if(r.getIdRol().intValue() == band){
                 rolSelected = r;
             }
         }
         
     }
     usrRolSource = new ArrayList<SegUsuario>();
     getLstUsrRol();
     usrRolSource = lstUsrRol;
    
     usrRolTarget = psUsr.getLstUsuario_byRol(band);
     
     usrRolSource.removeAll(usrRolTarget);
     
     usuariosRol = new DualListModel<SegUsuario>(usrRolSource, usrRolTarget);
     
     
    }
    
    
     public void transferRol(TransferEvent event) {
          List<SegUsuario> lstUsrTransfer = new ArrayList<SegUsuario>();
         int agregar = 0;
          
          for (Object item : event.getItems()) {
               for (SegUsuario s : usrRolSource) {
                   if(s.getNombre().contentEquals(((SegUsuario) item).getNombre())){
                       agregar = 1;
                       lstUsrTransfer.add(s);
                   }
               }
          }
          
          if(agregar == 1){
                usrRolTarget.addAll(lstUsrTransfer);
                usrRolSource.removeAll(lstUsrTransfer);
                
          }else{
               for (Object item : event.getItems()) {
              for (SegUsuario e : usrRolTarget) {
                   if(e.getNombre().contentEquals(((SegUsuario) item).getNombre())){
                       lstUsrTransfer.add(e);
                 }
                }
             }
                usrRolTarget.removeAll(lstUsrTransfer);
                usrRolSource.addAll(lstUsrTransfer);
                
          }
          
          List<SegRolUsuario> rolUsr = new ArrayList<SegRolUsuario>();
          
          for(SegUsuario u : usrRolTarget){
              SegRolUsuario ru = new SegRolUsuario();
              SegRolUsuarioPK ruPk = new SegRolUsuarioPK();
              
              ruPk.setIdRol(rolSelected.getIdRol().toBigInteger());
              ruPk.setIdUsuario(u.getIdUsuario().toBigInteger());
              
              ru.setSegRol(rolSelected);
              ru.setSegUsuario(u);
              ru.setSegRolUsuarioPK(ruPk);
              
              rolUsr.add(ru);
              
              
          }
          
          rolSelected.setSegRolUsuarioList(rolUsr);
          psUsr.editarRol(rolSelected);
          
          
     }
    
    
    public void nuevoSegUsuario() {
        usuario = new SegUsuario();

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
        if (mail.length() != 0) {
            if (!isValid(mail)) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
                                mail + " no es un e-mail valido"));
            }
        }
    }

    boolean isValid(String email) {

        // Reqular expression pattern to validate the format submitted
        String validator = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,12})$";
        boolean retval = true;
        if (!email.matches(validator)) {
            retval = false;
            return retval;
        }

        String[] parts = email.split("@");

        try {
            return retval;

        } catch (Exception exception) {
            retval = false;
            return retval;
        }
    }

    public RrhhUnidadAdministrativa getUnidad() {
        return unidad;
    }

    public void setUnidad(RrhhUnidadAdministrativa unidad) {
        this.unidad = unidad;
    }

    public List<RrhhUnidadPersona> getLstPersonas() {
        if (lstPersonas == null) {
            lstPersonas = new ArrayList<RrhhUnidadPersona>();
            lstPersonas = psUsr.getLstPersonas();
        }
        if (!lstPersonasAsig.isEmpty()) {
            lstPersonas.removeAll(lstPersonasAsig);
        }

        return lstPersonas;
    }

    public void setLstPersonas(List<RrhhUnidadPersona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }

    public List<RrhhUnidadPersona> getSelectedPersonas() {
        return selectedPersonas;
    }

    public void setSelectedPersonas(List<RrhhUnidadPersona> selectedPersonas) {
        this.selectedPersonas = selectedPersonas;
    }

    public List<SegUsuario> getLstUsrActivos() {
        if (lstUsrActivos == null) {
            lstUsrActivos = new ArrayList<SegUsuario>();
            lstUsrActivos = psUsr.getLstUsuario();
//            for(SegUsuario se :lstUsrActivos){
//                for(RrhhUnidadPersona  re: se.getIdPersona().getRrhhUnidadPersonas()){
//                    if()
//                }
               // se.setUnidad(se.getIdPersona().getRrhhUnidadPersonaList())
//            }
        }
        return lstUsrActivos;
    }

    public void setLstUsrActivos(List<SegUsuario> lstUsrActivos) {
        this.lstUsrActivos = lstUsrActivos;
    }

    public List<SegRol> getLstRoles() {
         if (lstRoles == null) {
            lstRoles = new ArrayList<SegRol>();
            lstRoles = psUsr.getLstRol_By(0, "byAll");
        }
        
        return lstRoles;
    }

    public void setLstRoles(List<SegRol> lstRoles) {
        this.lstRoles = lstRoles;
    }

    public DualListModel<SegUsuario> getUsuariosRol() {
         if (usuariosRol == null) {
            usuariosRol = new DualListModel<SegUsuario>();
        }
        return usuariosRol;
    }

    public void setUsuariosRol(DualListModel<SegUsuario> usuariosRol) {
        this.usuariosRol = usuariosRol;
    }

    public List<SegUsuario> getLstUsrRol() {
        if (lstUsrRol == null) {
            lstUsrRol = new ArrayList<SegUsuario>();
        }
        lstUsrRol = psUsr.getLstUsuario_byRol(0);
        return lstUsrRol;
    }

    public void setLstUsrRol(List<SegUsuario> lstUsrRol) {
        this.lstUsrRol = lstUsrRol;
    }

    public int getFilteRol() {
        return filteRol;
    }

    public void setFilteRol(int filteRol) {
        this.filteRol = filteRol;
    }

    
    
    
    
}
