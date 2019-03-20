package pl.smtc.patterns.creational.AbstractFactory;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import static org.junit.jupiter.api.Assertions.*;

class AbstractFactoryTest extends BaseTestInOut {
    private AbstractFactory abstractFactory;

    @Override
    protected void setUp() {
        abstractFactory = new AbstractFactory();
    }

    @Test
    void execute() {
        simulateCommaInput("1, STREET, ANCHORS, HMI, 100, 0, 0, 1, Q");
        abstractFactory.execute();
        String output = getOutput();
        assertTrue(output.contains("+--------------------------------------------"));
        assertTrue(output.contains("| SHIPPING LIST CREATOR"));
        assertTrue(output.contains("| current factory: OUTDOOR LAMP FACTORY"));
        assertTrue(output.contains("| current list size: 1"));
        assertTrue(output.contains("Created shipping list has: 1 elements."));
        assertTrue(output.contains("1) 100x SILVER STREET LAMP [IP67] - "));
        assertTrue(output.contains("mount with: 8 ANCHORS, "));
        assertTrue(output.contains("light source: HMI with TRANSPARENT glass - 3500[K]"));
        assertTrue(output.contains(" [from: OUTDOOR LAMP FACTORY]"));
        assertTrue(output.contains("Which item number to test? [P = print list, Q = quit]"));
        assertTrue(output.contains("Specified number [0] is outside list."));
        assertTrue(output.contains("STREET LAMP - MOUNT INSTRUCTIONS"));
        assertTrue(output.contains("STREET LAMP - POWER ON"));
        assertTrue(output.contains("STREET LAMP - POWER OFF"));
    }

    @Test
    void getName() {
        assertEquals("Abstract factory", abstractFactory.getName());
    }
}