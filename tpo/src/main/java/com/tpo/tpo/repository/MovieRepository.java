package com.tpo.tpo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.tpo.tpo.entity.MovieEntity;

public interface MovieRepository extends Neo4jRepository<MovieEntity, String> {
    Optional<MovieEntity> findByTitle(String title);

    @Query("MATCH (m:Movie)<-[:ACTED_IN|DIRECTED_BY]-(p:Actor|Director)-[:ACTED_IN|DIRECTED_BY]->(m2:Movie) " +
       "WHERE m.title = $title " +
       "RETURN m2.title " +
       "LIMIT 10")
    List<String> findConnectedMovies(String title);

    @Query("MATCH (d:Director)<-[:DIRECTED_BY]-(m:Movie) WHERE d.name = $director AND m.title = $movie RETURN COUNT(m) > 0")
    boolean isMovieDirectedBy(String movie, String director);

    @Query("MATCH (a:Actor)-[:ACTED_IN]->(m:Movie) WHERE a.name = $actor AND m.title = $movie RETURN COUNT(m) > 0")
    boolean isMovieActedInBy(String movie, String actor);

    @Query("MATCH (d:Director)-[:DIRECTED]->(m:Movie) WHERE d.name = $director RETURN m.title")
    List<String> findMoviesByDirector(String director);

    @Query("MATCH (a:Actor)-[:ACTED_IN]->(m:Movie) WHERE a.name = $actor RETURN m.title")
    List<String> findMoviesByActor(String actor);
}
