package command;

public class TurnTVOff implements Command {

    private final ElectronicDevice device;

    public TurnTVOff(ElectronicDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.off();
    }

    // Used if you want to allow for undo
    // Do the opposite of execute()
    @Override
    public void undo() {
        device.on();
    }
}