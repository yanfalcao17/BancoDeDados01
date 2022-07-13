package model;


public class Pneu extends GenericModel {
	
	private Integer raio; 
	private String perfil;
	private String largura;
	private String indice_carga;
	private String indice_velocidade;
	private String pneucol;

    public Pneu(Integer raio, String perfil, String largura, String indice_carga, String indice_velocidade, String pneucol) {
        this.raio = raio;
        this.perfil = perfil;
        this.largura = largura;
        this.indice_carga = indice_carga;
        this.indice_velocidade = indice_velocidade;
        this.pneucol = pneucol;
    }

    public Pneu(Integer id, Integer raio, String perfil, String largura, String indice_carga, String indice_velocidade, String pneucol) {
        this.raio = raio;
        this.perfil = perfil;
        this.largura = largura;
        this.indice_carga = indice_carga;
        this.indice_velocidade = indice_velocidade;
        this.pneucol = pneucol;
        super.setId(id);
    }
    
    public Integer getRaio() {
		return raio;
	}

	public void setRaio(Integer raio) {
		this.raio = raio;
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

	public String getIndice_velocidade() {
		return indice_velocidade;
	}

	public void setIndice_velocidade(String indice_velocidade) {
		this.indice_velocidade = indice_velocidade;
	}

	public String getPneucol() {
		return pneucol;
	}

	public void setPneucol(String pneucol) {
		this.pneucol = pneucol;
	}

	
	@Override
    public String toString() {
        return "Vistoria Veiculo {" +
                "id='" + this.getId() + "\'" +
                "raio='" + raio + "\'" + 
                "perfil='" + perfil + "\'" + 
                "largura='" + largura + "\'" +
                "indice  da carga='" + indice_carga + "\'" +
                "indice de velocidade='" + indice_velocidade + "\'" +
                "coluna pneu='" + pneucol + "\'" +
                '}';
    }

}
