package defaultmethods;

public interface Beta {
    default void reset() { System.out.println("Beta.reset");}
}
