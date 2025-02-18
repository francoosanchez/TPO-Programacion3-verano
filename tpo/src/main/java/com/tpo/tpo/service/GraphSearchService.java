package com.tpo.tpo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.tpo.tpo.repository.MovieRepository;

@Service
public class GraphSearchService {

    private final MovieRepository movieRepository;

    public GraphSearchService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // RESOLUCIÓN DE RECORRIDO UTILIZANDO RAMIFICACIÓN Y PODA

    public List<String> shortestPathWithBranchAndBound(String movieTitle1, String movieTitle2) {
        Map<String, Integer> distance = new HashMap<>();
        Map<String, String> predecessors = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));

        distance.put(movieTitle1, 0);
        queue.add(movieTitle1);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(movieTitle2)) {
                return reconstructPath(predecessors, movieTitle2);
            }

            List<String> neighbors = movieRepository.findConnectedMovies(current);

            for (String neighbor : neighbors) {
                int newDist = distance.get(current) + 1;
                if (!distance.containsKey(neighbor) || newDist < distance.get(neighbor)) {
                    distance.put(neighbor, newDist);
                    predecessors.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
        return Collections.emptyList();
    }

    private List<String> reconstructPath(Map<String, String> predecessors, String end) {
        List<String> path = new ArrayList<>();
        for (String at = end; at != null; at = predecessors.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    // RESOLUCIÓN REALIZANDO RECORRIDO DE GRAFOS DFS

    public List<String> depthFirstSearch(String startMovie) {
        Set<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();
        dfsRecursive(startMovie, visited, result);
        return result;
    }

    private void dfsRecursive(String current, Set<String> visited, List<String> result) {
        if (visited.contains(current)) {
            return;
        }
        visited.add(current);
        result.add(current);

        List<String> neighbors = movieRepository.findConnectedMovies(current);
        for (String neighbor : neighbors) {
            dfsRecursive(neighbor, visited, result);
        }
    }

    // // RESOLUCIÓN REALIZANDO RECORRIDO DE GRAFOS BFS
    public List<String> breadthFirstSearch(String startMovie) {
        Set<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startMovie);
        queue.add(startMovie);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            result.add(current);

            List<String> neighbors = movieRepository.findConnectedMovies(current);
            for (String neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return result;
    }
}
