package pl.smtc.recursion.list;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList linkedList;
    private static final ByteArrayOutputStream OUTPUT_STREAM = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        linkedList = new LinkedList();
        System.setOut(new PrintStream(OUTPUT_STREAM));
    }

    @AfterEach
    void teardown() {
        System.setOut(System.out);
        OUTPUT_STREAM.reset();
    }

    @Test
    void executeShouldOutputLinkedListNodes() {
        linkedList.execute();
        String output = OUTPUT_STREAM.toString();
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