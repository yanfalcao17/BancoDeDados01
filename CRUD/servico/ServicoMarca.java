package servico;

import DAO.MarcaDAO;
import model.Marca;


public class ServicoMarca extends MarcaDAO{

    //TODO: Aqui é um exemplo de regra de negócio. possivelmente quando estivermos implementando
    // as regras de vistoria do pneu tenham regras nesse modelo de padrão de projeto.
    public void insertMarca(Marca entidade) {
        if (count() <= 20) {
            super.insertMarca(entidade);
        }
    }
}
