package pl.smtc.patterns.creational.builder;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class BuilderPatternTest extends BaseTestOut {
    private BuilderPattern builderPattern;

    @Override
    protected void setUp() {
        builderPattern = new BuilderPattern();
    }

    @Test
    void executeShouldInvokeBuilderPatternExample() {
        builderPattern.execute();
        String output = getOutput();
        assertTrue(output.contains("WINE: Chardonnay bottle (0.75l) - glass brown with cork closure and 10cm punt"));
        assertTrue(output.contains("WINE: Sparkling Wine bottle (1.0l) - glass blue with cork closure and 5cm punt"));
        assertTrue(output.contains("BEVERAGE: Beer bottle (0.5l) - glass green with fliptop closure"));
        assertTrue(output.contains("BEVERAGE: Coca-Cola bottle (0.33l) - glass white with crown closure"));
        assertTrue(output.contains("BEVERAGE: Soda bottle (0.5l) - plastic with screw closure"));
    }

    @Test
    void getNameShouldReturnBuilderPatternString() {
        assertEquals("Builder Pattern", builderPattern.getName());
    }
}