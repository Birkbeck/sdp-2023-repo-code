package solid.refactored.srp;

public interface DataChannel {
    void send(char c);

    char receive();
}