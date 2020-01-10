package pl.smtc.patterns.creational.builder.director;

import org.junit.jupiter.api.Test;
import pl.smtc.patterns.creational.builder.builders.BeverageBottleBuilder;
import pl.smtc.patterns.creational.builder.builders.WineBottleBuilder;
import pl.smtc.patterns.creational.builder.support.ClosureType;
import pl.smtc.patterns.creational.builder.support.MaterialType;

import static org.junit.jupiter.api.Assertions.*;

class ProductionDirectorTest {
    private ProductionDirector director = new ProductionDirector();
    private WineBottleBuilder wineBuilder = new WineBottleBuilder();
    private BeverageBottleBuilder beverageBuilder = new BeverageBottleBuilder();

    @Test
    void createSparklingWineBottleShouldReturnCorrectBottleType() {
        director.createSparklingWineBottle(wineBuilder);
        String expected = getExpectedWine(1.0, MaterialType.GLASS_BLUE, ClosureType.CORK, "Sparkling Wine", 5);
        assertEquals(expected, wineBuilder.getResult().toString());
    }

    @Test
    void createChardonnayBottleShouldReturnCorrectBottleType() {
        director.createChardonnayBottle(wineBuilder);
        String expected = getExpectedWine(0.75, MaterialType.GLASS_BROWN, ClosureType.CORK, "Chardonnay", 10);
        assertEquals(expected, wineBuilder.getResult().toString());
    }

    @Test
    void createCocaColaBottleShouldReturnCorrectBottleType() {
        director.createCocaColaBottle(beverageBuilder);
        String expected = getExpectedBeverage(0.33, MaterialType.GLASS_WHITE, ClosureType.CROWN, "Coca-Cola");
        assertEquals(expected, beverageBuilder.getResult().toString());
    }

    @Test
    void createSodaBottleShouldReturnCorrectBottleType() {
        director.createSodaBottle(beverageBuilder);
        String expected = getExpectedBeverage(0.5, MaterialType.PLASTIC, ClosureType.SCREW, "Soda");
        assertEquals(expected, beverageBuilder.getResult().toString());
    }

    @Test
    void createBeerBottleShouldReturnCorrectBottleType() {
        director.createBeerBottle(beverageBuilder);
        String expected = getExpectedBeverage(0.5, MaterialType.GLASS_GREEN, ClosureType.FLIP_TOP, "Beer");
        assertEquals(expected, beverageBuilder.getResult().toString());
    }

    private String getExpectedWine(double cap, MaterialType mat, ClosureType close, String label, int punt) {
        String materialStr = mat.toString().toLowerCase().replace("_", " ");
        String closureStr = close.toString().toLowerCase().replace("_", " ");
        String bottleShape = materialStr + " with " + closureStr + " closure and " + punt + "cm punt";
        return label + " bottle (" + cap + "l) - " + bottleShape;
    }

    private String getExpectedBeverage(double cap, MaterialType mat, ClosureType close, String label) {
        String materialStr = mat.toString().toLowerCase().replace("_", " ");
        String closureStr = close.toString().toLowerCase().replace("_", " ");
        String bottleShape = materialStr + " with " + closureStr + " closure";
        return label + " bottle (" + cap + "l) - " + bottleShape;
    }
}