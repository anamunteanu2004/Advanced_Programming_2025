package com.robot.navigation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class MapGraph {
    //nod+muchii
    private final Graph<Location, DefaultWeightedEdge> graph;
    private Map<Location.Type, List<Location>> locationMap;

    public MapGraph() {
        graph = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
        locationMap = new HashMap<>();
    }

    //adaugam locatia atat in graf, cat si in HashMap-ul structurat pe tipuri.
    public void addLocation(Location location) {
        graph.addVertex(location);
        locationMap.computeIfAbsent(location.getType(), k -> new ArrayList<>()).add(location);
    }

    //adaugam o conexiune intre locatii cu un anumit timp; (ponderat)
    public void addPath(Location from, Location to, double time) {
        if (!graph.containsVertex(from) || !graph.containsVertex(to)) {
            System.out.println("Cannot add path: one or both locations are missing from the graph.");
            return;
        }
    
        DefaultWeightedEdge edge = graph.addEdge(from, to);
        if (edge != null) {
            graph.setEdgeWeight(edge, time);
        } else {
            System.out.println("Edge already exists or could not be added between " + from + " and " + to);
        }
    }

    // returnam cel mai scurt drum intre 2 locatii folosind Dijkstra.
    public List<Location> getShortestPath(Location start, Location end) {
        var dijkstra = new DijkstraShortestPath<>(graph);
        var path = dijkstra.getPath(start, end);
        
        if (path == null) {
            System.out.println("No path found between " + start + " and " + end);
            return Collections.emptyList();
        }
    
        return path.getVertexList();
    }

    //se retruneaza toate locatiile dintr-o categorie specifica.
    public List<Location> getLocationsByType(Location.Type type) {
        return locationMap.getOrDefault(type, Collections.emptyList());
    }

    //adaugam mai multe locatii in HashMap la o anumita categorie
    public void addLocationsByType(Location.Type type, List<Location> locations) {
        locationMap.put(type, new ArrayList<>(locations));
        locations.forEach(this::addLocation);
    }

    //organizam locatiile existente folosind stream-uri
    public void organizeLocationsByType(List<Location> locations) {
        locationMap = locations.stream().collect(Collectors.groupingBy(Location::getType));
        locations.forEach(this::addLocation);
    }

    // afisam locatiile grupate pe tip
    public void printLocationGroups() {
        for (Map.Entry<Location.Type, List<Location>> entry : locationMap.entrySet()) {
            System.out.println("\nType: " + entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
    }
}
