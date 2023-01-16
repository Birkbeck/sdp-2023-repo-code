package solid.dip;

public class Button {
    private  Lamp lamp;
    private boolean state;

    Button(Lamp lamp) { this.lamp = lamp; }

    public void push() {
        state = !state;
        if (state)
            lamp.turnOn();
        else
            lamp.turnOff();
    }
}