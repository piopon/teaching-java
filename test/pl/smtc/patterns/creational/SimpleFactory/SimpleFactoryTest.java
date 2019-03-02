package pl.smtc.patterns.creational.SimpleFactory;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;
import pl.smtc.patterns.creational.SimpleFactory.factory.LampFactory;
import pl.smtc.patterns.creational.SimpleFactory.factory.Lamps;
import pl.smtc.patterns.creational.SimpleFactory.product.ILamp;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SimpleFactoryTest extends BaseTestInOut {
    SimpleFactory simpleFactory;

    @Override
    protected void setUp() {
        simpleFactory = new SimpleFactory();
        LampFactory.clearRegisteredLamps();
        LampFactory.registerLamp(createLamp(Lamps.CEILING, "Ceiling lamp description"));
        LampFactory.registerLamp(createLamp(Lamps.WALL, "Wall lamp description"));
    }

    @Test
    void executeShouldInvokeSimpleFactoryExample() {
        simulateCommaInput("CEILING, WALL, Q");
        simpleFactory.execute();
        String output = getOutput();
        assertTrue(output.contains("TOTAL 2 LAMPS TO BE MANUFACTURED"));
        assertTrue(output.contains("* Ceiling lamp description"));
        assertTrue(output.contains("* Wall lamp description"));
    }

    @Test
    void executeShouldReturnErrorMessageIfUnknownLampTypeInputted() {
        simulateCommaInput("LAMP, Q");
        simpleFactory.execute();
        String output = getOutput();
        assertTrue(output.contains("Error! Cannot create lamp of specified type."));
    }

    @Test
    void getNameShouldReturnSimpleFactoryString() {
        assertEquals("Simple factory", simpleFactory.getName());
    }

    @Test
    void createLampOrderShouldReturnCorrectLampList() {
        simulateCommaInput("CEILING, WALL, Q");
        List<ILamp> result = simpleFactory.createLampOrder(new Scanner(System.in));
        assertEquals(2, result.size());
        assertEquals(Lamps.CEILING, result.get(0).getType());
        assertEquals("Ceiling lamp description", result.get(0).getDescription());
        assertEquals(Lamps.WALL, result.get(1).getType());
        assertEquals("Wall lamp description", result.get(1).getDescription());
    }

    @Test
    void createLampOrderShouldReturnOnlyCorrectLampsIfBadUserInput() {
        simulateCommaInput("WALL, LAMP, CEILING, Q");
        List<ILamp> result = simpleFactory.createLampOrder(new Scanner(System.in));
        assertEquals(1, result.size());
        assertEquals(Lamps.WALL, result.get(0).getType());
        assertEquals("Wall lamp description", result.get(0).getDescription());
    }

    ILamp createLamp(Lamps type, String description) {
        ILamp mockLamp = mock(ILamp.class);
        when(mockLamp.getType()).thenReturn(type);
        when(mockLamp.getDescription()).thenReturn(description);

        return mockLamp;
    }
}