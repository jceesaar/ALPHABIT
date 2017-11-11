
package control;

import infra.DAOUsuario;
import domain.UsuarioBR;
import infra.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named(value = "beanUsuario")
@RequestScoped
 
public class BeanUsuario implements Serializable {
   
      
    private String nome;
    private String email;
    private String senha;
    private Date data;
    private List<Usuario> listagem;  

     public BeanUsuario(){
        DAOUsuario daouser = new DAOUsuario();
        this.listagem = daouser.listaCompleta();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Usuario> getListagem() {
        return listagem;
    }

    public void setListagem(List<Usuario> listagem) {
        this.listagem = listagem;
    }
    public String salvar(){
        UsuarioBR userbr = new UsuarioBR();
       userbr.salvar(this.email, this.senha, this.nome, this.data);
       return "login";
   
    }
    
    
    public void remover(Usuario usr){
        DAOUsuario daouser = new DAOUsuario();
        daouser.remover(usr);
    }
    
    public void atualizar(Usuario usr){
        DAOUsuario daouser = new DAOUsuario();
        daouser.remover(usr);
    }
    
    public void listagem(){
        DAOUsuario daouser = new DAOUsuario();
        this.listagem = daouser.listaCompleta();
    }
    
}
