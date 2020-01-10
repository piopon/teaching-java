package pl.smtc.patterns.behavioral.template.specialization;

import pl.smtc.patterns.behavioral.template.generalization.MediaDiscReader;

public class CdReader extends MediaDiscReader {
    @Override
    protected void spin() {
        System.out.println("Spinning disc with CD-ROM speed: 48X.");
    }

    @Override
    protected void read() {
        System.out.println("Turning 780nm laser on. Reading data from CD-ROM.");
    }

    @Override
    protected void output() {
        System.out.println("Playing music from CD-ROM.");
    }
}
