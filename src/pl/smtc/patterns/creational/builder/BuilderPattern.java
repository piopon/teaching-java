package pl.smtc.patterns.creational.builder;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.patterns.creational.builder.builders.BeverageBottleBuilder;
import pl.smtc.patterns.creational.builder.builders.WineBottleBuilder;
import pl.smtc.patterns.creational.builder.director.ProductionDirector;

public class BuilderPattern implements ConsoleExample {
    ProductionDirector director = new ProductionDirector();

    @Override
    public void execute() {
        createWineBottles();
        createBeverageBottles();
    }

    @Override
    public String getName() {
        return "Builder Pattern";
    }

    private void createWineBottles() {
        String outputTitle = "WINE: ";
        WineBottleBuilder builder = new WineBottleBuilder();
        director.createChardonnayBottle(builder);
        System.out.println(outputTitle + builder.getResult());
        director.createSparklingWineBottle(builder);
        System.out.println(outputTitle + builder.getResult());
    }

    private void createBeverageBottles() {
        String outputTitle = "BEVERAGE: ";
        BeverageBottleBuilder builder = new BeverageBottleBuilder();
        director.createBeerBottle(builder);
        System.out.println(outputTitle + builder.getResult());
        director.createCocaColaBottle(builder);
        System.out.println(outputTitle + builder.getResult());
        director.createSodaBottle(builder);
        System.out.println(outputTitle + builder.getResult());
    }
}
