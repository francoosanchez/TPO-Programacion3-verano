package com.tpo.tpo.entity;

import java.util.HashSet;
import java.util.Set;
import org.springframework.data.neo4j.core.schema.*;

@Node("Director")
public class DirectorEntity extends PersonEntity {

    @Relationship(type = "DIRECTED_BY")
    private Set<MovieEntity> movies = new HashSet<>();

    public DirectorEntity() {}

    public DirectorEntity(String name, String birthdate, String birthplace) {
        super(name, birthdate, birthplace);
    }

    // Getters y Setters
    public Set<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(Set<MovieEntity> movies) {
        this.movies = movies;
    }
}

