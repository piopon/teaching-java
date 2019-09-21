package pl.smtc.patterns.creational.factory.AbstractFactory.support;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestInOut;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ShippingListCreatorTest extends BaseTestInOut {
    private ShippingListCreator testCreator;

    @Override
    protected void setUp() {
        testCreator = new ShippingListCreator(new FactoriesDataProvider());
    }

    @Test
    void createShouldOpenShippingListMenuAndAddUseDataFromUserInput() {
        simulateCommaInput("2, IN, 1, WALL, DOWELS, LED, 10, 0");
        testCreator.create(new Scanner(System.in));
        String output = getOutput();
        assertTrue(output.contains("+--------------------------------------------"));
        assertTrue(output.contains("| SHIPPING LIST CREATOR"));
        assertTrue(output.contains("+--------------------------------------------"));
        assertTrue(output.contains("| current factory: OUTDOOR LAMP FACTORY"));
        assertTrue(output.contains("| current list size: 0"));
        assertTrue(output.contains("+--------------------------------------------"));
        assertTrue(output.contains("| options: 0=quit, 1=next item, 2=change factory"));
        assertTrue(output.contains("+--------------------------------------------"));
        assertTrue(output.contains("> action:"));
        assertTrue(output.contains("Select factory [INDOOR LAMP FACTORY, OUTDOOR LAMP FACTORY]:"));
        assertTrue(output.contains("[OK] Factory selected."));
        assertTrue(output.contains("Select lamp "));
        assertTrue(output.contains("Select mounting "));
        assertTrue(output.contains("Select source "));
        assertTrue(output.contains("How many lamps to ship?"));
        assertTrue(output.contains("[OK] Item added to list."));
        assertTrue(output.contains("| current list size: 1"));
    }
}