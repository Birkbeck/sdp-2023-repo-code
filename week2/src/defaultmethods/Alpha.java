package defaultmethods;

public interface Alpha {
    default void reset() {
        System.out.println("Alpha.reset");
    }
}
