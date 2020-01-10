package pl.smtc.patterns.behavioral.template.specialization;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class BluRayReaderTest extends BaseTestOut {
    private static final String TEST_DISC = "test disc";
    private BluRayReader testReader;

    @Override
    protected void setUp() {
        testReader = new BluRayReader();
    }

    @Test
    void spinShouldInvokeReaderSpinMethodAlgorithm() {
        testReader.spin();
        String output = getOutput();
        assertTrue(output.contains("Spinning disc with BluRay speed: 4X."));
    }

    @Test
    void readShouldInvokeReaderReadMethodAlgorithm() {
        testReader.read();
        String output = getOutput();
        assertTrue(output.contains("Turning 405nm laser on. Reading data from BluRay disc."));
    }

    @Test
    void outputShouldInvokeReaderOutputMethodAlgorithm() {
        testReader.output();
        String output = getOutput();
        assertTrue(output.contains("Playing HD movie from BluRay disc."));
    }

    @Test
    void playShouldInvokeReaderPlayMethodAlgorithm() {
        testReader.play(TEST_DISC);
        String output = getOutput();
        assertTrue(output.contains("------------------"));
        assertTrue(output.contains("Inserted new disc: " + TEST_DISC));
        assertTrue(output.contains("Spinning disc with BluRay speed: 4X."));
        assertTrue(output.contains("Turning 405nm laser on. Reading data from BluRay disc."));
        assertTrue(output.contains("Playing HD movie from BluRay disc."));
    }
}