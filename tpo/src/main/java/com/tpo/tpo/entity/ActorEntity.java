package com.tpo.tpo.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.core.schema.*;

@Node("Actor")
public class ActorEntity extends PersonEntity {

    @Relationship(type = "ACTED_IN")
    private Set<MovieEntity> movies = new HashSet<>();

    @Relationship(type = "MARRIED_TO")
    private Set<ActorEntity> spouse = new HashSet<>();

    public ActorEntity() {}

    public ActorEntity(String name, String birthdate, String birthplace) {
        super(name, birthdate, birthplace);
    }

    // Getters y Setters
    public Set<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(Set<MovieEntity> movies) {
        this.movies = movies;
    }

    public Set<ActorEntity> getSpouse() {
        return spouse;
    }

    public void setSpouse(Set<ActorEntity> spouse) {
        this.spouse = spouse;
    }
}
