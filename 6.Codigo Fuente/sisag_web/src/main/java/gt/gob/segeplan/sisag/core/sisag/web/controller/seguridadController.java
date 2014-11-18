package gt.gob.segeplan.sisag.core.sisag.web.controller;
/**
 *
 * @author layala
 */

import gt.gob.segeplan.sisag.core.seg.SegModulo;
import gt.gob.segeplan.sisag.core.seg.SegPagina;
import gt.gob.segeplan.sisag.core.seg.SegRol;
import gt.gob.segeplan.sisag.core.seg.SegUsuario;
import java.util.List;

public interface seguridadController {
 
    // consultas 
 
    public SegUsuario findUsuario(int band); // buscar Usuario
    public List<SegUsuario> getLstUsuario(); // traer listado total
    public List<SegUsuario> getLstUsuario_by(int band, int tipo);
  
    // ABC Usuario
    public SegUsuario crearUsuario(SegUsuario objeto); // registrar  Usuario
    public SegUsuario editarUsuario(SegUsuario objeto); // editar  Usuario existente
    public String borrarUsuario(SegUsuario objeto); // borrar Usuario existente

    
   // LOGIN
    public SegUsuario login(SegUsuario objeto);
    public SegUsuario findByUsuario(String nombre);
 
    
    
    // ROLES
    public List<SegRol> getLstRol_By(int band, String tipo);
    
    // PAGINA
    public List<SegPagina> getLstPagina_By(int band, String tipo);
    public List<SegPagina> getLstPaginaAsignada(int modulo, int usr);
    
    // MODULO
    public List<SegModulo> getLstModulo_By(int band, String tipo);
}
