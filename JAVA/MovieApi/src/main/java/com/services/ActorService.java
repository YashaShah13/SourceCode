package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.ActorModel;
import com.repositories.ActorRepository;

@Service
public class ActorService {
	
	@Autowired
	private ActorRepository actorRepository;

	public List<ActorModel> getAllActors() {
		// TODO Auto-generated method stub

		List<ActorModel> list = (List<ActorModel>) actorRepository.findAll();
		return list;
	}

	public ActorModel getActorById(int id) {
		// TODO Auto-generated method stub
		ActorModel actor = actorRepository.findById(id).orElse(new ActorModel());
		return actor;
	}

	public List<ActorModel> getActorByName(String name) {
		// TODO Auto-generated method stub
		List<ActorModel> list = (List<ActorModel>) actorRepository.findByFirstName(name);
		return list;
	}


}
