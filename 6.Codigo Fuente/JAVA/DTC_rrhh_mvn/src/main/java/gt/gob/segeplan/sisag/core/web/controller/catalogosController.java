package gt.gob.segeplan.sisag.core.web.controller;
/**
 *
 * @author layala
 */

import gt.gob.segeplan.sisag.rrhh.entities.RrhhTemaCurso;
import java.util.List;

public interface catalogosController {
 
    // consultas 
 
    public RrhhTemaCurso findTemaCurso(int band); // buscar 
    public List<RrhhTemaCurso> getListTemaCurso_byUsr(int band, int usr);
  
    // ABC TemaCurso
    public RrhhTemaCurso crearTemaCurso(RrhhTemaCurso objeto); // registrar 
    public RrhhTemaCurso editarTemaCurso(RrhhTemaCurso objeto); // editar existente
    public String borrarTemaCurso(RrhhTemaCurso objeto); // borrar existente
}
