package pl.smtc.patterns.behavioral.template.specialization;

import pl.smtc.patterns.behavioral.template.generalization.MediaDiscReader;

public class BluRayReader extends MediaDiscReader {
    @Override
    protected void spin() {
        System.out.println("Spinning disc with BluRay speed: 4X.");
    }

    @Override
    protected void read() {
        System.out.println("Turning 405nm laser on. Reading data from BluRay disc.");
    }

    @Override
    protected void output() {
        System.out.println("Playing HD movie from BluRay disc.");
    }
}
