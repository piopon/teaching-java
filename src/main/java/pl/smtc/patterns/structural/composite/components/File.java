package pl.smtc.patterns.structural.composite.components;

import pl.smtc.patterns.structural.composite.utilities.StringUtils;

import java.util.Random;

public class File implements Component {
    private final static int SIZE_MAX = 10000;
    private final static Random SIZE_GENERATOR = new Random();
    private Folder parent;
    private String name;
    private int sizeKB;

    public File(String name, Folder parent) {
        this.name = name;
        this.parent = parent;
        this.sizeKB = SIZE_GENERATOR.nextInt(SIZE_MAX);
    }

    @Override
    public void print(int level) {
        System.out.println(StringUtils.repeat("  ", level) + "- " + name + " [" + sizeKB + "KB]");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Folder getParent() {
        return parent;
    }
}
