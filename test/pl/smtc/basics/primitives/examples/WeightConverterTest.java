package pl.smtc.basics.primitives.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WeightConverterTest extends BaseTestInOut {
    private WeightConverter weightConverter;

    @Override
    protected void setUp() {
        weightConverter = new WeightConverter();
    }

    @ParameterizedTest(name = "{0}lb = {1}kg, {0}kg = {2}lb")
    @MethodSource("weightConverterData")
    void executeShouldInvokeWeightConverterExample(String input, String kilograms, String pounds) {
        simulateUserInput(input);
        weightConverter.execute();
        String output = getOutput();
        assertTrue(output.contains(input + "lb = " + kilograms + "kg"));
        assertTrue(output.contains(input + "kg = " + pounds + "lb"));
    }

    private static Stream<Arguments> weightConverterData() {
        return Stream.of(
                Arguments.of("-999.99", "-453.5876940777", "-2204.6012560664894"),
                Arguments.of("-10.39", "-4.7128232697", "-22.906036110891936"),
                Arguments.of("0.0", "0.0", "0.0"),
                Arguments.of("1.0", "0.45359223", "2.2046233022995128"),
                Arguments.of("2.3", "1.043262129", "5.070633595288879"),
                Arguments.of("3.7", "1.678291251", "8.157106218508197"),
                Arguments.of("7.0", "3.17514561", "15.432363116096589"),
                Arguments.of("16.757", "7.60084499811", "36.94287267663294"),
                Arguments.of("77.23", "35.0309279229", "170.26305763659136"),
                Arguments.of("100.123", "45.41501484429", "220.7334988961341"),
                Arguments.of("9999.123", "4535.52449961429", "22044.29956835901"),
                Arguments.of("100001.987", "45360.124287761006", "220466.71081645292"));
    }

    @Test
    void getNameShouldReturnWeightConverterString() {
        assertEquals("Weight converter", weightConverter.getName());
    }
}