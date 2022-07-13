package model;

public class PneuBanda extends GenericModel {
	
	private String observacao;
	private Integer ordem;

    public PneuBanda(String observacao, Integer ordem) {
        this.observacao = observacao;
        this.ordem = ordem;
    }

    public PneuBanda(Integer id, String observacao, Integer ordem) {
        this.observacao = observacao;
        this.ordem = ordem;
        super.setId(id);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    @Override
    public String toString() {
        return "Eixo {" +
                "id='" + this.getId() + "\'" +
                "observação='" + observacao + "\'" + 
                "ordem='" + ordem + "\'" +
                '}';
    }


}
