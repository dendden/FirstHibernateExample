package de.laliluna.example;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Bee implements Serializable {

	private Integer id;
	private String name;
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
