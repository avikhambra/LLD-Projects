import java.util.ArrayList;
import java.util.List;

// CallingPanel class
class CallingPanel {

    private List<CallingButton> buttons;

    public CallingPanel() {
        this.buttons = new ArrayList<>();
        buttons.add(new CallingButton(Direction.UP));
        buttons.add(new CallingButton(Direction.DOWN));
    }

    public void pressButton(CallingButton button) {
        button.press();
    }

}

