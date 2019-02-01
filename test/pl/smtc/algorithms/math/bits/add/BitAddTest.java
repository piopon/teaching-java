package pl.smtc.algorithms.math.bits.add;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BitAddTest extends BaseTestInOut {
    BitAdd bitAdd;

    @Override
    protected void setUp() {
        bitAdd = new BitAdd();
    }

    @Test
    void execute() {
        simulateUserInput("10 3" + System.lineSeparator());
        bitAdd.execute();
        String output = getOutput();
        assertTrue(output.contains("RESULT: 10 + 3 = 13"));
    }

    @Test
    void getName() {
        assertEquals("Bit add", bitAdd.getName());
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @MethodSource("bitAddTestData")
    void add(int first, int second, int result) {
        assertEquals(result, bitAdd.add(first, second));
    }

    private static Stream<Arguments> bitAddTestData() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(-1, 10, 9),
                Arguments.of(3, -1, 2),
                Arguments.of(-5, -1, -6),
                Arguments.of(16, 32, 48),
                Arguments.of(1234, -1000, 234),
                Arguments.of(-65307, 7, -65300));
    }

}