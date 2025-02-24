package com.tpo.tpo.service;

import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class DB {

    private final Neo4jClient neo4jClient;

    public DB(Neo4jClient neo4jClient) {
        this.neo4jClient = neo4jClient;
    }

    @PostConstruct
    public void seedDatabase() {
        neo4jClient.query("MATCH (n) DETACH DELETE n").run(); // Limpiar la base de datos

        String query = """
// Crear Películas
MERGE (p1:Movie {title: 'Fight Club', genre: 'drama'})
MERGE (p2:Movie {title: 'Pulp Fiction', genre: 'fiction'})
MERGE (p3:Movie {title: 'Inglorious Basterds'})
MERGE (p4:Movie {title: 'The Hobbit: An Unexpected Journey'})
MERGE (p5:Movie {title: 'The Hobbit: The Desolation of Smaug'})
MERGE (p6:Movie {title: 'The Hobbit: The Battle of the Five Armies'})
MERGE (p7:Movie {title: 'Pee Wee Herman´s Big Adventure', genre: 'childish'})
MERGE (p8:Movie {title: 'Avatar', genre: 'Science fiction'})

// Crear Actores
MERGE (a1:Actor {name: 'Brad Pitt'})
MERGE (a2:Actor {name: 'Edward Norton'})
MERGE (a3:Actor {name: 'John Travolta'})
MERGE (a4:Actor {name: 'Uma Thurman'})
MERGE (a5:Actor {name: 'Diane Kruger'})
MERGE (a6:Actor {name: 'Angelina Jolie'})
MERGE (a7:Actor {name: 'Eli Roth'})

// Crear Directores
MERGE (d1:Director {name: 'Quentin Tarantino'})
MERGE (d2:Director {name: 'James Cameron'})
MERGE (d3:Director {name: 'Tim Burton'})
MERGE (d4:Director {name: 'Peter Jackson'})
MERGE (d5:Director {name: 'David Fincher'})

// Relacionar Películas con Actores (estructura ramificada)
MERGE (a1)-[:ACTED_IN]->(p1)
MERGE (a2)-[:ACTED_IN]->(p1)
MERGE (a4)-[:ACTED_IN]->(p2)
MERGE (a4)-[:ACTED_IN]->(p7)
MERGE (a1)-[:ACTED_IN]->(p3)
MERGE (a5)-[:ACTED_IN]->(p3)
MERGE (a7)-[:ACTED_IN]->(p3)
MERGE (a1)-[:ACTED_IN]->(p4)
MERGE (a6)-[:ACTED_IN]->(p5)
MERGE (a3)-[:ACTED_IN]->(p8)
MERGE (a4)-[:ACTED_IN]->(p8)

// **Nuevas conexiones para generar diferencias en BFS y DFS**
MERGE (a1)-[:ACTED_IN]->(p2)  // Conexión entre Pulp Fiction y Movie One
MERGE (a2)-[:ACTED_IN]->(p3)  // Conexión entre Inglorious Basterds y Movie One
MERGE (a5)-[:ACTED_IN]->(p4)  // Nueva conexión con The Hobbit
MERGE (a6)-[:ACTED_IN]->(p1)  // Nueva conexión para dar más opciones a DFS
MERGE (a7)-[:ACTED_IN]->(p5)  // Más conexiones en The Hobbit

// Relacionar Películas con Directores
MERGE (p1)-[:DIRECTED_BY]->(d5)
MERGE (p2)-[:DIRECTED_BY]->(d1)
MERGE (p3)-[:DIRECTED_BY]->(d1)
MERGE (p4)-[:DIRECTED_BY]->(d4)
MERGE (p5)-[:DIRECTED_BY]->(d4)
MERGE (p6)-[:DIRECTED_BY]->(d4)
MERGE (p7)-[:DIRECTED_BY]->(d3)
MERGE (p8)-[:DIRECTED_BY]->(d2)

// **Conexión adicional entre directores y actores**
MERGE (d1)-[:WORKED_WITH]->(a1)
MERGE (d1)-[:WORKED_WITH]->(a4)
MERGE (d4)-[:WORKED_WITH]->(a5)
MERGE (d5)-[:WORKED_WITH]->(a2)


""";

        neo4jClient.query(query).run();
        System.out.println();
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("BASE DE DATOS INICIALIZADA CON PELICULAS, ACTORES Y RELACIONES.");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println();
    }
}
