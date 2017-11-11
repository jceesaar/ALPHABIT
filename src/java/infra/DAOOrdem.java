
package infra;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;



public class DAOOrdem  extends DaoGenerico<EntidadeGenerica>{
     public List<Ordem>listar(){
        JPAUtil jpautil = new JPAUtil();
        EntityManager em = jpautil.getEM();
        Query listar = em.createQuery("select o from Ordem o ", Ordem.class);
    
    List<Ordem> ordens = listar.getResultList();
    return ordens;
    }
    
    public List<Ordem> listaCompleta(){
        List<Ordem> ordens = null;
        EntityManager em = jutil.getEM();
        Query queryOrdens = em.createQuery("select o from Ordem o", Ordem.class);
        ordens = queryOrdens.getResultList();
        return ordens;
    }
    
    public void remover(Ordem ordem) {
        EntityManager em = jutil.getEM();
        em.getTransaction().begin();
        ordem = em.merge(ordem);
        em.remove(ordem);
        em.getTransaction().commit();
        em.close();
        
    }
}
