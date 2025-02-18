### Búsqueda por Ramificación y Poda con `curl`

Puedes realizar una búsqueda por ramificación y poda para encontrar el camino más corto entre dos películas utilizando el siguiente comando `curl`:

```bash
curl --location 'http://localhost:8080/graph/shortest-path?movie1=Fight%20Club&movie2=Inglorious%20Basterds'
```

### Búsqueda por Backtracking con `curl`

Puedes realizar una búsqueda por backtracking para encontrar todas las que un director y un actor tienen en comun `curl`:


```bash
curl --location 'http://localhost:8080/graph/actor-director-relation?director=Quentin%20Tarantino&actor=Brad%20Pitt'
```