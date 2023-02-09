package helloworld;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public final class MessageSupportFactory {

    private static final MessageSupportFactory instance = new MessageSupportFactory();

    private MessageRenderer renderer;
    private MessageProvider provider;

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageRenderer getMessageRenderer() {
        return renderer;
    }

    public MessageProvider getMessageProvider() {
        return provider;
    }

    private MessageSupportFactory() {
        Properties props = new Properties();

        try {
            // Here, using var is perfectly fine - we are not interested in the exact type
            // (which the compiler infers to be InputStream, from the declaration of getResourceAsStream)
            // MessageSupportFactory.class is a *class literal* (see https://docs.oracle.com/javase/specs/jls/se19/html/jls-15.html#jls-15.8.2)
            try (var fis = MessageSupportFactory.class.getResourceAsStream("/beans.properties")) { //
                props.load(fis);
            }

            // get the implementation classes
            String rendererClass = props.getProperty("renderer.class");
            renderer = (MessageRenderer) newInstanceOf(rendererClass);

            String providerClass = props.getProperty("provider.class");
            provider = (MessageProvider) newInstanceOf(providerClass);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private Object newInstanceOf(String className) throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> classObject = Class.forName(className);
        Constructor<?> constructor = classObject.getDeclaredConstructor();
        return constructor.newInstance();
    }

    private <T> T newTypeSafeInstanceOf(String className, Class<T> klass) throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // just an example of using something different from ? inside <> after Class/Constructor
        Class<? extends T> classObject = Class.forName(className).asSubclass(klass);
        Constructor<? extends T> constructor = classObject.getDeclaredConstructor();
        return constructor.newInstance();
    }

}
