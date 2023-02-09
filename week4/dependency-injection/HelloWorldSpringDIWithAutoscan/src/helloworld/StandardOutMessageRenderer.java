package helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("renderer")   // This is the same as @Component(value="renderer")
public class StandardOutMessageRenderer implements MessageRenderer {

    @Autowired
    private final MessageProvider messageProvider = null;

    @Override
    public void render() {
        System.out.println(messageProvider.getMessage());
    }
}