package pl.smtc.patterns.creational.AbstractFactory.product.mount;

import java.util.Arrays;
import java.util.List;

public class ScrewsMounting extends Mounting {
    private List<String> tools;

    public ScrewsMounting() {
        type = EMounting.SCREWS;
        tools = Arrays.asList("power driller", "vacuum", "rawlplugs");
        tools.forEach(super::addTool);
    }

    @Override
    public boolean mount() {
        if(super.mount()) {
            System.out.println("- drill holes with a power driller");
            System.out.println("- clean all holes with vacuum");
            System.out.println("- put rawlplugs into holes");
            System.out.println("- use " + elementsNumber + " " + getType() + " and mount lamp");
            return true;
        }
        return false;
    }
}
