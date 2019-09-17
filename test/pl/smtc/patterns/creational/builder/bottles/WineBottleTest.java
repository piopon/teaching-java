package pl.smtc.patterns.creational.builder.bottles;

import org.junit.jupiter.api.Test;
import pl.smtc.patterns.creational.builder.support.ClosureType;
import pl.smtc.patterns.creational.builder.support.MaterialType;

import static org.junit.jupiter.api.Assertions.*;

class WineBottleTest {
    private final static String LABEL = "";
    private final static double CAPACITY = 1.0;
    private final static int PUNT = 2;
    private final static MaterialType MATERIAL = MaterialType.GLASS_WHITE;
    private final static ClosureType CLOSURE = ClosureType.CROWN;
    private WineBottle bottle = new WineBottle(CAPACITY, MATERIAL, CLOSURE, LABEL, PUNT);

    @Test
    void toStringShouldReturnCorrectBottleString() {
        String materialStr = MATERIAL.toString().toLowerCase().replace("_", " ");
        String closureStr = CLOSURE.toString().toLowerCase();
        String bottleShape = materialStr + " with " + closureStr + " closure and " + PUNT + "cm punt";
        assertEquals(LABEL + " bottle (" + CAPACITY + "l) - " + bottleShape, bottle.toString());
    }
}