
// CallingButton class
class CallingButton {
    private Direction direction;

    public CallingButton(Direction direction) {
        this.direction = direction;
    }

    public void press() {
        // Logic for pressing the calling button
        System.out.println("Calling button pressed to go " + direction);
    }
}