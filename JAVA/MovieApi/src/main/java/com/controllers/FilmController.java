package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.models.FilmModel;
import com.services.FilmService;

@RestController
@RequestMapping("films")
public class FilmController {

	@Autowired
	private FilmService filmService;

	@RequestMapping("/all")
	@ResponseBody
	public List<FilmModel> getAllFilms() {
		List<FilmModel> filmList = filmService.getAllFilms();
		return filmList;

	}

}
