package capture;

import java.util.function.Function;

@FunctionalInterface
public interface MyEventProducer {
    <T, R> void listen(Function<T, R> o);
}
