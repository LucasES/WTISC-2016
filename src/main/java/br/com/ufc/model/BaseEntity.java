package br.com.ufc.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@MappedSuperclass
public class BaseEntity {

	@Column(name = "data_criacao", insertable = true, updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Brazil/East")
	@JsonProperty(value = "dataCriacao")
	private Date creationDate;
	
	@Column(name = "data_modificacao")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Brazil/East")
	@JsonProperty(value = "dataModificacao")
	private Date updateDate;
	
	@PrePersist
	protected void prePersist() {
		Date now = new Date();
		this.creationDate = now;
		this.updateDate = now;
	}
	
	@PreUpdate
	protected void preUpdate() {
		this.updateDate = Calendar.getInstance().getTime();
	}
	
}
