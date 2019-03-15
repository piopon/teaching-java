package pl.smtc.patterns.creational.AbstractFactory.product.source;

public class LedSource extends Source {

    public LedSource(int lightTemp) {
        super(lightTemp);
        type = ESource.LED;
    }

    @Override
    public boolean power(boolean on) {
        if(super.power(on)) {
            System.out.println("Instant light " + (on ? "on" : "off"));
            return true;
        }
        return false;
    }

}
