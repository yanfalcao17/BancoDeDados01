package model;


public class MedicaoVistoria extends GenericModel{
	
	private Integer raio; 
	private String perfil;
	private String largura;
	private String indice_carga;

    public MedicaoVistoria(Integer raio, String perfil, String largura, String indice_carga) {
        this.perfil = perfil;
        this.setLargura(largura);
        this.setIndice_carga(indice_carga);
    }

    public MedicaoVistoria(Integer id, Integer raio, String perfil, String largura, String indice_carga) {
        this.perfil = perfil;
        this.setLargura(largura);
        this.setIndice_carga(indice_carga);
        super.setId(id);
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    public String getLargura() {
		return largura;
	}

	public void setLargura(String largura) {
		this.largura = largura;
	}

	public String getIndice_carga() {
		return indice_carga;
	}

	public void setIndice_carga(String indice_carga) {
		this.indice_carga = indice_carga;
	}

	public Integer getRaio() {
		return raio;
	}

	public void setRaio(Integer raio) {
		this.raio = raio;
	}

    @Override
    public String toString() {
        return "medição vistoria {" +
                "id='" + this.getId() + "\'" +
                "raio='" + raio + "\'" + 
                "perfil='" + perfil + "\'" + 
                "largura='" + largura + "\'" +
                "indice da carga='" + indice_carga + "\'" +
                '}';
    }

	


}
