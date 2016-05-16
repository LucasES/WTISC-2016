package br.com.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "ambiente")
public class Environment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "evento_id")
	@JsonProperty(value = "evento")
	private Event event;
	
	@ManyToOne
	@JoinColumn(name = "setor_id")
	@JsonProperty(value = "setor")
	private Sector sector;
	
	@ManyToOne
	@JoinColumn(name = "tipo_ambiente_id")
	@JsonProperty(value = "tipoAmbiente")
	private EnvironmentType environmentType;
	
	@Column(name = "descricao")
	@JsonProperty(value = "descricao")
	private String description;
	
	@Column(name = "local", nullable = false)
	@JsonProperty(value = "local")
	private String local;
	
	@Column(name = "referencia")
	@JsonProperty(value = "referencia")
	private String reference;

	public Environment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Environment(Long id) {
		super();
		this.id = id;
	}

	public Environment(String local) {
		super();
		this.local = local;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public EnvironmentType getEnvironmentType() {
		return environmentType;
	}

	public void setEnvironmentType(EnvironmentType environmentType) {
		this.environmentType = environmentType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Environment other = (Environment) obj;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		return true;
	}
	
	
}
