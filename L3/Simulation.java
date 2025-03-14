import java.util.*;

public class Simulation {
    public static void main(String[] args) {
        List<Aircraft> aircraftList = new ArrayList<>();
        
        Airliner airliner = new Airliner("Avion A", "7", "N12345", 410, 10.0);
        Freighter freighter = new Freighter("Boeing", "300F", "F67890", 52.0);
        Drone drone = new Drone("Cargo", "M600", "D45678", 2.5, 10.0);
    
        aircraftList.add(airliner);
        aircraftList.add(freighter);
        aircraftList.add(drone);
    
        List<CargoCapable> cargoAircraft = new ArrayList<>();
        for (Aircraft aircraft : aircraftList) {
            if (aircraft instanceof CargoCapable cargoCapable) {
                cargoAircraft.add(cargoCapable);
            }
        }
        
        System.out.println("Cargo-capable aircraft:");
        for (CargoCapable cargo : cargoAircraft) {
            System.out.println(((Aircraft) cargo).getName() + " - Max Payload: " + cargo.getMaximumPayload() + " tons");
        }
    }
}
