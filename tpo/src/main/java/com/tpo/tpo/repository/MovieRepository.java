package com.tpo.tpo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.tpo.tpo.entity.MovieEntity;
import org.springframework.data.neo4j.repository.query.Query;

public interface MovieRepository extends Neo4jRepository<MovieEntity, String> {
    Optional<MovieEntity> findByTitle(String title);

    @Query("MATCH (m:Movie)<-[:ACTED_IN|DIRECTED_BY]-(p:Actor|Director)-[:ACTED_IN|DIRECTED_BY]->(m2:Movie) " +
            "WHERE m.title = $title " +
            "RETURN m2.title")
    List<String> findConnectedMovies(String title);

}
