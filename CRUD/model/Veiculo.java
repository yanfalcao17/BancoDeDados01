package model;

public class Veiculo extends GenericModel {
	private String descricao;

    public Veiculo(String descricao) {
        this.descricao = descricao;
    }

    public Veiculo(Integer id, String descricao) {
        this.descricao = descricao;
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Veiculo {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + descricao + "\'" +
                '}';
    }

}
