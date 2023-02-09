package helloworld;

import org.springframework.beans.factory.annotation.Autowired;

public class StandardOutMessageRenderer implements MessageRenderer {

    @Autowired
    private final MessageProvider messageProvider = null;

    @Override
    public void render() {
        System.out.println(messageProvider.getMessage());
    }
}