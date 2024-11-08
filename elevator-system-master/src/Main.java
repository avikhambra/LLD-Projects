
public class Main {
    public static void main(String[] args) {
        // Create an ElevatorSystem with 2 elevators and 5 floors
        ElevatorSystem elevatorSystem = new ElevatorSystem(2, 5);

        // Request an elevator from floor 3 going up
        Elevator elevator = elevatorSystem.requestElevator(3, Direction.UP);
        elevator.move(Direction.UP);

        // Request an elevator from floor 1 going down
        elevator = elevatorSystem.requestElevator(1, Direction.DOWN);
        elevator.move(Direction.DOWN);

    }
}

        