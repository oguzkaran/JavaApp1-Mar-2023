package org.csystem.range;

import com.karandev.util.console.Console;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

@Ignore
public class IntRangeTest {
    private void ofClosedThrowingRunnableCallback()
    {
        for (var val : IntRange.ofClosed(10, 9, val -> 2 * val + 1))
            Console.write("%d ", val);

        Console.writeLine();
    }

    private void ofThrowingRunnableCallback()
    {
        for (var val : IntRange.of(10, 10, val -> 2 * val + 1))
            Console.write("%d ", val);

        Console.writeLine();
    }

    @Test
    public void ofClosedIllegalArgumentExceptionTest()
    {
        assertThrows(IllegalArgumentException.class, this::ofClosedThrowingRunnableCallback);
    }

    @Test
    public void ofIllegalArgumentExceptionTest()
    {
        assertThrows(IllegalArgumentException.class, this::ofThrowingRunnableCallback);
    }

    @Test
    public void ofClosedStepOneTest()
    {
        for (var val : IntRange.ofClosed(10, 20))
            Console.write("%d ", val);

        Console.writeLine();
    }

    @Test
    public void ofStepOneTest()
    {
        for (var val : IntRange.of(10, 20))
            Console.write("%d ", val);

        Console.writeLine();
    }

    @Test
    public void ofClosedStepTest()
    {
        for (var val : IntRange.ofClosed(10, 20, 2))
            Console.write("%d ", val);

        Console.writeLine();
    }
    @Test
    public void ofStepTest()
    {
        for (var val : IntRange.ofClosed(10, 20, 3))
            Console.write("%d ", val);

        Console.writeLine();
    }

    @Test
    public void ofClosedNegativeStepTest()
    {
        for (var val : IntRange.ofClosed(10, 20, -2))
            Console.write("%d ", val);

        Console.writeLine();
    }

    @Test
    public void ofClosedCallbackTest()
    {
        for (var val : IntRange.ofClosed(10, 175, val -> 2 * val + 1))
            Console.write("%d ", val);

        Console.writeLine();
    }

    @Test
    public void ofCallbackTest()
    {
        for (var val : IntRange.of(10, 175, val -> 2 * val + 1))
            Console.write("%d ", val);

        Console.writeLine();
    }


}
