package model;

import java.sql.Date;

public class VistoriaVeiculo extends GenericModel {
	
	private String observacao; 
	private Date data_vistoria;
	private String username;
	private Date data_cadastro;
	private String vistoria_veiculocol;

    public VistoriaVeiculo(String observacao, Date data_vistoria, String username, Date data_cadastro, String vistoria_veiculocol) {
        this.observacao = observacao;
        this.data_vistoria = data_vistoria;
        this.username = username;
        this.data_cadastro = data_cadastro;
        this.vistoria_veiculocol = vistoria_veiculocol;
    }

    public VistoriaVeiculo(Integer id, String observacao, Date data_vistoria, String username, Date data_cadastro, String vistoria_veiculocol) {
        this.observacao = observacao;
        this.data_vistoria = data_vistoria;
        this.username = username;
        this.data_cadastro = data_cadastro;
        this.vistoria_veiculocol = vistoria_veiculocol;
        super.setId(id);
    }

    public Date getData_vistoria() {
        return data_vistoria;
    }

    public void setData_vistoria(Date data_vistoria) {
        this.data_vistoria = data_vistoria;
    }
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getVistoria_veiculocol() {
		return vistoria_veiculocol;
	}

	public void setVistoria_veiculocol(String vistoria_veiculocol) {
		this.vistoria_veiculocol = vistoria_veiculocol;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

    @Override
    public String toString() {
        return "Vistoria Veiculo {" +
                "id='" + this.getId() + "\'" +
                "observacao='" + observacao + "\'" + 
                "data da vistoria='" + data_vistoria + "\'" + 
                "username='" + username + "\'" +
                "data do cadastro='" + data_cadastro + "\'" +
                "vistoria do veiculo='" + vistoria_veiculocol + "\'" +
                '}';
    }

	

}
