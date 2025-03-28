package com.robot.navigation;

public class Path {
    private final Location from, to;
    private final double time;
    private final double safetyProbability;

    public Path(Location from, Location to, double time, double safetyProbability) {
        this.from = from;
        this.to = to;
        this.time = time;
        this.safetyProbability = safetyProbability;
    }

    public Location getFrom() { return from; }
    public Location getTo() { return to; }
    public double getTime() { return time; }
    public double getSafetyProbability() { return safetyProbability; }

    @Override
    public String toString() {
        return from.getName() + " -> " + to.getName() + " [Time: " + time + ", Safety: " + safetyProbability + "]";
    }
}
