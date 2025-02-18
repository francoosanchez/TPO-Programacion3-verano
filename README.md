## Búsqueda por Ramificación y Poda

Puedes realizar una búsqueda por ramificación y poda para encontrar el camino más corto entre dos películas utilizando el siguiente comando `curl`:

```bash
curl --location 'http://localhost:8080/graph/shortest-path?movie1=Fight Club&movie2=Inglorious Basterds'
```


## Realizar Recorridos sobre Grafos DFS y BFS

###  Recorrido DFS (Depth-First Search)
Puedes realizar un recorrido DFS desde una película específica utilizando el siguiente comando `curl`:

```bash
curl --location 'http://localhost:8080/graph/dfs?movie=Fight Club'
```

### Recorrido BFS (Breadth-First Search)
El recorrido en anchura (BFS) explora los nodos nivel por nivel, comenzando desde un nodo raíz y visitando primero todos los vecinos más cercanos.

Para realizar un recorrido BFS desde una película específica, utiliza el siguiente comando curl:

```bash
curl --location 'http://localhost:8080/graph/bfs?movie=Fight Club'
```