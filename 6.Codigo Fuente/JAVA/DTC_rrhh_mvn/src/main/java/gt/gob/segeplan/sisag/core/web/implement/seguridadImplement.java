 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.web.implement;


import gt.gob.segeplan.sisag.core.web.controller.seguridadController;
import gt.gob.segeplan.sisag.rrhh.entities.SegModulo;
import gt.gob.segeplan.sisag.rrhh.entities.SegPagina;
import gt.gob.segeplan.sisag.rrhh.entities.SegRol;
import gt.gob.segeplan.sisag.rrhh.entities.SegUsuario;
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
public class seguridadImplement implements seguridadController{

    private EntityManagerFactory emf;
    private static seguridadImplement instance = null;

    public static seguridadImplement getInstance() {
        if (instance == null) {
            instance = new seguridadImplement();
        }
        return instance;
    }
    
    public seguridadImplement() {
        
        emf = Persistence.createEntityManagerFactory("sisagPU");
    }

    
    

    @Override
    public List<SegUsuario> getLstUsuario() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select l from SegUsuario l");
        return q.getResultList();
    }

    @Override
    public List<SegUsuario> getLstUsuario_by(int band, int tipo) {
        EntityManager em = emf.createEntityManager();
        Query q = null;
        if(tipo==1){
                q = em.createQuery("Select l from SegUsuario l where l.dafPersona.nip  =:filtro");
                q.setParameter("filtro",tipo );
        }
        
        return q.getResultList();
    }

    @Override
    public SegUsuario crearUsuario(SegUsuario objeto) {
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
    public SegUsuario editarUsuario(SegUsuario objeto) {
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
    public String borrarUsuario(SegUsuario objeto) {
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

   
    

    ////////////////// login ///////////////////////
    
        
    
    @Override
    public SegUsuario findUsuario(int band) {
    
        SegUsuario model = null; 
        EntityManager em = emf.createEntityManager();
        try{
           Query q = null;
           q = em.createQuery("Select o from SegUsuario o WHERE o.idUsuario  =:filtro");
	       q.setParameter("filtro", band);
           model = (SegUsuario) q.getSingleResult();
            }
                catch (NoResultException nre){
            }
        finally{
            em.close();
        }
    return model; 
        
    }
    
    
    
    
    
@Override
    public SegUsuario login(SegUsuario objeto) {
        SegUsuario model = (SegUsuario) this.findByUsuario(objeto.getNombre()); 
        
        if(model != null) {
            if(!objeto.getPwd().equals(model.getPwd())){
                model = null;
            }
         }
        return model;
    }

    @Override
    public SegUsuario findByUsuario(String cadena) {
          EntityManager em = emf.createEntityManager();
          SegUsuario aux = new SegUsuario();
        try {
           Query q = null;
           q = em.createQuery("SELECT s FROM SegUsuario s WHERE s.nombre=:filtro");
	   q.setParameter("filtro", cadena);
           aux = (SegUsuario) q.getSingleResult();
        } catch (Exception nre){
			System.out.println("Exception "+nre.toString());
        }finally{
             em.close();
        }
        
    return aux; 
    }

   
 

    // roles
    
    @Override
    public List<SegRol> getLstRol_By(int band, String tipo) {
        EntityManager em = emf.createEntityManager();
        Query q = null;
        List<SegRol> aux = new ArrayList<SegRol>();
        
        if(tipo.contentEquals("byRol")){
            q = em.createQuery("Select l from SegRol l where l.idRol=:filtro");
            q.setParameter("filtro", band);
            aux = q.getResultList();
        }
        
        if(tipo.contentEquals("byUsuario")){
            
            q = em.createQuery("Select l.segRol from SegRolUsuario l where l.segUsuario.idUsuario=:filtro");
            q.setParameter("filtro", band);
            aux = q.getResultList();
        }
        
        if(tipo.contentEquals("byPagina")){
            q = em.createQuery("Select l.idRol from SegPaginaAsignada l where l.idPagina.idPagina=:filtro");
            q.setParameter("filtro", band);
            aux = q.getResultList();
        }
        
        if(tipo.contentEquals("byModulo")){
            q = em.createQuery("Select l.idRol from SegPaginaAsignada l where l.idPagina.idModulo.idModulo=:filtro");
            q.setParameter("filtro", band);
            aux = q.getResultList();
        }
        
        if(tipo.contentEquals("byAll")){
            q = em.createQuery("Select l from SegRol l ");
            aux = q.getResultList();
        }
        
        if(tipo.contentEquals("byAllAsign")){
            q = em.createQuery("Select DISTINCT l.segRol from SegRolUsuario l ");
            aux = q.getResultList();
        }
        
        
        return aux;
    }
    
    
    
    
    // PAGINAS
    
    @Override
    public List<SegPagina> getLstPagina_By(int band, String tipo) {
       
        EntityManager em = emf.createEntityManager();
        Query q = null;
        List<SegPagina> aux = new ArrayList<SegPagina>();
        
        if(tipo.contentEquals("byRol")){
            q = em.createQuery("Select l.idPagina from SegPaginaAsignada l where l.idRol.idRol=:filtro");
            q.setParameter("filtro", band);
            aux = q.getResultList();
        }

        if(tipo.contentEquals("byModulo")){
            q = em.createQuery("Select l from SegPagina l where l.idModulo.idModulo=:filtro");
            q.setParameter("filtro", band);
            aux = q.getResultList();
        }
        
         if(tipo.contentEquals("byUsuario")){
            q = em.createQuery("Select l.idPagina from SegPaginaAsignada l where l.idUsuario.idUsuario=:filtro");
            q.setParameter("filtro", band);
            aux = q.getResultList();
        }
         
         if(tipo.contentEquals("byTipo")){
            q = em.createQuery("Select l from SegPagina l where l.idTipoPagina.idTipoPagina=:filtro");
            q.setParameter("filtro", band);
            aux = q.getResultList();
        }
         
         
        return aux;
    }

    
    @Override
    public List<SegPagina> getLstPaginaAsignada(int modulo, int usr) {
       
        EntityManager em = emf.createEntityManager();
        Query q = null;
        List<SegPagina> aux = new ArrayList<SegPagina>();
        
            q = em.createQuery("Select l.idPagina from SegPaginaAsignada l where l.idPagina.idModulo.idModulo=:idModulo AND l.idUsuario.idUsuario =:idUsr  " );
            q.setParameter("idUsr", usr);
            q.setParameter("idModulo", modulo);
            aux = q.getResultList();
        
         
         
        return aux;
    }

    
    
    
    @Override
    public List<SegModulo> getLstModulo_By(int band, String tipo) {
       
        EntityManager em = emf.createEntityManager();
        Query q = null;
        List<SegModulo> aux = new ArrayList<SegModulo>();
        
        if(tipo.contentEquals("byRol")){
            q = em.createQuery("Select l.idPagina.idModulo from SegPaginaAsignada l where l.idRol.idRol=:filtro");
            q.setParameter("filtro", band);
            aux = q.getResultList();
        }

        if(tipo.contentEquals("byModulo")){
            q = em.createQuery("Select l from SegModulo l where l.idModulo=:filtro");
            q.setParameter("filtro", band);
            aux = q.getResultList();
        }
        
         if(tipo.contentEquals("byUsuario")){
            q = em.createQuery("Select l.idPagina.idModulo from SegPaginaAsignada l where l.idUsuario.idUsuario=:filtro");
            q.setParameter("filtro", band);
            aux = q.getResultList();
        }
         
        return aux;
    }
    
    
    
    
    /// 
//    
//     @Override
//    public int getTotalEmpleados() {
//        int total;
//        EntityManager em = emf.createEntityManager();
//        Query q = em.createQuery("Select l from RrhhUnidadPersona l WHERE l.restrictiva=N");
//        //q.setParameter("filtro", "N");
//        
//        total = q.getResultList().size();
//        return total;
//    }
           
}
