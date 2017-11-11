
package control;

import domain.OrdemBR;
import infra.DAOUsuario;
import domain.UsuarioBR;
import infra.DAOOrdem;
import infra.Ordem;
import infra.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named(value = "beanOrdem")
@RequestScoped
 
public class BeanOrdem implements Serializable {
   
      
    private String moeda;
    private double cotacao;
    private double valor;
    private double valorFinal;
    private Date data;
    private List<Ordem> listagem;  

     public BeanOrdem(){
        DAOOrdem daoordem = new DAOOrdem();
        this.listagem = daoordem.listaCompleta();
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }
    
   
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public double getValorFinal() {
        return valor;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }
    
    public double calcularValorFinal() {
        this.valorFinal = this.cotacao * this.valor;
        return this.valorFinal;
    }


    public List<Ordem> getListagem() {
        return listagem;
    }
    

    public void setListagem(List<Ordem> listagem) {
        this.listagem = listagem;
    }
    public String salvar(){
       OrdemBR ordembr = new OrdemBR();
       ordembr.salvar(this.moeda, this.cotacao, this.valor, this.calcularValorFinal(), this.data);
       return "OrdemList";
   
    }
        
    public void remover(Ordem ord){
        DAOOrdem daoordem = new DAOOrdem();
        daoordem.remover(ord);
    }
    
    public String comprar(Ordem ord){
//        DAOOrdem daoordem = new DAOOrdem();
//        daoordem.remover(ord);
    return "#";
    }
    
    public void listagem(){
        DAOOrdem daoordem = new DAOOrdem();
        this.listagem = daoordem.listaCompleta();
    }
    
}