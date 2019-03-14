package pl.smtc.patterns.creational.AbstractFactory.product.lamp;

public class DesktopLamp extends Lamp {

    public DesktopLamp(String caseColor) {
        super(caseColor);
        type = ELamp.DESKTOP;
        mountPrerequisites = "free desk space";
    }

    @Override
    public boolean power(boolean on) {
        if (super.power(on)) {
            System.out.println("Whole desk should be correctly illuminated.");
            return true;
        }
        return false;
    }

}
