import java.util.ArrayList;
import java.util.List;

// ElevatorSystem class
class ElevatorSystem {

    private List<Elevator> elevators;
    private List<Floor> floors;

    public ElevatorSystem(int numOfElevators, int numOfFloors) {
        this.elevators = new ArrayList<>();
        this.floors = new ArrayList<>();

        // Create elevators
        for (int i = 0; i < numOfElevators; i++) {
            elevators.add(new Elevator());
        }

        // Create floors
        for (int i = 0; i < numOfFloors; i++) {
            floors.add(new Floor(i + 1));
        }
    }

    public Elevator requestElevator(int floorNumber, Direction direction) {
        // Logic to determine which elevator to assign
        return elevators.get(0); // Just returning the first elevator for simplicity
    }
}
