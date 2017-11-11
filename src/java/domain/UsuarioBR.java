package domain;

import infra.DAOUsuario;
import infra.Usuario;
import java.util.Date;
import java.util.List;

public class UsuarioBR {
    private Usuario usuario = null;
    DAOUsuario daouser = null;
    
    public String salvar ( String login, String senha , String nome, Date data){
        String url;
        usuario = new Usuario();
        daouser = new DAOUsuario();
        if(login.isEmpty() || senha.isEmpty()){
            url="index";
        }else{
            usuario.setNome(nome);
            usuario.setSenha(senha);
            usuario.setEmail(login);
            usuario.setDataCadastro(data);
            usuario = daouser.salvar(usuario);
            url="dashboard";
        }
        return  url;
    }
   
    public List<Usuario> listagem(){
        List<Usuario> usuarios = null;
        return usuarios;
         }

    public String remover(String nome, String senha, String nome0, Date data) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    }
    