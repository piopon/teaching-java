package pl.smtc.patterns.behavioral.template.specialization;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class DvdReaderTest extends BaseTestOut {
    private static final String TEST_DISC = "test disc";
    private DvdReader testReader;

    @Override
    protected void setUp() {
        testReader = new DvdReader();
    }

    @Test
    void readShouldInvokeReaderReadMethodAlgorithm() {
        testReader.read();
        String output = getOutput();
        assertTrue(output.contains("Turning 650nm laser on. Reading data from DVD-ROM."));
    }

    @Test
    void outputShouldInvokeReaderOutputMethodAlgorithm() {
        testReader.output();
        String output = getOutput();
        assertTrue(output.contains("Playing movie from DVD-ROM."));
    }

    @Test
    void playShouldInvokeReaderPlayMethodAlgorithm() {
        testReader.play(TEST_DISC);
        String output = getOutput();
        assertTrue(output.contains("------------------"));
        assertTrue(output.contains("Inserted new disc: " + TEST_DISC));
        assertTrue(output.contains("Spinning disc with default speed: 8X."));
        assertTrue(output.contains("Turning 650nm laser on. Reading data from DVD-ROM."));
        assertTrue(output.contains("Playing movie from DVD-ROM."));
    }
}