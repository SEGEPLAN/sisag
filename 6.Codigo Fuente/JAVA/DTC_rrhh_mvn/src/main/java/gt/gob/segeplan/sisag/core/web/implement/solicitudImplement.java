 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.web.implement;


import gt.gob.segeplan.sisag.core.web.controller.solicitudController;
import gt.gob.segeplan.sisag.rrhh.entities.SegModulo;
import gt.gob.segeplan.sisag.rrhh.entities.SegPagina;
import gt.gob.segeplan.sisag.rrhh.entities.SegRol;
import gt.gob.segeplan.sisag.rrhh.entities.RrhhSolicitudCapacitacion;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

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
    public RrhhSolicitudCapacitacion crearSolicitudDTC(RrhhSolicitudCapacitacion objeto) {
        EntityManager em = emf.createEntityManager();
        try {
            UserTransaction transaction = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
            transaction.begin();
            em.persist(objeto);
            em.joinTransaction();
            em.flush();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            objeto = null;
        } finally {
            //em.close();
            return objeto;
        }
               
    }
    
    
    @Override
    public RrhhSolicitudCapacitacion editarSolicitudDTC(RrhhSolicitudCapacitacion objeto) {
       EntityManager em = emf.createEntityManager();
        
       try {
            UserTransaction transaction = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
            transaction.begin();
            em.merge(objeto);
            em.joinTransaction();
            em.flush();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            objeto = null;
        } finally {
            //em.close();
            return objeto;
        }
        
    }

    
    
    @Override
    public String borrarSolicitudDTC(RrhhSolicitudCapacitacion objeto) {
        String del = objeto.toString();
        EntityManager em = emf.createEntityManager();
        try{    
            em.getTransaction().begin();
            em.remove(em.merge(objeto)); 
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

   
    

   
    
           
}