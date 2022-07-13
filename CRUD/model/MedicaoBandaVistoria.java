package model;


public class MedicaoBandaVistoria extends GenericModel {
	private float valor;

    public MedicaoBandaVistoria(float valor) {
        this.valor = valor;
    }

    public MedicaoBandaVistoria(Integer id, float valor) {
        this.valor = valor;
        super.setId(id);
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    

    @Override
    public String toString() {
        return "medição banda vistoria {" +
                "id='" + this.getId() + "\'" +
                "valor='" + valor + "\'" + 
                '}';
    }



}
