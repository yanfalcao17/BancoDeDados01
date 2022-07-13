package model;

public class EixoVeiculo extends GenericModel{
	
	 public EixoVeiculo(Integer id) {
	        super.setId(id);
	    }
	 
	 @Override
	    public String toString() {
	        return "Eixo_Veiculo {" +
	                "id='" + this.getId() + "\'" +
	                '}';
	    }

}
