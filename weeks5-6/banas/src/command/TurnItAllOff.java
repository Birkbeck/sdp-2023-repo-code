package command;

import java.util.List;

public class TurnItAllOff implements Command {
    private final List<ElectronicDevice> devices;

    public TurnItAllOff(List<ElectronicDevice> devices) {
        this.devices = devices;
    }

    @Override
    public void execute() {
        for (ElectronicDevice device : devices)
            device.off();
    }

    @Override
    public void undo() {
        for (ElectronicDevice device : devices)
            device.on();
    }
}