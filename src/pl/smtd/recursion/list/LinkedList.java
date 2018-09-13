package pl.smtd.recursion.list;

import pl.smtd.menu.ConsoleExample;

public class LinkedList implements ConsoleExample {
    TestList list = new TestList();

    @Override
    public void execute() {
        buildTestList();
        System.out.println("Connection sequence (" + list.getSize() + " elements): ");
        System.out.println(list + "\n");
        cleanTestList();
    }

    @Override
    public String getName() {
        return "Linked list";
    }

    private void buildTestList() {
        list.add(new TestNode("1"));
        list.insert(new TestNode("2"),1);
        list.add(new TestNode("3"));
        list.add(new TestNode("5"));
        list.insert(new TestNode("4"),3);
        list.insert(new TestNode("last"),10);
    }

    private void cleanTestList() {
        list.clear();
    }
}
