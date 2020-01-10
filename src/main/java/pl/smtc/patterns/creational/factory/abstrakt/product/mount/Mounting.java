package pl.smtc.patterns.creational.factory.abstrakt.product.mount;

import java.util.ArrayList;
import java.util.List;

public abstract class Mounting {
    protected EMounting type = EMounting.UNKNOWN;
    protected List<String> tools = new ArrayList<>();
    protected int elementsNumber = 0;

    public void addTool(String tool) {
        tools.add(tool);
    }

    public String getTools() {
        return tools.toString();
    }

    public EMounting getType() {
        return type;
    }

    public String getDescription() {
        return elementsNumber + " " + type;
    }

    public void setMountElementsNumber(int elementsNumber) {
        this.elementsNumber = elementsNumber;
    }

    public boolean mount() {
        if (type == EMounting.UNKNOWN) {
            return false;
        }
        if (tools.isEmpty()) {
            System.out.println("You didn't bring any tools.");
            return false;
        }
        System.out.println("Tools: " + getTools());
        return true;
    }
}
