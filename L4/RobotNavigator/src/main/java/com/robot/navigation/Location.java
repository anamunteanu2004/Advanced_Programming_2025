package com.robot.navigation;

public class Location implements Comparable<Location> {
    public enum Type { FRIENDLY, NEUTRAL, ENEMY }

    private final String name;
    private final Type type;

    public Location(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() { return name; }
    public Type getType() { return type; }

    @Override
    public int compareTo(Location other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " (" + type + ")";
    }
}
