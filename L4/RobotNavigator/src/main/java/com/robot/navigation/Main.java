package com.robot.navigation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Random rand = new Random();

        MapGraph mapGraph = new MapGraph();

        //generam 10 locatii cu tipuri aleatorii
        List<Location> locations = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Location.Type type = Location.Type.values()[rand.nextInt(Location.Type.values().length)];
            locations.add(new Location(faker.address().cityName(), type));
        }

        //organizam locatiile automat pe tipuri.
        mapGraph.organizeLocationsByType(locations);
        mapGraph.printLocationGroups(); // afiseaza locatiile grupate pe tipuri

        for (int i = 0; i < 10; i++) {
            Location from = locations.get(rand.nextInt(locations.size()));
            Location to = locations.get(rand.nextInt(locations.size()));
            if (!from.equals(to)) {
                mapGraph.addPath(from, to, rand.nextDouble() * 10 + 1);
            }
        }

        if (!locations.isEmpty()) {
            Location start = locations.get(0);
            System.out.println("\nShortest Paths from: " + start);
            for (Location loc : locations) {
                if (!loc.equals(start)) {
                    List<Location> path = mapGraph.getShortestPath(start, loc);
                    System.out.println("To " + loc + ": " + path);
                }
            }
        }
    }
}
