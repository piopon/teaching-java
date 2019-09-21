package pl.smtc.patterns.creational.factory.AbstractFactory.product.lamp;

public class CeilingLamp extends Lamp {

    public CeilingLamp(String caseColor) {
        super(caseColor);
        type = ELamp.CEILING;
        mountPrerequisites = "tall ladder, box for elements";
    }

    @Override
    public boolean power(boolean on) {
        if (super.power(on)) {
            System.out.println("Look up for the light to change.");
            return true;
        }
        return false;
    }

}
