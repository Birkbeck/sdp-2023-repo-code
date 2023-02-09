package helloworld;

public interface MessageRenderer {

    void render();

    // autowiring will deal with this:
    // public void setMessageProvider(MessageProvider provider);
}
