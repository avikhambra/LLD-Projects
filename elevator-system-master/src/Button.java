// Button class
class Button {
    private int buttonNumber;

    public Button(int buttonNumber) {
        this.buttonNumber = buttonNumber;
    }

    public void press() {
        // Logic for pressing the button
        System.out.println("Button " + buttonNumber + " pressed");
    }
}
