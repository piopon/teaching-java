package pl.smtc.patterns.behavioral.template.specialization;

import pl.smtc.patterns.behavioral.template.generalization.MediaDiscReader;

public class DvdReader extends MediaDiscReader {
    @Override
    protected void read() {
        System.out.println("Turning 650nm laser on. Reading data from DVD-ROM.");
    }

    @Override
    protected void output() {
        System.out.println("Playing movie from DVD-ROM.");
    }
}
