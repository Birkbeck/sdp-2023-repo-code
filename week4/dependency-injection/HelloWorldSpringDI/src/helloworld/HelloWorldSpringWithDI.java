package helloworld;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

public final class HelloWorldSpringWithDI {

    public static void main(String... args) throws IOException {
        // get the bean factory
        var factory = getBeanFactory();

        var mr = (MessageRenderer) factory.getBean("renderer");
        // No need to create a MessageProvider and set the messageProvider property
        // of the MessageRenderer bean in the code - Spring does that instead
        // on the fly: see
        //     renderer.messageProvider(ref)=provider
        // in the beans file in the resources folder. So, the dependency is "injected".
        mr.render();
    }

    private static BeanFactory getBeanFactory() throws IOException {
        // get the bean factory
        var factory = new DefaultListableBeanFactory();
        // create a definition reader
        var rdr = new PropertiesBeanDefinitionReader(factory);

        // load the configuration options
        var props = new Properties();
        try (var fis = HelloWorldSpringWithDI.class.getResourceAsStream("/beans")) {
            props.load(fis);
        }

        rdr.registerBeanDefinitions(props);
        return factory;
    }
}
