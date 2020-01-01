package pl.smtc.basics.flow.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.smtc.base.BaseTestInOut;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DaysInMonthTest extends BaseTestInOut {
    private DaysInMonth daysInMonth;

    @Override
    protected void setUp() {
        daysInMonth = new DaysInMonth();
    }

    @Test
    void executeShouldInvokeDaysInMonthExample() {
        simulateUserInput("12/2018");
        daysInMonth.execute();
        String output = getOutput();
        assertTrue(output.contains("Days in 12/2018: 31"));
    }

    @Test
    void getNameShouldReturnDaysInMonthString() {
        assertEquals("Days in month", daysInMonth.getName());
    }

    @Test
    void getDaysInMonthShouldThrowOnBadMonth() {
        assertThrows(NumberFormatException.class, () -> daysInMonth.getDaysInMonth(-1,1000));
        assertThrows(NumberFormatException.class, () -> daysInMonth.getDaysInMonth(15,1000));
    }

    @Test
    void getDaysInMonthShouldThrowOnBadYear() {
        assertThrows(NumberFormatException.class, () -> daysInMonth.getDaysInMonth(1,-1000));
        assertThrows(NumberFormatException.class, () -> daysInMonth.getDaysInMonth(1,10000));
    }

    @ParameterizedTest(name = "Month {0}/{1} = {2} days")
    @MethodSource("daysInMonthTestData")
    void getDaysInMonthShouldReturnCorrectOutputOnGoodInput(int month, int year, int days) {
        assertEquals(days, daysInMonth.getDaysInMonth(month, year));
    }

    private static Stream<Arguments> daysInMonthTestData() {
        return Stream.of(
                Arguments.of(1, 1000, 31),
                Arguments.of(4, 1200, 30),
                Arguments.of(7, 1613, 31),
                Arguments.of(4, 1914, 30),
                Arguments.of(2, 1950, 28),
                Arguments.of(10, 1987, 31),
                Arguments.of(6, 1991, 30),
                Arguments.of(5, 1999, 31),
                Arguments.of(11, 2001, 30),
                Arguments.of(3, 2012, 31),
                Arguments.of(9, 2015, 30),
                Arguments.of(2, 2016, 29),
                Arguments.of(2, 2019, 28),
                Arguments.of(7, 2019, 31),
                Arguments.of(12, 2019, 31),
                Arguments.of(2, 2020, 29));
    }
}