package com.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.models.FilmModel;
@Repository
public interface FilmRepository extends CrudRepository<FilmModel, Integer> {

}
