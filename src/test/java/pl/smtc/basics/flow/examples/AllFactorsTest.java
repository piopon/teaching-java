package pl.smtc.basics.flow.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AllFactorsTest extends BaseTestInOut {
    private AllFactors allFactors;

    @Override
    protected void setUp() {
        allFactors = new AllFactors();
    }

    @Test
    void executeShouldInvokeAllNumberFactorsExample() {
        simulateUserInput("1236");
        allFactors.execute();
        String output = getOutput();
        assertTrue(output.contains("Factors for number 1236:"));
        assertTrue(output.contains("[1, 2, 3, 4, 6, 12, 103, 206, 309, 412, 618, 1236]"));
    }

    @Test
    void getNameShouldReturnAllNumberFactorsString() {
        assertEquals("All number factors", allFactors.getName());
    }

    @ParameterizedTest(name = "Number {0} factors = {1}")
    @MethodSource("factorsTestData")
    void getAllFactorsShouldReturnCorrectNumberFactors(int number, List<Integer> factors) {
        assertEquals(factors, allFactors.getAllFactors(number));
    }

    private static Stream<Arguments> factorsTestData() {
        return Stream.of(
                Arguments.of(-5, Collections.emptyList()),
                Arguments.of(0, Collections.emptyList()),
                Arguments.of(1, List.of(1)),
                Arguments.of(3, List.of(1, 3)),
                Arguments.of(4, List.of(1, 2, 4)),
                Arguments.of(6, List.of(1, 2, 3, 6)),
                Arguments.of(10, List.of(1, 2, 5, 10)),
                Arguments.of(70, List.of(1, 2, 5, 7, 10, 14, 35, 70)),
                Arguments.of(115, List.of(1, 5, 23, 115)),
                Arguments.of(311, List.of(1, 311)),
                Arguments.of(500, List.of(1, 2, 4, 5, 10, 20, 25, 50, 100, 125, 250, 500)),
                Arguments.of(1000, List.of(1, 2, 4, 5, 8, 10, 20, 25, 40, 50, 100, 125, 200, 250, 500, 1000)),
                Arguments.of(1236, List.of(1, 2, 3, 4, 6, 12, 103, 206, 309, 412, 618, 1236)));
    }
}