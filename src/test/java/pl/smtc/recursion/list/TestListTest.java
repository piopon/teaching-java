package pl.smtc.recursion.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestListTest {
    private TestList testList = new TestList();

    @Test
    void addShouldAlwaysAddNodeAtEndOfList() {
        assertEquals(0, testList.add(new TestNode("test1")));
        assertEquals(1, testList.add(new TestNode("test2")));
        assertEquals(2, testList.add(new TestNode("test3")));
    }

    @Test
    void insertShouldInsertNodeAtInputtedPositionsIfInRange() {
        assertEquals(0, testList.insert(new TestNode("test1"), 0));
        assertEquals(0, testList.insert(new TestNode("test2"), 0));
        assertEquals(1, testList.insert(new TestNode("test3"), 1));
    }

    @Test
    void insertShouldInsertNodeAtEndIfOutOfRange() {
        assertEquals(0, testList.insert(new TestNode("test1"), 1));
        assertEquals(1, testList.insert(new TestNode("test2"), 2));
        assertEquals(2, testList.insert(new TestNode("test3"), 3));
    }

    @Test
    void getSizeShouldReturnCorrectNumberOfNodes() {
        testList.add(new TestNode("test1"));
        testList.add(new TestNode("test2"));
        testList.insert(new TestNode("test3"), 0);
        testList.insert(new TestNode("test4"), 100);

        assertEquals(4, testList.getSize());
    }

    @Test
    void clearShouldClearAllNodes() {
        testList.add(new TestNode("test1"));
        testList.add(new TestNode("test2"));
        testList.insert(new TestNode("test3"), 0);
        testList.insert(new TestNode("test4"), 100);
        testList.clear();

        assertEquals(0, testList.getSize());
    }

    @Test
    void toStringReturnsCorrectLinkedListSequence() {
        testList.add(new TestNode("test1"));
        testList.add(new TestNode("test2"));
        testList.insert(new TestNode("test3"), 0);

        String expected = "Node id: test3 --> Node id: test1 --> Node id: test2 --> [null]";
        assertEquals(expected, testList.toString());
    }
}