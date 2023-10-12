package org.csystem.collection;

import org.junit.Ignore;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

@Ignore
public class CSDBoundedStackTest {
    @Test
    public void givenStack_whenEmpty_popThrowsEmptyStackException()
    {
        var stack = new CSDBoundedStack<Integer>(10);

        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    public void givenStack_whenEmpty_peekThrowsEmptyStackException()
    {
        var stack = new CSDBoundedStack<Integer>(10);

        assertThrows(EmptyStackException.class, stack::peek);
    }

    @Test
    public void givenStack_whenPush()
    {
        var stack = new CSDBoundedStack<Integer>(10);

        stack.push(20);

        assertEquals(20, (int)stack.peek());
    }

    @Test
    public void givenStack_whenFullThrowsFullStackException()
    {
        var stack = new CSDBoundedStack<Integer>(4);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        assertThrows(FullStackException.class, () -> stack.push(20));
    }

    @Test
    public void givenSize_whenNotPositiveThrowsIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () -> new CSDBoundedStack<>(0));
    }

    @Test
    public void givenStack_whenSearchFound()
    {
        var stack = new CSDBoundedStack<Integer>(10);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        assertEquals(2, stack.search(30));
    }

    @Test
    public void givenStack_whenSearchNotFound()
    {
        var stack = new CSDBoundedStack<Integer>(10);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        assertEquals(-1, stack.search(80));
    }

    @Test
    public void givenStack_whenEmpty()
    {
        var stack = new CSDBoundedStack<Integer>(10);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        while (!stack.empty())
            System.out.printf("%d ", stack.pop());

        System.out.println();
        assertTrue(stack.empty());
    }
}
