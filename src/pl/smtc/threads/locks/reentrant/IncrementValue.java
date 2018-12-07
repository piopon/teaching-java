package pl.smtc.threads.locks.reentrant;

public class IncrementValue {
    private int startValue;

    public IncrementValue() {
        this.startValue = 0;
    }

    public void increment(int times) {
        for (int i = 0; i < times; i++) {
            startValue++;
        }
    }

    public int getValue() {
        return startValue;
    }
}
