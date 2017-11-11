
package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtil {
    public EntityManager getEM(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SitePU");
        return  emf.createEntityManager();
    }
    
}
