package com.tpo.tpo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tpo.tpo.service.GraphSearchService;

@RestController
@RequestMapping("/graph")
public class GraphController {
    @Autowired
    private GraphSearchService graphSearchService;

    @GetMapping("/shortest-path")
    public List<String> getShortestPath(@RequestParam String movie1, @RequestParam String movie2) {
        return graphSearchService.shortestPathWithBranchAndBound(movie1, movie2);
    }

    @GetMapping("/dfs")
    public List<String> dfs(@RequestParam String movie) {
        return graphSearchService.depthFirstSearch(movie);
    }

    @GetMapping("/bfs")
    public List<String> bfs(@RequestParam String movie) {
        return graphSearchService.breadthFirstSearch(movie);
    }
  
    @GetMapping("/actor-director-relation")
    public List<String> getActorDirectorRelation(@RequestParam String director, @RequestParam String actor) {
        return graphSearchService.actorDirectorRelation(director, actor);
    }
}
