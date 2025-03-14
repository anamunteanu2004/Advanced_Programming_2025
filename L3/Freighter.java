public class Freighter extends Aircraft implements CargoCapable {
    private double maximumPayload;

    public Freighter(String name, String model, String tailNumber, double maximumPayload) {
        super(name, model, tailNumber);
        this.maximumPayload = maximumPayload;
    }

    @Override
    public double getMaximumPayload() {
        return maximumPayload;
    }
}
