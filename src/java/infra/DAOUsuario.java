
package infra;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;


public class DAOUsuario extends DaoGenerico<Usuario>{
   
     
      public Usuario getUsuario(String nomeUsuario, String senha) {
         
              try {
                  for (Usuario usuario : listar()) {
                      if (usuario.getNome().equalsIgnoreCase(nomeUsuario) && usuario.getSenha().equalsIgnoreCase(senha)) {
                           return usuario;
                      }
                  }
                   
              } catch (NoResultException e) {
                    return null;
              }
              return null;
        }
    public List<Usuario>listar(){
        JPAUtil jpautil = new JPAUtil();
        EntityManager em = jpautil.getEM();
        Query listar = em.createQuery("select u from Usuario u ", Usuario.class);
    
    List<Usuario> user = listar.getResultList();
    return user;
    }
    
    public List<Usuario> listaCompleta(){
        List<Usuario> usuarios = null;
        EntityManager em = jutil.getEM();
        Query queryUsr = em.createQuery("select u from Usuario u", Usuario.class);
        usuarios = queryUsr.getResultList();
        return usuarios;
    }
    

   
    public void remover(Usuario user) {
        EntityManager em = jutil.getEM();
        em.getTransaction().begin();
        user = em.merge(user);
        em.remove(user);
        em.getTransaction().commit();
        em.close();
        
    }
}