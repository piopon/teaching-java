package pl.smtc.patterns.structural.decorator;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;
import pl.smtc.patterns.structural.decorator.components.Ford;
import pl.smtc.patterns.structural.decorator.decorators.GPS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DecoratorPatternTest extends BaseTestInOut {
    private DecoratorPattern decoratorPattern;

    @Override
    protected void setUp() {
        decoratorPattern = new DecoratorPattern();
    }

    @Test
    void executeShouldInvokeDecoratorPatternExample() {
        simulateCommaInput("Ford Focus, GPS, Sound system, Heated seats, END");
        decoratorPattern.execute();
        String output = getOutput();
        assertTrue(output.contains("Added option: GPS"));
        assertTrue(output.contains("Added option: Sound system"));
        assertTrue(output.contains("Added option: Heated seats"));
        assertTrue(output.contains("- SELECTED:   Ford Focus + GPS + SOUND SYSTEM + HEATED SEATS"));
        assertTrue(output.contains("- TOTAL COST: 78650.0"));
    }

    @Test
    void executeShouldShowCarNotInStockIfBadCarNameInputted() {
        simulateUserInput("Ferrari");
        decoratorPattern.execute();
        assertTrue(getOutput().contains("Ferrari - not in stock."));
    }

    @Test
    void executeShouldShowOptionNotInStockIfBadOptionInputted() {
        simulateCommaInput("Ford Mustang, Bluetooth");
        decoratorPattern.execute();
        assertTrue(getOutput().contains("Bluetooth - not in stock."));
    }

    @Test
    void getNameShouldReturnDecoratorPatternString() {
        assertEquals("Decorator pattern", decoratorPattern.getName());
    }
}