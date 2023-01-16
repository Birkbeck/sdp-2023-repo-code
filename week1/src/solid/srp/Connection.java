package solid.srp;

public interface Connection {
    void dial(String pno);

    void hangup();
}