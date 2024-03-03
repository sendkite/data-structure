package linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {

    @Test
    void shouldHeadAndTailWithLength() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList(10);

        assertEquals(singlyLinkedList.getHead(), singlyLinkedList.getTail());
        assertEquals(1, singlyLinkedList.getLength());
        singlyLinkedList.print();
    }

    @Test
    void shouldAppend() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList(10);
        singlyLinkedList.append(5);

        assertEquals(10, singlyLinkedList.getHead().getValue());
        assertEquals(5, singlyLinkedList.getTail().getValue());
        assertEquals(2, singlyLinkedList.getLength());
        singlyLinkedList.print();
    }
}
