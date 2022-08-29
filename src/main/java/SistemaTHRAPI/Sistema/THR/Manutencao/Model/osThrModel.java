package SistemaTHRAPI.Sistema.THR.Manutencao.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Tab_OsThr")
public class osThrModel {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer numeroOS;
	
	@Column
	private String descricaoServico;
	private String tipoServico;
	private String dataHoraGeracao;
	private String usuarioGeracao;
	private String aSE;
	private String categoria;
	private String dataIdeal;
	private String prioridade;
	private String usuarioPrioridade;
	private String dataHoraPrioridade;
	private String statusOS;
	
	public Integer getNumeroOS() {
		return numeroOS;
	}
	public void setNumeroOS(Integer numeroOS) {
		this.numeroOS = numeroOS;
	}
	public String getDescricaoServico() {
		return descricaoServico;
	}
	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}
	public String getTipoServico() {
		return tipoServico;
	}
	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}
	public String getDataHoraGeracao() {
		return dataHoraGeracao;
	}
	public void setDataHoraGeracao(String dataHoraGeracao) {
		this.dataHoraGeracao = dataHoraGeracao;
	}
	public String getUsuarioGeracao() {
		return usuarioGeracao;
	}
	public void setUsuarioGeracao(String usuarioGeracao) {
		this.usuarioGeracao = usuarioGeracao;
	}
	public String getaSE() {
		return aSE;
	}
	public void setaSE(String aSE) {
		this.aSE = aSE;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDataIdeal() {
		return dataIdeal;
	}
	public void setDataIdeal(String dataIdeal) {
		this.dataIdeal = dataIdeal;
	}
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	public String getUsuarioPrioridade() {
		return usuarioPrioridade;
	}
	public void setUsuarioPrioridade(String usuarioPrioridade) {
		this.usuarioPrioridade = usuarioPrioridade;
	}
	public String getDataHoraPrioridade() {
		return dataHoraPrioridade;
	}
	public void setDataHoraPrioridade(String dataHoraPrioridade) {
		this.dataHoraPrioridade = dataHoraPrioridade;
	}
	public String getStatusOS() {
		return statusOS;
	}
	public void setStatusOS(String statusOS) {
		this.statusOS = statusOS;
	}
		

}
