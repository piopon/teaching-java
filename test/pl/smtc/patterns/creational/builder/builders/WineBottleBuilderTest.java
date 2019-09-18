package pl.smtc.patterns.creational.builder.builders;

import org.junit.jupiter.api.Test;
import pl.smtc.patterns.creational.builder.support.ClosureType;
import pl.smtc.patterns.creational.builder.support.MaterialType;

import static org.junit.jupiter.api.Assertions.*;

class WineBottleBuilderTest {
    private WineBottleBuilder builder = new WineBottleBuilder();

    @Test
    void setCapacityShouldSetCorrectCapacityValue() {
        builder.setCapacity(1.75);
        assertTrue(builder.getResult().toString().contains("bottle (1.75l)"));
    }

    @Test
    void setMaterialShouldReturnCorrectMaterialValue() {
        builder.setMaterial(MaterialType.GLASS_BROWN);
        assertTrue(builder.getResult().toString().contains("glass brown with "));
    }

    @Test
    void setClosureShouldReturnCorrectClosureType() {
        builder.setClosure(ClosureType.CORK);
        assertTrue(builder.getResult().toString().contains("with cork closure"));
    }

    @Test
    void setClosureShouldThrowOnSportsClosure() {
        String errorMessage = "Wine bottle cannot have sport closure.";
        assertThrows(IllegalArgumentException.class, () -> builder.setClosure(ClosureType.SPORTS), errorMessage);
    }

    @Test
    void setLabelShouldSetCorrectLabelValue() {
        builder.setLabel("@WINE");
        assertTrue(builder.getResult().toString().contains("@WINE bottle"));
    }

    @Test
    void setPuntHeightShouldSetCorrectPuntValue() {
        builder.setPuntHeight(10);
        assertTrue(builder.getResult().toString().contains("and 10cm punt"));
    }

    @Test
    void getResultShouldReturnCorrectBottle() {
        final double capacity = 5.0;
        final String label = "TEST_LABEL";
        final MaterialType material = MaterialType.GLASS_BLUE;
        final ClosureType closure = ClosureType.FLIPTOP;
        final int punt = 7;

        builder.setLabel(label);
        builder.setCapacity(capacity);
        builder.setMaterial(material);
        builder.setClosure(closure);
        builder.setPuntHeight(punt);
        assertEquals(getExpectedResult(capacity, material, closure, label, punt), builder.getResult().toString());
    }

    private String getExpectedResult(double capacity, MaterialType material, ClosureType closure, String label, int punt) {
        String materialStr = material.toString().toLowerCase().replace("_", " ");
        String closureStr = closure.toString().toLowerCase();
        String bottleShape = materialStr + " with " + closureStr + " closure and " + punt + "cm punt";
        return label + " bottle (" + capacity + "l) - " + bottleShape;
    }
}