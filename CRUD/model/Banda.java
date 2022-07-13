package model;

public class Banda extends GenericModel {
	
	private String descricao;
	private String lado;

    public Banda(String descricao, String lado) {
        this.descricao = descricao;
        this.lado = lado;
    }

    public Banda(Integer id, String descricao, String lado) {
        this.descricao = descricao;
        this.lado = lado;
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getLado() {
        return lado;
    }

    public void setLado(String lado) {
        this.lado = lado;
    }

    @Override
    public String toString() {
        return "Banda {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + descricao + "\'" + 
                "lado='" + lado + "\'" +
                '}';
    }

}
