package solid.refactored.isp;

public class TimedDoorAdapter implements TimerClient {
    private final TimedDoor door;

    TimedDoorAdapter(TimedDoor door) {
        this.door = door;
    }

    @Override
    public void timeout() {
        door.timeout();
    }
}
