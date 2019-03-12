package pl.smtc.patterns.creational.AbstractFactory.product.source;

public abstract class Source {
    protected ESource type = ESource.UNKNOWN;
    protected int lightTemp;
    private String glassShade = "";

    protected Source(int lightTemp) {
        this.lightTemp = lightTemp;
    }

    public ESource getType() {
        return type;
    }

    public void setGlassShade(String glassShade) {
        this.glassShade = glassShade;
    }

    public String getDescription() {
        return getType() + " with " + glassShade + " glass - " + lightTemp + "[K]";
    }

    public boolean power(boolean on) {
        if (type == ESource.UNKNOWN) {
            return false;
        }
        System.out.println(getType() + " SOURCE - " + lightTemp + "[K]");
        return true;
    }
}
