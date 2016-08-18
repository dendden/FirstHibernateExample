package de.laliluna.example;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="bee_gen", sequenceName="bee_id_seq")
public class Bee implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bee_gen")
	private Integer id;
	private String name;
	@ManyToOne
	@JoinColumn //marks foreign key
	private Honey honey;
	
	public Bee() {}

	public Bee(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Honey getHoney() {
		return honey;
	}

	public void setHoney(Honey honey) {
		this.honey = honey;
	}

	@Override
	public String toString() {
		return "Bee [id=" + id + ", name=" + name + ", honey=" + honey + "]";
	}
	
}
