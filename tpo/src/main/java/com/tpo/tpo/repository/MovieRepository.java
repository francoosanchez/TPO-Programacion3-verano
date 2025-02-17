package com.tpo.tpo.repository;

import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.tpo.tpo.entity.MovieEntity;

public interface MovieRepository extends Neo4jRepository<MovieEntity, String> {
    Optional<MovieEntity> findByTitle(String title);
}
