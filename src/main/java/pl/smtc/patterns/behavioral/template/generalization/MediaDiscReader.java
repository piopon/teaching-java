package pl.smtc.patterns.behavioral.template.generalization;

public abstract class MediaDiscReader {

    public final void play(String discName) {
        System.out.println("------------------");
        System.out.println("Inserted new disc: " + discName);
        spin();
        read();
        output();
    }

    protected void spin() {
        System.out.println("Spinning disc with default speed: 8X.");
    }

    protected abstract void read();

    protected abstract void output();
}
