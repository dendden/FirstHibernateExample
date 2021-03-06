package de.laliluna.example;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="honey_gen", sequenceName="honey_id_seq")
public class Honey implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="honey_gen")
	private Integer id;
	private String name;
	private String taste;
	@OneToMany(mappedBy="honey")
	private Set<Bee> bees = new HashSet<Bee>();
	
	public Honey() {}

	public Honey(String name, String taste) {
		this.name = name;
		this.taste = taste;
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

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public Set<Bee> getBees() {
		return bees;
	}

	public void setBees(Set<Bee> bees) {
		this.bees = bees;
	}

	@Override
	public String toString() {
		return "Honey [id=" + id + ", name=" + name + ", taste=" + taste + "]";
	}
	
}
