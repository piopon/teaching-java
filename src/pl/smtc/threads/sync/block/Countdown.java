package pl.smtc.threads.sync.block;

public class Countdown {
    private int decr;
    private int startValue;

    public Countdown(int startValue) {
        this.startValue = startValue;
    }

    public void countdown(String countdownTitle) {
        System.out.println(countdownTitle + " -> START");
        synchronized (this) {
            for (decr = startValue; decr >= 0; decr--) {
                System.out.println(countdownTitle + " -> countdown: " + decr);
            }
        }
        System.out.println(countdownTitle + " -> STOP");
    }
}
