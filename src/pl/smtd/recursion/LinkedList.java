package pl.smtd.recursion;

import pl.smtd.menu.ConsoleExample;

public class LinkedList implements ConsoleExample {
    @Override
    public void execute() {
        Node nodeLast = new Node("3", null);
        Node nodeMiddle = new Node("2", nodeLast);
        Node nodeFirst = new Node("1", nodeMiddle);
        System.out.println("Connection sequence:");
        printLinkedList(nodeFirst);
        System.out.println(" ");
    }

    @Override
    public String getName() {
        return "Linked list";
    }

    private static void printLinkedList(Node n) {
        if(n != null) {
            System.out.print(n + " --> ");
            printLinkedList(n.next);
        } else {
            System.out.print("[null]");
        }
    }

    private class Node {
        String id;
        Node next;

        public Node (String id, Node next) {
            this.id = id;
            this.next = next;
        }

        public String toString () {
            return "Node id: " + id;
        }
    }
}
