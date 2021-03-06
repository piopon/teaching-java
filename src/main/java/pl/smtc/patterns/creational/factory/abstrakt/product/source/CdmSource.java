package pl.smtc.patterns.creational.factory.abstrakt.product.source;

public class CdmSource extends Source {

    public CdmSource(int lightTemp) {
        super(lightTemp);
        type = ESource.CDM;
    }

    @Override
    public boolean power(boolean on) {
        if(super.power(on)) {
            System.out.println("Energy saving light " + (on ? "on" : "off"));
            return true;
        }
        return false;
    }

}
