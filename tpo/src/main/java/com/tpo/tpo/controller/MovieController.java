package com.tpo.tpo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpo.tpo.entity.MovieEntity;
import com.tpo.tpo.repository.MovieRepository;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public List<MovieEntity> getMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{title}")
    public MovieEntity getMovieByTitle(@PathVariable String title) {
        return movieRepository.findById(title).orElse(null);
    }

    @PutMapping
    public MovieEntity createOrUpdateMovie(@RequestBody MovieEntity newMovie) {
        return movieRepository.save(newMovie);
    }

}
