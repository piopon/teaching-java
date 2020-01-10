package pl.smtc.threads.sync.method;

public class Countdown {
    private int decr;
    private int startValue;

    public Countdown(int startValue) {
        this.startValue = startValue;
    }

    public synchronized void countdown(String countdownTitle) {
        System.out.println(countdownTitle + " -> START");
        for (decr = startValue; decr > 0; decr--) {
            System.out.println(countdownTitle + " -> countdown: " + decr);
        }
        System.out.println(countdownTitle + " -> STOP");
    }
}
