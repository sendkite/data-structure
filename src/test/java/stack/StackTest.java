package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    private Stack stack;

    @BeforeEach
    public void setUp() throws Exception {
        stack = Stack.Make(2);
    }

    @Test
    void newlyCreateStack_shouldBeEmpty() throws Exception {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getSize());
    }

    @Test
    void afterOnePush_StackSizeShouldBeOne() throws Exception {
        stack.push(1);
        assertEquals(1, stack.getSize());
        assertFalse(stack.isEmpty());
    }

    @Test
    void afterOnePushAndOnePop_ShouldBeEmpty() throws Exception {
        stack.push(1);
        stack.pop();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getSize());
    }

    @Test
    void WhenPushedPastLimit_StackOverFlow() throws Exception {
        stack.push(1);
        stack.push(1);
        assertThrows(Stack.Overflow.class, () -> {
            stack.push(1);
        });
    }

    @Test
    void WhenEmptyStackIsPopped_ShouldThrowUnderflow() throws Exception {
        assertThrows(Stack.Underflow.class, () -> {
            stack.pop();
        });
    }

    @Test
    void WhenOneIsPushed_OneIsPopped() throws Exception {
        stack.push(1);
        assertEquals(1, stack.pop());
    }

    @Test
    void WhenOneAndTwoArePushed_TwoAndOneArePopped() throws Exception {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void WhenCreatingStackWithNegativeSize_ShouldThrowIllegalCapacity() throws Exception {
        assertThrows(Stack.IllegalCapacity.class, () -> {
            Stack.Make(-1);
        });
    }
}
