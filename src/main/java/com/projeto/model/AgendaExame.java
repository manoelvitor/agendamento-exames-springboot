package com.projeto.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_exames")
public class AgendaExame extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	// OBSERVAÇÃO: VALIDAR NO CONTROLLER OS VALIDADORES COM @VALID

	// @NotNull(message = "Favor informar o nome do paciente")
	// @NotBlank
	@Column(name = "nm_paciente")
	private String nomePaciente;

	// @NotNull(message = "Favor informar o exame do paciente")
	// @NotBlank

	@ManyToOne
	private Exame nomeExame;

	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	@Column(name = "dt_atendimento")
	private LocalDateTime dataAtendimento = LocalDateTime.now();
	
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	@Column(name = "dt_exame")
	private String dataExame;
		
	
	public String getDataExame() {
		return dataExame;
	}

	public void setDataExame(String dataExame) {
		this.dataExame = dataExame;
	}

	// @NotNull(message = "Favor informar a data do exame do paciente")
	// @NotBlank
	@Column(name = "ds_resultado_exame")
	private String resultadoExame;
	
	

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public Exame getNomeExame() {
		return nomeExame;
	}

	public void setNomeExame(Exame nomeExame) {
		this.nomeExame = nomeExame;
	}

	public LocalDateTime getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(LocalDateTime dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}


	public String getResultadoExame() {
		return resultadoExame;
	}

	public void setResultadoExame(String resultadoExame) {
		this.resultadoExame = resultadoExame;
	}

	public AgendaExame() {
	}

}
