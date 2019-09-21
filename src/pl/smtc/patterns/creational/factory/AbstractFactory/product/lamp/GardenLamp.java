package pl.smtc.patterns.creational.factory.AbstractFactory.product.lamp;

public class GardenLamp extends Lamp {

    public GardenLamp(String caseColor) {
        super(caseColor);
        type = ELamp.GARDEN;
        mountPrerequisites = "place to dig a hole for lamp";
    }

    @Override
    public boolean power(boolean on) {
        if (super.power(on)) {
            System.out.println("You should have nice and mood light");
            return true;
        }
        return false;
    }

}
