
package infra;



import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Usuario implements EntidadeGenerica{
    
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ID;
    private String nome;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;
    private String email;
    private String senha;
    
    /**
     *
     * @return
     */
    @Override
    public Long getID() {
        return ID;
    }
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
  
   
   
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
 

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Usuario) {
			Usuario usuario = (Usuario) obj;
			if (usuario.getSenha().equalsIgnoreCase(senha))
				return true;
		}
		return false;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.senha);
        return hash;
    }
    
}
