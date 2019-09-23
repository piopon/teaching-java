package pl.smtc.patterns.creational.factory.abstrakt.product.source;

public class FluorescentSource extends Source {

    public FluorescentSource(int lightTemp) {
        super(lightTemp);
        type = ESource.FLUORESCENT;
    }

    @Override
    public boolean power(boolean on) {
        if(super.power(on)) {
            System.out.println("Flickering light " + (on ? "on" : "off"));
            return true;
        }
        return false;
    }

}
