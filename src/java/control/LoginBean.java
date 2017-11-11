package control;

import control.util.sessionUtil;
import infra.DAOUsuario;
import infra.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    private DAOUsuario usuarioDAO = new DAOUsuario();
     private Usuario usuario = new Usuario();
        
        public String logar() {
              
              usuario = usuarioDAO.getUsuario(usuario.getNome(), usuario.getSenha());
              String url = null;
              if (usuario == null) {
                    usuario = new Usuario();
                    FacesContext.getCurrentInstance().addMessage("validaSenhasLogin", new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário/Senha incorreto", null));
                    return "Erro!";
              } else {
                    url = "/faces/index.xhtml";
                    sessionUtil.setParam("USUARIOLogado", usuario);
                    return url;
              }
              
        
        }
   
        public String cadastrar() {

                    return "UsuarioCadastro";
        }
        
        public String Logout() {

                    return "login";
        }
        
        public String getLogin() {
              return usuario.getNome();
        }
         
         
        public Usuario getUsuario() {
              return usuario;
        }
   
        public void setUsuario(Usuario usuario) {
              this.usuario = usuario;
        }
    
}
