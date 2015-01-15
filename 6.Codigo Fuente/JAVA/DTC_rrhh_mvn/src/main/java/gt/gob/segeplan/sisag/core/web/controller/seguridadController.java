package gt.gob.segeplan.sisag.core.web.controller;
/**
 *
 * @author layala
 */

import gt.gob.segeplan.sisag.rrhh.entities.RrhhPersona;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhUnidadAdministrativa;
import gt.gob.segeplan.sisag.rrhh.entities.SegModulo;
import gt.gob.segeplan.sisag.rrhh.entities.SegPagina;
import gt.gob.segeplan.sisag.rrhh.entities.SegRol;
import gt.gob.segeplan.sisag.rrhh.entities.SegUsuario;
import java.util.List;

public interface seguridadController {
 
    // consultas 
 
    public SegUsuario findUsuario(int band); // buscar Usuario
    public List<SegUsuario> getLstUsuario(); // traer listado total
    public List<SegUsuario> getLstUsuario_by(int band, int tipo);
    public List<RrhhPersona> getLstPersonas();
    public List<RrhhPersona> getLstPersonasAsig();
   public List<RrhhPersona> getLstPersonas_byUnidad(RrhhUnidadAdministrativa unidad);
  
    // ABC Usuario
    public SegUsuario crearUsuario(SegUsuario objeto); // registrar  Usuario
    public SegUsuario editarUsuario(SegUsuario objeto); // editar  Usuario existente
    public String borrarUsuario(SegUsuario objeto); // borrar Usuario existente

    
   // LOGIN
    public SegUsuario login(SegUsuario objeto);
    public SegUsuario findByUsuario(String nombre);
    public SegRol findRol(int band);
 
    
    
    // ROLES
    public List<SegRol> getLstRol_By(int band, String tipo);
    
    // PAGINA
    public List<SegPagina> getLstPagina_By(int band, String tipo);
    public List<SegPagina> getLstPaginaAsignada(int modulo, int usr);
    
    // MODULO
    public List<SegModulo> getLstModulo_By(int band, String tipo);
//    public int getTotalEmpleados();
}
