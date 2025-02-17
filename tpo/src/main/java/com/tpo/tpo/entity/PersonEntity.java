package com.tpo.tpo.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("Person")
public class PersonEntity {

    @Id
    private String name;

    private Integer born;

    @Relationship(type = "ACTED_IN")
    private Set<MovieEntity> movies = new HashSet<>();

    public PersonEntity() {} // ⚠️ Constructor vacío obligatorio

    public PersonEntity(String name, Integer born) {
        this.name = name;
        this.born = born;
    }

    // ✅ Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBorn() {
        return born;
    }

    public void setBorn(Integer born) {
        this.born = born;
    }

    public Set<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(Set<MovieEntity> movies) {
        this.movies = movies;
    }
}

