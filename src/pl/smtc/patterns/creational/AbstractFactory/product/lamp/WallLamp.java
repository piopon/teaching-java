package pl.smtc.patterns.creational.AbstractFactory.product.lamp;

public class WallLamp extends Lamp {

    public WallLamp(String caseColor) {
        super(caseColor);
        type = ELamp.WALL;
        mountPrerequisites = "medium size ladder";
    }

    @Override
    public boolean power(boolean on) {
        if (super.power(on)) {
            System.out.println("Check if wall cracks are not visible.");
            return true;
        }
        return false;
    }

}
