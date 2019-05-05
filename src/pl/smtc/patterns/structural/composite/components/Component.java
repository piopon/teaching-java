package pl.smtc.patterns.structural.composite.components;

public interface Component {
    void print(int level);

    String getName();

    Folder getParent();
}
