package pl.smtc.patterns.creational.factory.AbstractFactory.product.lamp;

public class StreetLamp extends Lamp {

    public StreetLamp(String caseColor) {
        super(caseColor);
        type = ELamp.STREET;
        mountPrerequisites = "city power connection, mount team";
    }

    @Override
    public boolean power(boolean on) {
        if (super.power(on)) {
            System.out.println("Light cannot blind pedestrians, cyclists and drivers.");
            return true;
        }
        return false;
    }

}
