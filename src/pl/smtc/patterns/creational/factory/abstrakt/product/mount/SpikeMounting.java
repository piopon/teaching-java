package pl.smtc.patterns.creational.factory.abstrakt.product.mount;

import java.util.Arrays;
import java.util.List;

public class SpikeMounting extends Mounting {
    private List<String> tools;

    public SpikeMounting() {
        type = EMounting.SPIKE;
        tools = Arrays.asList("rubber hammer");
        tools.forEach(super::addTool);
    }

    @Override
    public boolean mount() {
        if(super.mount()) {
            System.out.println("- place spike to desired space");
            System.out.println("- knock lamp with rubber hammer");
            return true;
        }
        return false;
    }
}
