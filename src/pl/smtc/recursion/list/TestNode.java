package pl.smtc.recursion.list;

public class TestNode {
    private String id;
    private TestNode next;

    public TestNode(String id) {
        this.id = id;
    }

    public TestNode getNext() {
        return next;
    }

    public void setNext(TestNode nextNode) {
        this.next = nextNode;
    }

    public String toString () {
        return "Node id: " + id;
    }
}
