package pl.smtc.patterns.structural.adapter.phones;

public abstract class Phone {
    private String name;
    private String communication;
    private double battery;

    public Phone(String name, double battery, String communication) {
        this.name = name;
        this.battery = battery;
        this.communication = communication;
    }

    public void call(String number) {
        if(battery > 0.0) {
            System.out.println(name + " - calling number: " + number + " [" + communication + "]");
            updateBattery(-35.0);
        } else {
            System.out.println(name + " - battery empty. Charge it.");
        }
    }

    public void text(String number, String message) {
        if(battery > 0.0) {
            System.out.println(name + " - sending text: \"" + message + "\" to: " + number);
            updateBattery(-25.0);
        } else {
            System.out.println(name + " - battery empty. Charge it.");
        }
    }

    public String getName() {
        return name;
    }

    public double getBattery() {
        return battery;
    }

    protected void updateBattery(double delta) {
        battery += delta;
        if (battery < 0.0) {
            battery = 0.0;
        }
        if (battery > 100.0) {
            battery = 100.0;
        }
    }
}
