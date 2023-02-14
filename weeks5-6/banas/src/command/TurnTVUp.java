package command;

public class TurnTVUp implements Command {

    private final ElectronicDevice device;

    public TurnTVUp(ElectronicDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.volumeUp();
    }

    @Override
    public void undo() {
        device.volumeDown();
    }
}