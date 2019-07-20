package com.models;

import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "actor")
public class ActorModel {

	@Id
	@Column(name = "actor_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@ManyToMany(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinTable(name = "actor_film", joinColumns = { @JoinColumn(name = "actor_id") }, inverseJoinColumns = {
			@JoinColumn(name = "film_id") })
	// @Fetch(FetchMode.JOIN)
	private Collection<FilmModel> films = new LinkedList<FilmModel>();

	public Collection<FilmModel> getFilms() {
		return films;
	}

	public void setFilms(Collection<FilmModel> films) {
		this.films = films;
	}

	public ActorModel() {

	}

	// public ActorModel(int id, String firstName, String lastName) {
	// super();
	// this.id = id;
	// this.firstName = firstName;
	// this.lastName = lastName;
	// }
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
