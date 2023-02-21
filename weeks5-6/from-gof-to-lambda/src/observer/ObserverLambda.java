package observer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public final class ObserverLambda {

    public static void main(String... args) {
        var observable = new Observable();
        observable.register("key1", System.out::println);
        observable.register("key2", System.out::println);

        observable.sendEvent("Hello World!");
    }

    public static final class Observable {
        private final Map<Object, Consumer<Object>> listeners =
            new ConcurrentHashMap<>();

        public void register(Object key, Consumer<Object> listener) {
            listeners.put(key, listener);
        }

        public void unregister(Object key) {
            listeners.remove(key);
        }

        public void sendEvent(Object event) {
            listeners.values().forEach(listener -> listener.accept(event));
        }
    }
}
