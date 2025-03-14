public class Drone extends Aircraft implements CargoCapable {
    private double batteryLife;
    private final double maximumPayload;

    public Drone(String name, String model, String tailNumber, double batteryLife, double maximumPayload) {
        super(name, model, tailNumber);
        this.batteryLife = batteryLife;
        this.maximumPayload = maximumPayload;
    }

    @Override
    public double getMaximumPayload() {
        return maximumPayload;
    }
}
