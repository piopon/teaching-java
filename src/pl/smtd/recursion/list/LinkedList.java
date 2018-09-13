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

    private class TestList {
        private TestNode headNode = null;

        public void add(TestNode newNode) {
            if (headNode == null) {
                headNode = newNode;
            } else {
                TestNode lastNode = getLastNode();
                lastNode.setNext(newNode);
            }
        }

        public void insert(TestNode newNode, int position) {
            if (position == 0) {
                TestNode oldHeadNode = headNode;
                headNode = newNode;
                headNode.setNext(oldHeadNode);
            } else if (position >= getSize()) {
                add(newNode);
            } else {
                TestNode prevNode = getNode(position - 1);
                TestNode currentNode = getNode(position);
                prevNode.setNext(newNode);
                newNode.setNext(currentNode);
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
        }

        public void print() {
            print(headNode);
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

        private void print(TestNode n) {
            if (n != null) {
                System.out.print(n + " --> ");
                print(n.next);
            } else {
                System.out.print("[null]");
            }
        }
    }

    private class TestNode {
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
}
