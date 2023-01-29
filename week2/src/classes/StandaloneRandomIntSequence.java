package classes;

import java.util.Random;

public class StandaloneRandomIntSequence implements IntSequence {

    private final int low;
    private final int high;
    private final Random generator;

    public StandaloneRandomIntSequence(int low, int high, Random generator) {
        this.low = low;
        this.high = high;
        this.generator = generator;
    }

    @Override
    public int next() {
        return low + generator.nextInt(high - low + 1);
    }

    @Override
    public boolean hasNext() {
        return true;
    }
}
