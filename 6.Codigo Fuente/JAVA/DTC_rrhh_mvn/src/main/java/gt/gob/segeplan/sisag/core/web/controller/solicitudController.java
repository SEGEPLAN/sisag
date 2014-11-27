package gt.gob.segeplan.sisag.core.web.controller;
/**
 *
 * @author layala
 */

import gt.gob.segeplan.sisag.rrhh.entities.RrhhSolicitudCapacitacion;
import java.util.List;

public interface solicitudController {
 
    // consultas 
 
    public RrhhSolicitudCapacitacion findSolicitudDTC(int band); // buscar 
    public List<RrhhSolicitudCapacitacion> getLstSolicitudDTC(); // traer listado total
    public List<RrhhSolicitudCapacitacion> getLstSolicitudDTC_by(int band, int tipo);
    public List<RrhhSolicitudCapacitacion> getListSolicitudDTC_byUsr(int band, int usr);
  
    // ABC Solicitudes
    public RrhhSolicitudCapacitacion crearSolicitudDTC(RrhhSolicitudCapacitacion objeto); // registrar 
    public RrhhSolicitudCapacitacion editarSolicitudDTC(RrhhSolicitudCapacitacion objeto); // editar existente
    public String borrarSolicitudDTC(RrhhSolicitudCapacitacion objeto); // borrar existente

    
}
