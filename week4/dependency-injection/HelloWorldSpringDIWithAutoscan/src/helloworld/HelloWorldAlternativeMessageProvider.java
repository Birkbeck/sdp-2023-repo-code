package helloworld;

import org.springframework.stereotype.Component;

@Component("provider")
public class HelloWorldAlternativeMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello World! --- The alternative message provider with Autoscan!";
    }

}