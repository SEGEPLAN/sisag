 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.web.implement;


import gt.gob.segeplan.sisag.core.web.controller.catalogosController;
import gt.gob.segeplan.sisag.core.web.controller.servidoresController;
import gt.gob.segeplan.sisag.rrhh.entities.DtiDispositivo;
import gt.gob.segeplan.sisag.rrhh.entities.DtiGabinete;
import gt.gob.segeplan.sisag.rrhh.entities.DtiIpServer;
import gt.gob.segeplan.sisag.rrhh.entities.DtiServidor;
import gt.gob.segeplan.sisag.rrhh.entities.DtiSistemaOperativo;
import gt.gob.segeplan.sisag.rrhh.entities.DtiTipoDispositivo;
import gt.gob.segeplan.sisag.rrhh.entities.DtiTipoServer;
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
public class servidoresImplement implements servidoresController{

    private EntityManagerFactory emf;
    private static servidoresImplement instance = null;

    public static servidoresImplement getInstance() {
        if (instance == null) {
            instance = new servidoresImplement();
        }
        return instance;
    }
    
    public servidoresImplement() {
        
        emf = Persistence.createEntityManagerFactory("sisagPU");
    }

    
    // CONSULTAS
    
     @Override
    public DtiGabinete findGabinete(int band) {
        
        EntityManager em = emf.createEntityManager();
        DtiGabinete aux = new DtiGabinete();
        try {
           Query q = null;
           q = em.createQuery("SELECT s FROM DtiGabinete s WHERE s.id =:filtro");
	   q.setParameter("filtro", band);
           aux = (DtiGabinete) q.getSingleResult();
        } catch (Exception nre){
			System.out.println("Exception "+nre.toString());
        }finally{
             em.close();
        }
        
    return aux; 
        
    }

    
    @Override
    public List<DtiGabinete> getListGabinete(String tipo, int band) {
        EntityManager em = emf.createEntityManager();
        List<DtiGabinete> listado = new ArrayList<DtiGabinete>();
        Query q = null;

        if(tipo.contains("todo"))
        {
            q = em.createQuery("Select l from DtiGabinete l ORDER BY l.nombre ASC");
            listado = q.getResultList();
        }
        if(tipo.contains("idGabinete")){
             q = em.createQuery("Select l from DtiGabinete l where l.id  =:filtro");
                q.setParameter("filtro",band );
        }
        
        return listado;
    }
    
    
    @Override
    public List<DtiDispositivo> getListDispositivo(String tipo, int band) {
        EntityManager em = emf.createEntityManager();
        List<DtiDispositivo> listado = new ArrayList<DtiDispositivo>();
        Query q = null;

        if(tipo.contains("todo"))
        {
            q = em.createQuery("Select l from DtiDispositivo l ORDER BY l.nombre ASC");
            listado = q.getResultList();
        }
        if(tipo.contains("byGabinete")){
             q = em.createQuery("Select l from DtiDispositivo l where l.idGabinete.id =:filtro");
                q.setParameter("filtro",band );
        }
        
        return listado;
    }
    
    
    public DtiGabinete find(Long id) {
         EntityManager em = emf.createEntityManager();
        return em.find(DtiGabinete.class, id);
    }
    
    // ABC
    
    
    @Override
    public DtiGabinete crearGabinete(DtiGabinete objeto) {
        
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
    public DtiGabinete editarGabinete(DtiGabinete objeto) {
        
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
    public String borrarGabinete(DtiGabinete objeto) {
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

    @Override
    public DtiDispositivo crearDispositivo(DtiDispositivo objeto) {
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
    public DtiDispositivo editarDispositivo(DtiDispositivo objeto) {
          
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
    public String borrarDispositivo(DtiDispositivo objeto) {
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

    @Override
    public DtiIpServer crearIpServer(DtiIpServer objeto) {
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
    public DtiIpServer editarIpServer(DtiIpServer objeto) {
          
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
    public String borrarIpServer(DtiIpServer objeto) {
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

    @Override
    public DtiServidor crearServidor(DtiServidor objeto) {
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
    public DtiServidor editarServidor(DtiServidor objeto) {
          
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
    public String borrarServidor(DtiServidor objeto) {
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

    @Override
    public DtiSistemaOperativo crearSistOpe(DtiSistemaOperativo objeto) {
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
    public DtiSistemaOperativo editarSistOpe(DtiSistemaOperativo objeto) {
          
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
    public String borrarSistOpe(DtiSistemaOperativo objeto) {
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

    @Override
    public DtiTipoDispositivo crearTipoDispositivo(DtiTipoDispositivo objeto) {
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
    public DtiTipoDispositivo editarTipoDispositivo(DtiTipoDispositivo objeto) {
          
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
    public String borrarTipoDispositivo(DtiTipoDispositivo objeto) {
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

    @Override
    public DtiTipoServer crearTipoServer(DtiTipoServer objeto) {
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
    public DtiTipoServer editarTipoServer(DtiTipoServer objeto) {
          
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
    public String borrarTipoServer(DtiTipoServer objeto) {
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
