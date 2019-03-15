package pl.smtc.patterns.creational.AbstractFactory.product.source;

public class NeonSource extends Source {

    public NeonSource(int lightTemp) {
        super(lightTemp);
        type = ESource.NEON;
    }

    @Override
    public boolean power(boolean on) {
        if(super.power(on)) {
            System.out.println("Multicolor light " + (on ? "on" : "off"));
            return true;
        }
        return false;
    }

}
