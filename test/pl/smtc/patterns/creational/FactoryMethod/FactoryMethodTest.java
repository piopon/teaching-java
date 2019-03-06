package pl.smtc.patterns.creational.FactoryMethod;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;
import pl.smtc.patterns.creational.FactoryMethod.factory.ILampFactory;
import pl.smtc.patterns.creational.FactoryMethod.factory.IndoorLampFactory;
import pl.smtc.patterns.creational.FactoryMethod.factory.Lamps;
import pl.smtc.patterns.creational.FactoryMethod.product.CeilingLamp;
import pl.smtc.patterns.creational.FactoryMethod.product.Lamp;
import pl.smtc.patterns.creational.FactoryMethod.product.WallLamp;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FactoryMethodTest extends BaseTestInOut {
    private FactoryMethod factoryMethod;

    @Override
    protected void setUp() {
        factoryMethod = new FactoryMethod();
    }

    @Test
    void executeShouldInvokeFactoryMethodExample() {
        simulateCommaInput("OUT, STREET, E, IN, DESKTOP, E, Q");
        factoryMethod.execute();
        String output = getOutput();
        assertTrue(output.contains("Order (total 2 lamps)"));
        assertTrue(output.contains("---  1  ---------"));
        assertTrue(output.contains("BLACK STREET LAMP - mount: ANCHORS, power: 230V, protect: IP67"));
        assertTrue(output.contains("STREET LAMP: POWER ON = WARMING UP..."));
        assertTrue(output.contains("STREET LAMP: POWER OFF = COOLING DOWN..."));
        assertTrue(output.contains("---  2  ---------"));
        assertTrue(output.contains("DESKTOP LAMP - mount: STAND, power: 100V-230V, protect: IP20"));
        assertTrue(output.contains("DESKTOP LAMP: WARM 2700K LED -> POWER ON"));
        assertTrue(output.contains("DESKTOP LAMP: WARM 2700K LED -> POWER OFF"));
    }

    @Test
    void getNameShouldReturnFactoryMethodString() {
        assertEquals("Factory method", factoryMethod.getName());
    }

    @Test
    void chooseFactoryShouldReturnLampFactoryIfCorrectInput() {
        simulateUserInput("IN");
        ILampFactory factory = factoryMethod.chooseFactory(new Scanner(System.in));
        assertEquals("INDOOR LAMP FACTORY", factory.getName());
    }

    @Test
    void chooseFactoryShouldReturnNullIfIncorrectInputOrQ() {
        simulateUserInput("RANDOM");
        ILampFactory factory = factoryMethod.chooseFactory(new Scanner(System.in));
        assertNull(factory);
    }

    @Test
    void createOrderShouldReturnLampsOrderIfInputOk() {
        simulateCommaInput("CEILING, WALL, Q");
        List<Lamp> result = factoryMethod.createOrder(new Scanner(System.in), createTestFactory());
        assertEquals(2, result.size());
        assertEquals(Lamps.CEILING, result.get(0).getType());
        assertEquals(Lamps.WALL, result.get(1).getType());
    }

    @Test
    void createOrderShouldOutputErrorMessageIfIncorrectInput() {
        simulateUserInput("TEST");
        List<Lamp> result = factoryMethod.createOrder(new Scanner(System.in), createTestFactory());
        assertEquals(0, result.size());
        assertTrue(getOutput().contains("Error! Cannot create lamp of specified type..."));
        assertFalse(factoryMethod.endOrder);
    }

    @Test
    void createOrderShouldSetEndOrderFlagToTrueIfNullFactoryInputted() {
        simulateCommaInput("TEST");
        List<Lamp> result = factoryMethod.createOrder(new Scanner(System.in), null);
        assertEquals(0, result.size());
        assertTrue(factoryMethod.endOrder);
    }

    private ILampFactory createTestFactory() {
        ILampFactory testFactory = new IndoorLampFactory();
        testFactory.registerLamp(new CeilingLamp("DOWELS", "230V"));
        testFactory.registerLamp(new WallLamp("SCREWS", "230V"));

        return testFactory;
    }

}