package org.csystem.collection;

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

import java.util.EmptyStackException;

@Ignore
public class CSDArrayListStackTest {
    @Test
    public void givenStack_whenEmpty_popThrowsEmptyStackException()
    {
        var stack = new CSDArrayListStack<Integer>();

        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    public void givenStack_whenEmpty_peekThrowsEmptyStackException()
    {
        var stack = new CSDArrayListStack<Integer>();

        assertThrows(EmptyStackException.class, stack::peek);
    }

    @Test
    public void givenStack_whenPush()
    {
        var stack = new CSDArrayListStack<Integer>();

        stack.push(20);

        assertEquals(20, (int)stack.peek());
    }

    @Test
    public void givenStack_whenSearchFound()
    {
        var stack = new CSDArrayListStack<Integer>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        assertEquals(2, stack.search(30));
    }

    @Test
    public void givenStack_whenSearchNotFound()
    {
        var stack = new CSDArrayListStack<Integer>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        assertEquals(-1, stack.search(80));
    }
}
