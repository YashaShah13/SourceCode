package com.models;

import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "film")
public class FilmModel {
	

	@Id
	@Column(name = "film_id")
	private int id;

	private String title;
	private String description;
	private String rating;

	@ManyToMany(mappedBy = "films")
	@JsonBackReference

	private Collection<ActorModel> actors = new LinkedList<ActorModel>();

	public Collection<ActorModel> getActors() {
		return actors;
	}

	public void setActors(Collection<ActorModel> actors) {
		this.actors = actors;
	}

	public FilmModel() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}


}
