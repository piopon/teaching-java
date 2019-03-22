package pl.smtc.patterns.creational.AbstractFactory.product.mount;

import java.util.Arrays;
import java.util.List;

public class StandMounting extends Mounting {
    private List<String> tools;

    public StandMounting() {
        type = EMounting.STAND;
        tools = Arrays.asList("microfiber wiper, cleaners");
        tools.forEach(super::addTool);
    }

    @Override
    public boolean mount() {
        if(super.mount()) {
            System.out.println("- clean desk place with wiper");
            System.out.println("- place lamp at desired space");
            return true;
        }
        return false;
    }
}
