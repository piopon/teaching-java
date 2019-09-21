package pl.smtc.patterns.creational.factory.AbstractFactory.product.mount;

import java.util.Arrays;
import java.util.List;

public class AnchorsMounting extends Mounting {
    private List<String> tools;

    public AnchorsMounting() {
        type = EMounting.ANCHORS;
        tools = Arrays.asList("power driller", "drillers' guide", "binding mixture");
        tools.forEach(super::addTool);
    }

    @Override
    public boolean mount() {
        if(super.mount()) {
            System.out.println("- mount driller into guide");
            System.out.println("- drill holes");
            System.out.println("- fill holes with binging mixture");
            System.out.println("- use " + elementsNumber + " " + getType() + " to mount lamp");
            return true;
        }
        return false;
    }
}
