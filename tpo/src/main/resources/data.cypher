// Eliminar todos los nodos y relaciones previos (opcional, solo en desarrollo)
        MATCH (n) DETACH DELETE n;

 // Crear Películas
        MERGE (p1:Movie {title: 'Fight Club', writer: 'Chuck Palahniuk', year: 1999, genre: 'drama'})
        MERGE (p2:Movie {title: 'Pulp Fiction', writer: 'Quentin Tarantino', year: 1994})
        MERGE (p3:Movie {title: 'Inglorious Basterds', writer: 'Quentin Tarantino', year: 2009})
        MERGE (p4:Movie {title: 'The Hobbit: An Unexpected Journey', writer: 'J.R.R. Tolkien', year: 2012, franchise: 'The Hobbit'})
        MERGE (p5:Movie {title: 'The Hobbit: The Desolation of Smaug', writer: 'J.R.R. Tolkien', year: 2013, franchise: 'The Hobbit'})
        MERGE (p6:Movie {title: 'The Hobbit: The Battle of the Five Armies', writer: 'J.R.R. Tolkien', year: 2012, franchise: 'The Hobbit', synopsis: 'Bilbo and Company are forced to engage in a war.'})
        MERGE (p7:Movie {title: 'Pee Wee Herman´s Big Adventure', genre: 'childish'})
        MERGE (p8:Movie {title: 'Avatar', genre: 'Science fiction'})

        // Crear Actores
        MERGE (a1:Actor {name: 'Brad Pitt', birthdate: '18-12-1963'})
        MERGE (a2:Actor {name: 'Edward Norton'})
        MERGE (a3:Actor {name: 'John Travolta', birthplace: 'New Jersey'})
        MERGE (a4:Actor {name: 'Uma Thurman'})
        MERGE (a5:Actor {name: 'Diane Kruger'})
        MERGE (a6:Actor {name: 'Angelina Jolie', birthdate: '04-06-1975'})
        MERGE (a7:Actor {name: 'Eli Roth', birthplace: 'Massachusetts'})

        // Crear Directores
        MERGE (d1:Director {name: 'Quentin Tarantino', birthplace: 'Tennessee'})
        MERGE (d2:Director {name: 'James Cameron'})
        MERGE (d3:Director {name: 'Tim Burton'})
        MERGE (d4:Director {name: 'Peter Jackson', birthplace: 'Porirua'})
        MERGE (d5:Director {name: 'David Fincher'})

        // Relacionar Películas con Actores
        MERGE (a1)-[:ACTED_IN]->(p1)
        MERGE (a2)-[:ACTED_IN]->(p1)
        MERGE (a3)-[:ACTED_IN]->(p2)
        MERGE (a4)-[:ACTED_IN]->(p2)
        MERGE (a1)-[:ACTED_IN]->(p3)
        MERGE (a5)-[:ACTED_IN]->(p3)
        MERGE (a7)-[:ACTED_IN]->(p3)

        // Relacionar Actores (Parejas)
        MERGE (a2)-[:MARRIED_TO]->(a4)
        MERGE (a5)-[:MARRIED_TO]->(a7)
        MERGE (a6)-[:MARRIED_TO]->(a1)

        // Relacionar Películas con Directores
        MERGE (p1)-[:DIRECTED_BY]->(d5)
        MERGE (p2)-[:DIRECTED_BY]->(d1)
        MERGE (p3)-[:DIRECTED_BY]->(d1)
        MERGE (p4)-[:DIRECTED_BY]->(d4)
        MERGE (p5)-[:DIRECTED_BY]->(d4)
        MERGE (p6)-[:DIRECTED_BY]->(d4)
        MERGE (p7)-[:DIRECTED_BY]->(d3)
        MERGE (p8)-[:DIRECTED_BY]->(d2)

        // Relacionar Actores en películas comunes
        MERGE (a1)-[:ACTED_IN]->(p2)
        MERGE (a2)-[:ACTED_IN]->(p3)