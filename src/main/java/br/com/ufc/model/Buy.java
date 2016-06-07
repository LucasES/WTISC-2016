package br.com.ufc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "compra")
public class Buy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	@JsonProperty(value = "usuario")
	private User user;
	
	@Column(name = "data")
	@JsonProperty(value = "data")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone="Brazil/East", locale = "pt-BR")
	private Date date;
	
	@Column(name = "total", nullable = false)
	@JsonProperty(value = "total")
	private Float total;
	
	@Column(name = "quantidade", nullable = false)
	@JsonProperty(value = "quantidade")
	private Integer quantity;
	
	@Column(name = "ativo", nullable = false)
	@JsonProperty(value = "ativo")
	private Boolean active;

	public Buy() {
		super();
	}

	public Buy(Long id) {
		super();
		this.id = id;
	}

	public Buy(Float total, Integer quantity) {
		super();
		this.total = total;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
}
