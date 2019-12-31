package pl.smtc.basics.flow.examples;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

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
        assertTrue(output.contains("First and last digits sum = 7"));
    }

    @Test
    void getNameShouldReturnDaysInMonthString() {
        assertEquals("Days in month", daysInMonth.getName());
    }

    @Test
    void getDaysInMonth() {

    }
}