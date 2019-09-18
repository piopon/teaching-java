package pl.smtc.patterns.creational.builder.builders;

import org.junit.jupiter.api.Test;
import pl.smtc.patterns.creational.builder.support.ClosureType;
import pl.smtc.patterns.creational.builder.support.MaterialType;

import static org.junit.jupiter.api.Assertions.*;

class BeverageBottleBuilderTest {
    private final BeverageBottleBuilder builder = new BeverageBottleBuilder();

    @Test
    void setCapacityShouldSetCorrectCapacityValue() {
        builder.setCapacity(5.0);
        assertTrue(builder.getResult().toString().contains("bottle (5.0l)"));
    }

    @Test
    void setMaterialShouldReturnCorrectMaterialValue() {
        builder.setMaterial(MaterialType.GLASS_BLUE);
        assertTrue(builder.getResult().toString().contains("glass blue with "));
    }

    @Test
    void setClosureShouldReturnCorrectClosureType() {
        builder.setClosure(ClosureType.FLIPTOP);
        assertTrue(builder.getResult().toString().contains("with fliptop closure"));
    }

    @Test
    void setClosureShouldThrowOnCorkClosure() {
        String errorMessage = "Beverage bottle cannot have cork closure.";
        assertThrows(IllegalArgumentException.class, () -> builder.setClosure(ClosureType.CORK), errorMessage);
    }

    @Test
    void setLabelShouldSetCorrectLabelValue() {
        builder.setLabel("TEST_LABEL");
        assertTrue(builder.getResult().toString().contains("TEST_LABEL bottle"));
    }

    @Test
    void setPuntHeightShouldAlwaysThrowAnException() {
        String errorMessage = "Beverage bottle does not have a punt.";
        assertThrows(IllegalArgumentException.class, () -> builder.setPuntHeight(10), errorMessage);
    }

    @Test
    void getResultShouldReturnCorrectBottle() {
        final double capacity = 5.0;
        final String label = "TEST_LABEL";
        final MaterialType material = MaterialType.GLASS_BLUE;
        final ClosureType closure = ClosureType.FLIPTOP;

        builder.setLabel(label);
        builder.setCapacity(capacity);
        builder.setMaterial(material);
        builder.setClosure(closure);
        assertEquals(getExpectedResult(capacity, material, closure, label), builder.getResult().toString());
    }

    private String getExpectedResult(double capacity, MaterialType material, ClosureType closure, String label) {
        String materialStr = material.toString().toLowerCase().replace("_", " ");
        String closureStr = closure.toString().toLowerCase();
        String bottleShape = materialStr + " with " + closureStr + " closure";
        return label + " bottle (" + capacity + "l) - " + bottleShape;
    }
}