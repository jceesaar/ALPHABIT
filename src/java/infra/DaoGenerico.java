
package infra;

import javax.persistence.EntityManager;


public class DaoGenerico <T extends EntidadeGenerica>{
    
    JPAUtil jutil = new JPAUtil();
    
    
    public  T salvar (T t){
        EntityManager em = jutil.getEM();
        try{
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
    }finally {
            em.close();
        }
    return t;
    }

     public T atualizar ( T t){
        EntityManager em = jutil.getEM();
        try{
            em.getTransaction().begin();
                if(t.getID()== null){
                    t= em.merge(t);
                }
                em.getTransaction().commit();
        }catch ( Exception e){
            
        }finally{
            em.close();
        }
        return t;
    }
     public T listar (T t){
      return t;
  }
  public T buscar ( Long id, Class<T> tclass){
      EntityManager em = jutil.getEM();
      
      T t = null;
      try{
          t = em.find(tclass, id);
      }finally{
          em.close();
      }
      return t;
  }

    public T remover ( Long id, Class<T> tclass){
      EntityManager em = jutil.getEM();
      
      T t = em.find(tclass,id);
      try{
         em.getTransaction().begin();
         em.remove(t);
         em.getTransaction().commit();
      }finally{
          em.close();
      }
      return t;
  }


}
