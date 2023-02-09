package helloworld;

public class StandardOutMessageRenderer implements MessageRenderer {

    // Dependency Inversion: this Renderer does not depend on any concrete MessageProvider
    // but depends on the MessageProvider interface instead

    private MessageProvider messageProvider;

    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class: " + getClass().getName());
        }

        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }
}