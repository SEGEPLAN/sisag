package gt.gob.segeplan.sisag.core.web.controller;
/**
 *
 * @author layala
 */

import gt.gob.segeplan.sisag.rrhh.entities.DtiDispositivo;
import gt.gob.segeplan.sisag.rrhh.entities.DtiGabinete;
import gt.gob.segeplan.sisag.rrhh.entities.DtiIpServer;
import gt.gob.segeplan.sisag.rrhh.entities.DtiServidor;
import gt.gob.segeplan.sisag.rrhh.entities.DtiSistemaOperativo;
import gt.gob.segeplan.sisag.rrhh.entities.DtiTipoDispositivo;
import gt.gob.segeplan.sisag.rrhh.entities.DtiTipoServer;
import java.util.List;

public interface servidoresController {
 
    // consultas 
   public DtiGabinete findGabinete(int band);
   public List<DtiGabinete> getListGabinete(String tipo, int band);
   public List<DtiDispositivo> getListDispositivo(String tipo, int band);
   public DtiGabinete find(Long id);
  
    // ABC Gabinetes
   public DtiGabinete crearGabinete(DtiGabinete objeto); // registrar 
    public DtiGabinete editarGabinete(DtiGabinete objeto); // editar existente
    public String borrarGabinete(DtiGabinete objeto); // borrar existente
    
    // ABC Dispositivo
   public DtiDispositivo crearDispositivo(DtiDispositivo objeto); // registrar 
    public DtiDispositivo editarDispositivo(DtiDispositivo objeto); // editar existente
    public String borrarDispositivo(DtiDispositivo objeto); // borrar existente
    
     // ABC DtiIpServer
   public DtiIpServer crearIpServer(DtiIpServer objeto); // registrar 
    public DtiIpServer editarIpServer(DtiIpServer objeto); // editar existente
    public String borrarIpServer(DtiIpServer objeto); // borrar existente
    
     // ABC DtiServidor
   public DtiServidor crearServidor(DtiServidor objeto); // registrar 
    public DtiServidor editarServidor(DtiServidor objeto); // editar existente
    public String borrarServidor(DtiServidor objeto); // borrar existente
    
    // ABC SistemaOpera
   public DtiSistemaOperativo crearSistOpe(DtiSistemaOperativo objeto); // registrar 
    public DtiSistemaOperativo editarSistOpe(DtiSistemaOperativo objeto); // editar existente
    public String borrarSistOpe(DtiSistemaOperativo objeto); // borrar existente
    
    // ABC Tipo Dispositivo
   public DtiTipoDispositivo crearTipoDispositivo(DtiTipoDispositivo objeto); // registrar 
    public DtiTipoDispositivo editarTipoDispositivo(DtiTipoDispositivo objeto); // editar existente
    public String borrarTipoDispositivo(DtiTipoDispositivo objeto); // borrar existente
    
    // ABC Tipo DtiTipoServer
   public DtiTipoServer crearTipoServer(DtiTipoServer objeto); // registrar 
    public DtiTipoServer editarTipoServer(DtiTipoServer objeto); // editar existente
    public String borrarTipoServer(DtiTipoServer objeto); // borrar existente
}
