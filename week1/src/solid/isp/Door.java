package solid.isp;

public interface Door extends TimerClient {
    void lock();

    void unlock();

    boolean isOpen();
}