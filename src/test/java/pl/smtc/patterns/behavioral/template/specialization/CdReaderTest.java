package pl.smtc.patterns.behavioral.template.specialization;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class CdReaderTest extends BaseTestOut {
    private static final String TEST_DISC = "test disc";
    private CdReader testReader;

    @Override
    protected void setUp() {
        testReader = new CdReader();
    }

    @Test
    void spinShouldInvokeReaderSpinMethodAlgorithm() {
        testReader.spin();
        String output = getOutput();
        assertTrue(output.contains("Spinning disc with CD-ROM speed: 48X."));
    }

    @Test
    void readShouldInvokeReaderReadMethodAlgorithm() {
        testReader.read();
        String output = getOutput();
        assertTrue(output.contains("Turning 780nm laser on. Reading data from CD-ROM."));
    }

    @Test
    void outputShouldInvokeReaderOutputMethodAlgorithm() {
        testReader.output();
        String output = getOutput();
        assertTrue(output.contains("Playing music from CD-ROM."));
    }

    @Test
    void playShouldInvokeReaderPlayMethodAlgorithm() {
        testReader.play(TEST_DISC);
        String output = getOutput();
        assertTrue(output.contains("------------------"));
        assertTrue(output.contains("Inserted new disc: " + TEST_DISC));
        assertTrue(output.contains("Spinning disc with CD-ROM speed: 48X."));
        assertTrue(output.contains("Turning 780nm laser on. Reading data from CD-ROM."));
        assertTrue(output.contains("Playing music from CD-ROM."));
    }
}