package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.models.ActorModel;

@Repository
public interface ActorRepository extends CrudRepository<ActorModel, Integer> {
	// @Query("from ActorModel,FilmModel where first_name=?1")
	public List<ActorModel> findByFirstName(String name);
}
