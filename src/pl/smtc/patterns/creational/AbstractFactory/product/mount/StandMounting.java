package pl.smtc.patterns.creational.AbstractFactory.product.mount;

import java.util.List;

public class StandMounting extends Mounting {
    private List<String> tools;

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
