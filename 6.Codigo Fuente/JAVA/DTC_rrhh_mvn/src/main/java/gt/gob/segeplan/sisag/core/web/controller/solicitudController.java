package gt.gob.segeplan.sisag.core.web.controller;
/**
 *
 * @author layala
 */

import gt.gob.segeplan.sisag.rrhh.entities.GenDominios;

import gt.gob.segeplan.sisag.rrhh.entities.RrhhNecesidad;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhNecesidadPuesto;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhSolicitudCapacitacion;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhTemaCurso;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhTipoPuesto;
import java.util.List;

public interface solicitudController {
 
    // consultas 
 
    public RrhhSolicitudCapacitacion findSolicitudDTC(int band); // buscar 
    public List<RrhhSolicitudCapacitacion> getLstSolicitudDTC(); // traer listado total
    public List<RrhhSolicitudCapacitacion> getLstSolicitudDTC_by(int band, int tipo);
    public List<RrhhSolicitudCapacitacion> getListSolicitudDTC_byUsr(int band, int usr);
    public List<RrhhTipoPuesto> getLstTipoPuesto_by(int band); // tipo de puesto de la unidad del usuario
    public List<RrhhTipoPuesto> getLstTipoPuesto();
            
    public List<GenDominios> getLstCatalogo(int id);
     public List<RrhhTemaCurso> getLstCursosDNC();
     public List<RrhhNecesidadPuesto> getLstNecCurso();
     public List<RrhhNecesidadPuesto> getLstNecCursoDist();
    public List<RrhhSolicitudCapacitacion> getLstAllSolicitudesCapa();
     
    // ABC Solicitudes
    public RrhhSolicitudCapacitacion crearSolicitudDTC(RrhhSolicitudCapacitacion objeto); // registrar 
    public RrhhSolicitudCapacitacion editarSolicitudDTC(RrhhSolicitudCapacitacion objeto); // editar existente
    public String borrarSolicitudDTC(RrhhSolicitudCapacitacion objeto); // borrar existente

    // ABC NECESIDAD
    
    public RrhhNecesidad crearNecSol(RrhhNecesidad objeto);
     public RrhhNecesidad editarNecSol(RrhhNecesidad objeto);
     public String borrarNecSol(RrhhNecesidad objeto);
     public String borrarNecPuesto(RrhhNecesidadPuesto objeto);
}
