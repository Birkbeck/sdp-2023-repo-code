package solid.srp;

public interface DataChannel {
    void send(char c);

    char receive();
}