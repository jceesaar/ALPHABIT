
package domain;

import infra.DAOOrdem;
import infra.Ordem;
import java.util.Date;
import java.util.List;


public class OrdemBR {
    private Ordem ordem = null;
    DAOOrdem daoOrdem = null;
    
    public String salvar (String Moeda, double Cotacao, double Valor, double valorFinal, Date dataOrdem){
                String url;
                ordem = new Ordem();
                daoOrdem = new DAOOrdem();
                if(Moeda.isEmpty()){
                    url="index";
                }else{
                    ordem.setMoeda(Moeda);
                    ordem.setCotacao(Cotacao);
                    ordem.setValor(Valor);
                    ordem.setValorFinal(valorFinal);
                    ordem.setDataOrdem(dataOrdem);
                    
                    ordem = (Ordem) daoOrdem.salvar(ordem);
                    url="dashboard";
                }
        return url;
    }
   
    public List<Ordem> listagem(){
        List<Ordem> ordem = null;
        return ordem;
         }

    public String remover(String moeda, double cotacao, double valor, double valorFinal, Date data) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
