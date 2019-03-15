package pl.smtc.patterns.creational.AbstractFactory.product.source;

public class HmiSource extends Source {

    public HmiSource(int lightTemp) {
        super(lightTemp);
        type = ESource.HMI;
    }

    @Override
    public boolean power(boolean on) {
        if(super.power(on)) {
            System.out.println("Electronic ballast for arc ignition " + (on ? "on" : "off"));
            return true;
        }
        return false;
    }

}
