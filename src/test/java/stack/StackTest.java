package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    private Stack stack;

    @BeforeEach
    public void setUp() throws Exception {
        stack = BoundedStack.Make(2);
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
        assertThrows(BoundedStack.Overflow.class, () -> {
            stack.push(1);
        });
    }

    @Test
    void WhenEmptyStackIsPopped_ShouldThrowUnderflow() throws Exception {
        assertThrows(BoundedStack.Underflow.class, () -> {
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
        assertThrows(BoundedStack.IllegalCapacity.class, () -> {
            BoundedStack.Make(-1);
        });
    }

    @Test
    void WhenCreatingStackWithZeroCapacity_ShouldThrowOverFlow() throws Exception {
        Stack stack = BoundedStack.Make(0);
        assertThrows(BoundedStack.Overflow.class, () -> {
            stack.push(1);
        });
    }

    @Test
    void WhenCreatingStackWithZeroCapacity_ShouldBeEmpty() throws Exception {
        Stack stack = BoundedStack.Make(0);
        assertTrue(stack.isEmpty());
    }

    @Test
    void WhenOneIsPushed_OneIsOnTop() throws Exception {
        stack.push(1);
        assertEquals(1, stack.top());
    }

    @Test
    void WhenStackIsEmpty_TopThrowsEmpty() throws Exception {
        assertThrows(BoundedStack.Empty.class, () -> {
            stack.top();
        });
    }

    @Test
    void WithZeroCapacityStack_TopThrowsEmpty() throws Exception {
        Stack stack = BoundedStack.Make(0);
        assertThrows(BoundedStack.Empty.class, stack::top);
    }

    @Test
    void GivenStackWithOneTwoPushed_FindOne() throws Exception {
        stack.push(1);
        stack.push(2);
        assertEquals(1, stack.find(1));
        assertEquals(0, stack.find(2));
    }

    @Test
    void GivenStackWithOnePushed_FindTwoShouldReturnNull() throws Exception {
        stack.push(1);
        assertNull(stack.find(2));
    }
}
