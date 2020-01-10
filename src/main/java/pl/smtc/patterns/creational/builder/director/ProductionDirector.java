package pl.smtc.patterns.creational.builder.director;

import pl.smtc.patterns.creational.builder.builders.BottleBuilder;
import pl.smtc.patterns.creational.builder.support.ClosureType;
import pl.smtc.patterns.creational.builder.support.MaterialType;

public class ProductionDirector {

    public void createSparklingWineBottle(BottleBuilder builder) {
        builder.setCapacity(1.0);
        builder.setClosure(ClosureType.CORK);
        builder.setLabel("Sparkling Wine");
        builder.setMaterial(MaterialType.GLASS_BLUE);
        builder.setPuntHeight(5);
    }

    public void createChardonnayBottle(BottleBuilder builder) {
        builder.setCapacity(0.75);
        builder.setClosure(ClosureType.CORK);
        builder.setLabel("Chardonnay");
        builder.setMaterial(MaterialType.GLASS_BROWN);
        builder.setPuntHeight(10);
    }

    public void createCocaColaBottle(BottleBuilder builder) {
        builder.setCapacity(0.33);
        builder.setClosure(ClosureType.CROWN);
        builder.setLabel("Coca-Cola");
        builder.setMaterial(MaterialType.GLASS_WHITE);
    }

    public void createSodaBottle(BottleBuilder builder) {
        builder.setCapacity(0.5);
        builder.setClosure(ClosureType.SCREW);
        builder.setLabel("Soda");
        builder.setMaterial(MaterialType.PLASTIC);
    }

    public void createBeerBottle(BottleBuilder builder) {
        builder.setCapacity(0.5);
        builder.setClosure(ClosureType.FLIP_TOP);
        builder.setLabel("Beer");
        builder.setMaterial(MaterialType.GLASS_GREEN);
    }

}
