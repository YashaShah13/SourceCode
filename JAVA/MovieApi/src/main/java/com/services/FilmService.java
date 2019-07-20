package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.FilmModel;
import com.repository.FilmRepository;

@Service
public class FilmService {
	@Autowired
	private FilmRepository filmRepository;

	public List<FilmModel> getAllFilms() {
		// TODO Auto-generated method stub
		List<FilmModel> filmList = (List<FilmModel>) filmRepository.findAll();
		return filmList;
	}

}
