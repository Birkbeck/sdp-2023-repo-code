package observer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ObserverGoF {

    public static void main(String... args) {
        Observable observable = new Observable();
        new Observer1(observable);
        new Observer2(observable);

        observable.sendEvent("Hello World!");
    }

    interface Listener {
        void onEvent(Object event);
    }

    public static final class Observable {
        private final Map<Object, Listener> listeners
            = new ConcurrentHashMap<>();

        public void register(Object key, Listener listener) {
            listeners.put(key, listener);
        }

        public void unregister(Object key) {
            listeners.remove(key);
        }

        public void sendEvent(Object event) {
            for (Listener listener : listeners.values()) {
                listener.onEvent(event);
            }
        }
    }

    public static class Observer1 {
        Observer1(final Observable observable) {
            observable.register(this, new Listener() {
                @Override
                public void onEvent(final Object event) {
                    System.out.println(this.getClass() + ":" + event);
                }
            });
        }
    }

    public static final class Observer2 implements Listener {
        Observer2(final Observable observable) {
            observable.register(this, this);
        }

        @Override
        public void onEvent(final Object event) {
            System.out.println(this.getClass() + ":" + event);
        }
    }
}
