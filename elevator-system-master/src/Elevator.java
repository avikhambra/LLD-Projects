// Elevator class
class Elevator {
    private ControlPanel controlPanel;

    public Elevator() {
        this.controlPanel = new ControlPanel();
    }

    public void move(Direction direction) {
        // Logic for moving the elevator
        System.out.println("Elevator moving " + direction);
    }

    public void stop() {
        // Logic for stopping the elevator
        System.out.println("Elevator stopped");
    }
}
