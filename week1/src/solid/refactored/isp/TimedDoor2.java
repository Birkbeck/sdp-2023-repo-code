package solid.refactored.isp;

public class TimedDoor2 implements Door, TimerClient {
    @Override
    public void lock() {
        /* implementation */
    }

    @Override
    public void unlock() {
        /* implementation */
    }

    @Override
    public boolean isOpen() {
        /* implementation */
        return false;
    }

    @Override
    public void timeout() {
        /* implementation */
    }
}
