package classes;

import java.util.Random;

public class LocalClassDemo {
    private static final Random generator = new Random();

    public static IntSequence randomIntsWithStandaloneRandomIntSequence(int low, int high) {
        return new StandaloneRandomIntSequence(low, high, generator);
    }

    // low and high are effectively final
    public static IntSequence randomInts(int low, int high) {
        // local and inner classes have direct access to local and instance variables
        // thus saving on boilerplate code present in e.g., StandaloneRandomIntSequence
        // (the boilerplate code in the constructor copies low, high and generator
        // into instance variables of the class)
        class RandomSequence implements IntSequence {
            public int next() {
                return low + generator.nextInt(high - low + 1);
            }

            public boolean hasNext() {
                return true;
            }
        }
        return new RandomSequence();
    }

    public static IntSequence randomIntsAnonymous(int low, int high) {
        return new IntSequence() {
            public int next() {
                return low + generator.nextInt(high - low + 1);
            }

            public boolean hasNext() {
                return true;
            }
        };
    }

    public static void main(String[] args) {
        IntSequence dieTosses = randomInts(1, 6);
        for (int i = 0; i < 10; i++)
            System.out.println(dieTosses.next());
    }
}
