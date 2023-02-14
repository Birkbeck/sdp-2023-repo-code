package bridge;

// Abstraction

// This is an abstract class that will represent numerous
// ways to work with each device

public abstract class RemoteButton {

    // A reference to a generic device using aggregation

    private final EntertainmentDevice device;

    public RemoteButton(EntertainmentDevice device) {
        this.device = device;
    }

    public void buttonFivePressed() {
        device.buttonFivePressed();
    }

    public void buttonSixPressed() {
        device.buttonSixPressed();
    }

    public void deviceFeedback() {
        device.deviceFeedback();
    }

    public abstract void buttonNinePressed();
}