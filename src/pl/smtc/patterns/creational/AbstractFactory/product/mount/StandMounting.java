package pl.smtc.patterns.creational.AbstractFactory.product.mount;

public class StandMounting extends Mounting {

    public StandMounting() {
        type = EMounting.STAND;
    }

    @Override
    public boolean mount() {
        if(super.mount()) {
            System.out.println("- place lamp at desired space");
            return true;
        }
        return false;
    }
}
