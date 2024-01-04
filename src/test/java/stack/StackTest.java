package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StackTest {

    @Test
    void newlyCreateStack_shouldBeEmpty() throws Exception {

        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getSize());
    }
}
