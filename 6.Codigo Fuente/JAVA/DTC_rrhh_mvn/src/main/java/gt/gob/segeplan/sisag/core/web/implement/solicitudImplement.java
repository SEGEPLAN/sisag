 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.web.implement;


import gt.gob.segeplan.sisag.core.web.controller.solicitudController;
import gt.gob.segeplan.sisag.rrhh.entities.GenDominios;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhNecesidad;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhNecesidadPuesto;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhSolicitudCapacitacion;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhTemaCurso;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhTipoPuesto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author layala
 */
public class solicitudImplement implements solicitudController{

    private EntityManagerFactory emf;
    private static solicitudImplement instance = null;

    public static solicitudImplement getInstance() {
        if (instance == null) {
            instance = new solicitudImplement();
        }
        return instance;
    }
    
    public solicitudImplement() {
        
        emf = Persistence.createEntityManagerFactory("sisagPU");
    }

    
     @Override
    public RrhhSolicitudCapacitacion findSolicitudDTC(int band) {
        
        EntityManager em = emf.createEntityManager();
        RrhhSolicitudCapacitacion aux = new RrhhSolicitudCapacitacion();
        try {
           Query q = null;
           q = em.createQuery("SELECT s FROM RrhhSolicitudCapacitacion s WHERE s.idSolicitudCapacitacion=:filtro");
	   q.setParameter("filtro", band);
           aux = (RrhhSolicitudCapacitacion) q.getSingleResult();
        } catch (Exception nre){
			System.out.println("Exception "+nre.toString());
        }finally{
             em.close();
        }
        
    return aux; 
        
    }

   

    @Override
    public List<RrhhSolicitudCapacitacion> getLstSolicitudDTC() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select l from RrhhSolicitudCapacitacion l");
        return q.getResultList();
    }
    
    
    
    
    // CATALOGOS
    
    @Override
    public List<RrhhTemaCurso> getLstCursosDNC() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select l from RrhhTemaCurso l WHERE l.restrictiva<>0");
        return q.getResultList();
    }
    
    @Override
    public List<RrhhNecesidadPuesto> getLstNecCurso() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select l from RrhhNecesidadPuesto l ");
        return q.getResultList();
    }
    
    
    @Override
    public List<RrhhNecesidadPuesto> getLstNecCursoDist() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select l.rrhhNecesidadPuestoList from RrhhNecesidad l ");
        return q.getResultList();
    }
    
    @Override
    public List<GenDominios> getLstCatalogo(int id) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select l from GenDominios l WHERE l.idDominio.id=:filtro");
        q.setParameter("filtro",id );
        return q.getResultList();
    }
    
    

    @Override
    public List<RrhhSolicitudCapacitacion> getLstSolicitudDTC_by(int band, int tipo) {
        EntityManager em = emf.createEntityManager();
        Query q = null;
        if(tipo==1){
                q = em.createQuery("Select l from RrhhSolicitudCapacitacion l where l.dafPersona.nip  =:filtro");
                q.setParameter("filtro",tipo );
        }
        
        return q.getResultList();
    }
    
    
    @Override
    public List<RrhhTipoPuesto> getLstTipoPuesto_by(int band) {
        EntityManager em = emf.createEntityManager();
        Query q = null;
       
                q = em.createQuery("Select l.idPersona.idTipoPuesto.idUnidadAdmin.rrhhTipoPuestoList from SegUsuario l where l.idUsuario=:filtro");
                q.setParameter("filtro",band );
        
        return q.getResultList();
    }
    
    @Override
    public List<RrhhTipoPuesto> getLstTipoPuesto() {
        EntityManager em = emf.createEntityManager();
        Query q = null;
       
                q = em.createQuery("Select l from RrhhTipoPuesto l");
        
        return q.getResultList();
    }

    @Override
    public RrhhNecesidad crearNecSol(RrhhNecesidad objeto) {
        
      EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            objeto = null;
        } finally {
            em.close();
            return objeto;
        }
    }
    
    
    @Override
    public RrhhNecesidad editarNecSol(RrhhNecesidad objeto) {
        
       EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            objeto = null;
        } finally {
            em.close();
            return objeto;
        }
        
    }
    
    
    @Override
    public String borrarNecSol(RrhhNecesidad objeto) {
          String del = objeto.toString();
      EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.remove(em.merge(objeto));
            em.getTransaction().commit();
            del= "SI";
        }catch (Exception e) {
            e.printStackTrace();
            del= "NO";
            objeto = null;
        } finally {
            em.close();
            return del;
        }
    }
    
    @Override
    public String borrarNecPuesto(RrhhNecesidadPuesto objeto) {
          String del = objeto.toString();
      EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.remove(em.merge(objeto));
            em.getTransaction().commit();
            del= "SI";
        }catch (Exception e) {
            e.printStackTrace();
            del= "NO";
            objeto = null;
        } finally {
            em.close();
            return del;
        }
    }
    
    
     @Override
    public RrhhSolicitudCapacitacion crearSolicitudDTC(RrhhSolicitudCapacitacion objeto) {
        
      EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            objeto = null;
        } finally {
            em.close();
            return objeto;
        }
    }
    
    
    
    
    @Override
    public RrhhSolicitudCapacitacion editarSolicitudDTC(RrhhSolicitudCapacitacion objeto) {
        
       EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            objeto = null;
        } finally {
            em.close();
            return objeto;
        }
        
    }

    
    
    
    
    @Override
    public String borrarSolicitudDTC(RrhhSolicitudCapacitacion objeto) {
          String del = objeto.toString();
      EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(em.merge(objeto));
            em.getTransaction().commit();
            del= "SI borro objeto "+del;
        }catch (Exception e) {
            e.printStackTrace();
            del= "NO borro objeto "+del;
            objeto = null;
        } finally {
            em.close();
            return del;
        }
    }

    @Override
    public List<RrhhSolicitudCapacitacion> getListSolicitudDTC_byUsr(int band, int usr) {
        EntityManager em = emf.createEntityManager();
        List<RrhhSolicitudCapacitacion> listado = new ArrayList<RrhhSolicitudCapacitacion>();
        Query q = null;
        if(band!=0){
                q = em.createQuery("Select l from RrhhSolicitudCapacitacion l where l.idSolicitudCapacitacion  =:filtro  AND l.usrCrea.idUsuario= :usr");
                q.setParameter("filtro",band );
                q.setParameter("usr",usr );
                listado = q.getResultList();
        }else{
            q = em.createQuery("Select l from RrhhSolicitudCapacitacion l WHERE l.usrCrea.idUsuario= :usr");
            q.setParameter("usr",usr );
            listado = q.getResultList();
        }
        
        return listado;
    }

   @Override
   public List<RrhhSolicitudCapacitacion> getLstAllSolicitudesCapa() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select l from RrhhSolicitudCapacitacion l ");
        return q.getResultList();
    }
      
   
    @Override
   public List<RrhhNecesidadPuesto> getLstAllNecesidadesPuesto() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select l from RrhhNecesidadPuesto l ");
        return q.getResultList();
    }
   
}
