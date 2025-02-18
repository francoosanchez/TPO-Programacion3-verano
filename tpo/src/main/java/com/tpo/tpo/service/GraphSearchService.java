package com.tpo.tpo.service;

import com.tpo.tpo.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GraphSearchService {

    private final MovieRepository movieRepository;

    public GraphSearchService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

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
}

