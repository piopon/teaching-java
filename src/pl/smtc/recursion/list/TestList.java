package pl.smtc.recursion.list;

public class TestList {
    private TestNode headNode = null;

    public int add(TestNode newNode) {
        if (headNode == null) {
            headNode = newNode;
            return 0;
        } else {
            TestNode lastNode = getLastNode();
            lastNode.setNext(newNode);
            return getSize() - 1;
        }
    }

    public int insert(TestNode newNode, int position) {
        if (position == 0) {
            TestNode oldHeadNode = headNode;
            headNode = newNode;
            headNode.setNext(oldHeadNode);
            return position;
        } else if (position >= getSize()) {
            return add(newNode);
        } else {
            TestNode prevNode = getNode(position - 1);
            TestNode currentNode = getNode(position);
            prevNode.setNext(newNode);
            newNode.setNext(currentNode);
            return position;
        }
    }

    public int getSize() {
        int counter = 0;
        TestNode currentNode = headNode;
        while (currentNode != null) {
            counter++;
            currentNode = currentNode.getNext();
        }
        return counter;
    }

    public void clear() {
        TestNode nextNode = headNode;
        while (nextNode != null) {
            TestNode currentNode = nextNode;
            nextNode = currentNode.getNext();
            currentNode.setNext(null);
        }
        headNode = null;
    }

    @Override
    public String toString() {
        return print(headNode);
    }

    private TestNode getLastNode() {
        return getNode(headNode, getSize() - 1);
    }

    private TestNode getNode(int pos) {
        return getNode(headNode, pos);
    }

    private TestNode getNode(TestNode currentNode, int pos) {
        if (currentNode.getNext() == null || pos == 0) {
            return currentNode;
        } else {
            currentNode = getNode(currentNode.getNext(), --pos);
        }
        return currentNode;
    }

    private String print(TestNode n) {
        if (n != null) {
            return n + " --> " + print(n.getNext());
        } else {
            return "[null]";
        }
    }

}
