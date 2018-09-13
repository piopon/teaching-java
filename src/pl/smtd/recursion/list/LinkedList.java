package pl.smtd.recursion.list;

import pl.smtd.menu.ConsoleExample;

public class LinkedList implements ConsoleExample {
    TestList list = new TestList();

    @Override
    public void execute() {
        fillList();
        System.out.println("Connection sequence (" + list.getSize() + " elements): ");
        list.print();
        System.out.println(" ");
        list.clear();
    }

    @Override
    public String getName() {
        return "Linked list";
    }

    private void fillList() {
        list.add(new TestNode("1"));
        list.insert(new TestNode("2"),1);
        list.add(new TestNode("3"));
        list.add(new TestNode("5"));
        list.insert(new TestNode("4"),3);
        list.insert(new TestNode("last"),10);
    }
}
