package com.tpo.tpo.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("Movie")
public class MovieEntity {

    @Id
    private String title;

    @Property("writer")
    private String writer;

    @Property("year")
    private Integer year;

    @Property("genre")
    private String genre;

    @Property("franchise")
    private String franchise;

    @Property("synopsis")
    private String synopsis;

    // Relación con Actores
    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private Set<ActorEntity> actors = new HashSet<>();

    // Relación con Directores
    @Relationship(type = "DIRECTED_BY", direction = Relationship.Direction.INCOMING)
    private Set<DirectorEntity> directors = new HashSet<>();

    public MovieEntity() {
    }

    public MovieEntity(String title, String writer, Integer year, String genre) {
        this.title = title;
        this.writer = writer;
        this.year = year;
        this.genre = genre;
    }

    // Getters y Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFranchise() {
        return franchise;
    }

    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Set<ActorEntity> getActors() {
        return actors;
    }

    public void setActors(Set<ActorEntity> actors) {
        this.actors = actors;
    }

    public Set<DirectorEntity> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<DirectorEntity> directors) {
        this.directors = directors;
    }
}