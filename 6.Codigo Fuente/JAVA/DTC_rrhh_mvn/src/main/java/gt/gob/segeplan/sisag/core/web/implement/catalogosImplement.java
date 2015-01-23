 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.web.implement;


import gt.gob.segeplan.sisag.core.web.controller.catalogosController;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhTemaCurso;
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
public class catalogosImplement implements catalogosController{

    private EntityManagerFactory emf;
    private static catalogosImplement instance = null;

    public static catalogosImplement getInstance() {
        if (instance == null) {
            instance = new catalogosImplement();
        }
        return instance;
    }
    
    public catalogosImplement() {
        
        emf = Persistence.createEntityManagerFactory("sisagPU");
    }

    
     @Override
    public RrhhTemaCurso findTemaCurso(int band) {
        
        EntityManager em = emf.createEntityManager();
        RrhhTemaCurso aux = new RrhhTemaCurso();
        try {
           Query q = null;
           q = em.createQuery("SELECT s FROM RrhhTemaCurso s WHERE s.idTema=:filtro");
	   q.setParameter("filtro", band);
           aux = (RrhhTemaCurso) q.getSingleResult();
        } catch (Exception nre){
			System.out.println("Exception "+nre.toString());
        }finally{
             em.close();
        }
        
    return aux; 
        
    }

    
    @Override
    public List<RrhhTemaCurso> getListTemaCurso_byUsr(int band, int usr) {
        EntityManager em = emf.createEntityManager();
        List<RrhhTemaCurso> listado = new ArrayList<RrhhTemaCurso>();
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
    public List<RrhhTemaCurso> getListTemaCurso() {
        EntityManager em = emf.createEntityManager();
        List<RrhhTemaCurso> listado = new ArrayList<RrhhTemaCurso>();
        Query q = null;
        
            q = em.createQuery("Select l from RrhhTemaCurso l WHERE l.restrictiva <>0 ORDER BY l.nombre ASC");
        
            listado = q.getResultList();
       
        return listado;
    }
    
    @Override
    public RrhhTemaCurso crearTemaCurso(RrhhTemaCurso objeto) {
        
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
    public RrhhTemaCurso editarTemaCurso(RrhhTemaCurso objeto) {
        
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
    public String borrarTemaCurso(RrhhTemaCurso objeto) {
          String del = objeto.toString();
      EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(em.merge(objeto));
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

           
}
