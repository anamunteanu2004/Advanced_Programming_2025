public class Airliner extends Aircraft implements PassengerCapable, CargoCapable {
    private int seatCount;
    private final double maximumPayload;

    public Airliner(String name, String model, String tailNumber, int seatCount, double maximumPayload)
    {
        super(name, model, tailNumber);
        this.seatCount = seatCount;
        this.maximumPayload = maximumPayload;
    }

    protected String name;
    protected String model;
    protected String tailNumber;
    
    @Override
        public int getSeatCount() {
        return seatCount;
    }
    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
    @Override
    public double getMaximumPayload() {
        return maximumPayload;
    }
}
