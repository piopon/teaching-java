package pl.smtc.patterns.structural.composite.components;

import pl.smtc.patterns.structural.composite.utilities.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Folder implements Component {
    protected List<Component> contents = new ArrayList<>();
    private Folder parent;
    private String name;

    public Folder(String name, Folder parent) {
        this.name = name;
        this.parent = parent;
    }

    @Override
    public void print(int level) {
        System.out.println(StringUtils.repeat("  ", level) + "- " + name + "  [dir]");
        contents.forEach(component -> component.print(level+1));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Folder getParent() {
        return parent;
    }

    public void add(Component component) {
        if (!contents.contains(component)) {
            contents.add(component);
        }
    }

    public Folder getDirectory(String dirName) {
        if (dirName.equals(".")) {
            return this;
        }
        if (dirName.equals("..")) {
            return (getParent() == null) ? this : getParent();
        }
        return contents.stream()
                .filter(Folder.class::isInstance)
                .map(Folder.class::cast)
                .filter(folder -> folder.name.equals(dirName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No directory named: " + dirName));
    }
}
