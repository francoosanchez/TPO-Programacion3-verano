package com.tpo.tpo.repository;


import com.tpo.tpo.entity.MovieEntity;
import com.tpo.tpo.entity.PersonEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface PersonRepository extends Neo4jRepository<PersonEntity, String> {
}
