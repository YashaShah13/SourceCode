package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.models.ActorModel;
import com.services.ActorService;

@RestController
@RequestMapping("actors")
public class ActorController {
	@Autowired
	private ActorService actorService;

	@ResponseBody
	@RequestMapping("/all")
	public List<ActorModel> getAllActors() {

		List<ActorModel> actorList = actorService.getAllActors();
		return actorList;

	}

	@RequestMapping("/id/{id}")
	public ActorModel getActorById(@PathVariable int id) {

		ActorModel actor = actorService.getActorById(id);
		return actor;

	}

	@RequestMapping("/name/{name}")
	public List<ActorModel> getActorByName(@PathVariable String name) {

		List<ActorModel> actorList = actorService.getActorByName(name);
		return actorList;

	}

	// @RequestMapping("actor")
	// public String hello() {
	// return "Yash";
	// }
}
