package pl.smtc.recursion.list;

import org.junit.jupiter.api.Test;
import pl.smtc.base.BaseTestOut;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest extends BaseTestOut {
    private LinkedList linkedList;

    @Override
    protected void setUp() {
        linkedList = new LinkedList();
    }

    @Test
    void executeShouldOutputLinkedListNodes() {
        linkedList.execute();
        String output = getOutput();
        assertTrue(output.contains("Connection sequence (6 elements):"));
        assertTrue(output.contains("Node id: 1"));
        assertTrue(output.contains("Node id: 2"));
        assertTrue(output.contains("Node id: 3"));
        assertTrue(output.contains("Node id: 4"));
        assertTrue(output.contains("Node id: 5"));
        assertTrue(output.contains("Node id: last"));
    }

    @Test
    void getNameShouldReturnLinkedList() {
        assertEquals("Linked list", linkedList.getName());
    }
}