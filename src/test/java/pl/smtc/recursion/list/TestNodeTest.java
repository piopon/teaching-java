package pl.smtc.recursion.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestNodeTest {
    private TestNode node;

    @BeforeEach
    void setup() {
        node = new TestNode("test");
    }

    @Test
    void getNextCorrectlyReturnsNextNode() {
        assertNull(node.getNext());
        node.setNext(new TestNode("next"));
        assertEquals("Node id: next", node.getNext().toString());
    }

    @Test
    void setNextCorrectlyPinsNextNode() {
        TestNode nextNode = new TestNode("next");
        node.setNext(nextNode);
        assertEquals(nextNode, node.getNext());
    }

    @Test
    void toStringReturnsCorrectNodeNameWithIdPrefix() {
        assertEquals("Node id: test", node.toString());
    }
}