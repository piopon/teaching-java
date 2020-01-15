package pl.smtc.patterns.creational.factory.abstrakt.support;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;
import pl.smtc.patterns.creational.factory.abstrakt.product.lamp.CeilingLamp;
import pl.smtc.patterns.creational.factory.abstrakt.product.lamp.Lamp;
import pl.smtc.patterns.creational.factory.abstrakt.product.lamp.WallLamp;

import static org.junit.jupiter.api.Assertions.*;

class ShippingListTest extends BaseTestOut {
    private static final Lamp TEST_LAMP = new CeilingLamp("Red");
    private static final ShippingItem TEST_ITEM = new ShippingItem(TEST_LAMP, 10, "TestFactory");
    private ShippingList testList;

    @Override
    protected void setUp() {
        testList = new ShippingList();
        testList.addItem(TEST_ITEM);
    }

    @Test
    void addItemShouldAddInputtedItemToList() {
        assertEquals(1, testList.list.size());
        ShippingItem newItem = new ShippingItem(new WallLamp("Blue"), 20, "OtherFactory");
        testList.addItem(newItem);
        assertEquals(2, testList.list.size());
        assertTrue(testList.list.contains(TEST_ITEM));
        assertTrue(testList.list.contains(newItem));
    }

    @Test
    void printListShouldOutputShippingList() {
        testList.printList();
        String output = getOutput();
        assertTrue(output.contains("Created shipping list has: 1 elements."));
        assertTrue(output.contains("  1) " + TEST_ITEM.getDescription()));
    }

    @Test
    void testItemShouldTriggerTestProcedureForCorrectInput() {
        testList.testItem(1);
        String output = getOutput();
        assertTrue(output.contains("Error: no mounting elements equipped with lamp."));
        assertTrue(output.contains("************"));
        assertTrue(output.contains("CEILING LAMP - POWER ON"));
        assertTrue(output.contains("Error: no light source equipped."));
        assertTrue(output.contains("************"));
        assertTrue(output.contains("CEILING LAMP - POWER OFF"));
        assertTrue(output.contains("Error: no light source equipped."));
    }

    @Test
    void testItemShouldReturnErrorMessageForIncorrectInput() {
        testList.testItem(0);
        String output = getOutput();
        assertTrue(output.contains("Specified number [0] is outside list."));
    }

    @Test
    void sizeShouldReturnShippingListItemsCount() {
        assertEquals(1, testList.size());
    }
}