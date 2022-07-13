package model;

import java.util.Date;

public class VistoriaPneu extends GenericModel {
	
	private String observacao;
	private Date dataCadastro;

    public VistoriaPneu(String observacao, Date dataCadastro) {
        this.observacao = observacao;
        this.dataCadastro = dataCadastro;
    }

    public VistoriaPneu(Integer id, String observacao, Date dataCadastro) {
        this.observacao = observacao;
        this.dataCadastro = dataCadastro;
        super.setId(id);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Vistoria Pneu {" +
                "id='" + this.getId() + "\'" +
                "observação='" + observacao + "\'" + 
                "data do Cadastro='" + dataCadastro + "\'" +
                '}';
    }



}
