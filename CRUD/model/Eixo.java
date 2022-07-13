package model;

public class Eixo extends GenericModel{
	private String descricao;
	private Integer posicao;

    public Eixo(String descricao, Integer posicao) {
        this.descricao = descricao;
        this.posicao = posicao;
    }

    public Eixo(Integer id, String descricao, Integer posicao) {
        this.descricao = descricao;
        this.posicao = posicao;
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Integer getPocisao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }

    @Override
    public String toString() {
        return "Eixo {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + descricao + "\'" + 
                "posição='" + posicao + "\'" +
                '}';
    }

}
