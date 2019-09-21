package pl.smtc.patterns.creational.factory.AbstractFactory.product.mount;

import java.util.Arrays;
import java.util.List;

public class DowelsMounting extends Mounting {
    private List<String> tools;

    public DowelsMounting() {
        type = EMounting.DOWELS;
        tools = Arrays.asList("drill-driver", "dowel glue");
        tools.forEach(super::addTool);
    }

    @Override
    public boolean mount() {
        if(super.mount()) {
            System.out.println("- drill holes with drill-driver");
            System.out.println("- fill holes with glue");
            System.out.println("- use " + elementsNumber + " " + getType() + " to mount lamp");
            return true;
        }
        return false;
    }
}
