package pl.smtc.patterns.behavioral.iterator.iterator;

public interface Iterator<T> {
    boolean hasNext();

    void first();

    void next();

    T currentItem();
}
