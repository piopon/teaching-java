package pl.smtc.threads.issues.race;

public class Iterate {
    private int increment;
    private int endValue;

    public Iterate(int endValue) {
        this.endValue = endValue;
    }

    public void iterate(String iterateTitle) {
        System.out.println(iterateTitle + " -> START");
        for (increment = 1; increment <= endValue; increment++) {
            System.out.println(iterateTitle + " -> counter: " + increment);
        }
        System.out.println(iterateTitle + " -> STOP");
    }
}
