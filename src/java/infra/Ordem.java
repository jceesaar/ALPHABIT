
package infra;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ordem implements EntidadeGenerica{
     private static final long serialVersionUID=1L;
     @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ID;
    private String moeda;
    private double cotacao;
    private double valor;
    private double valorFinal;
    private Date data;

     /**
     *
     * @return
     */
    @Override
    public Long getID() {
        return ID;
    }
    
    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }
    
        public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }
    
    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }
    
    public void calcularValorFinal() {
        this.valorFinal = this.cotacao / this.valor;
    }
    
    public Date getDataOrdem() {
        return data;
    }

    public void setDataOrdem(Date data) {
        this.data = data;
    }
    

     @Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Ordem) {
			Ordem ordem = (Ordem) obj;
			if (Objects.equals(ordem.getID(), this.ID))
				return true;
		}
		return false;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.ID);
        return hash;
    }

    
    
}
