import java.util.ArrayList;
import java.util.List;

// ControlPanel class
class ControlPanel {
    private List<Button> buttons;

    public ControlPanel() {
        this.buttons = new ArrayList<>();
        // Assuming 10 buttons for simplicity
        for (int i = 0; i < 10; i++) {
            buttons.add(new Button(i));
        }
    }

    public void pressButton(Button button) {
        button.press();
    }
}


