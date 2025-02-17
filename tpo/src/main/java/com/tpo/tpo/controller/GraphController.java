package com.tpo.tpo.controller;

import com.tpo.tpo.service.GraphSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/graph")
public class GraphController {
    @Autowired
    private GraphSearchService graphSearchService;

    @GetMapping("/shortest-path")
    public List<String> getShortestPath(@RequestParam String movie1, @RequestParam String movie2) {
        return graphSearchService.shortestPathWithBranchAndBound(movie1, movie2);
    }
}
