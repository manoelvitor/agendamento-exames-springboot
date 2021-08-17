package com.projeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_exame")
public class Exame extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "nm_exame")
	String nomeExame;

	@Column(name = "ds_exame")
	String observacao;

	public String getNomeExame() {
		return nomeExame;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Exame() {
	}

}
