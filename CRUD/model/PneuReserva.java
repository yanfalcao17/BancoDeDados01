package model;

public class PneuReserva extends GenericModel {
	
	private String descricao;

    public PneuReserva(String descricao) {
        this.descricao = descricao;
    }

    public PneuReserva(Integer id, String descricao) {
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
        return "Pneu_reserva {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + descricao + "\'" +
                '}';
    }

}
