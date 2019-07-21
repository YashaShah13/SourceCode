package com.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.models.ActorModel;
@Repository
public interface ActorRepository extends CrudRepository<ActorModel, Integer> {
	
	public List<ActorModel> findByFirstName(String name);

}
