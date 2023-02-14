package structural.adapter.current;

public interface SocketAdapter {
    Volt get240Volt();

    Volt get12Volt();

    Volt get3Volt();
}