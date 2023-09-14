package org.csystem.range;

import com.karandev.util.console.Console;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

@Ignore
public class DoubleRangeTest {
    private void ofThrowingRunnableCallback()
    {
        for (var val : DoubleRange.of(10.234, 10.22, val ->  2 * val + 1))
            Console.write("%f ", val);

        Console.writeLine();
    }

    private void negativeStepThrowingRunnableCallback()
    {
        for (var val : DoubleRange.of(10.234, 10.22, -2))
            Console.write("%f ", val);

        Console.writeLine();
    }

    @Test
    public void ofIllegalArgumentExceptionTest()
    {
        assertThrows(IllegalArgumentException.class, this::ofThrowingRunnableCallback);
    }

    @Test
    public void negativeStepIllegalArgumentExceptionTest()
    {
        assertThrows(IllegalArgumentException.class, this::negativeStepThrowingRunnableCallback);
    }

    @Test
    public void ofStepTest()
    {
        for (var val : DoubleRange.of(10.234, 10.345, 0.013))
            Console.write("%f%n", val);
    }

    @Test
    public void ofCallbackTest()
    {
        for (var val : DoubleRange.of(10.234, 23.456, val -> 2.89 * val + 0.234))
            Console.write("%f%n", val);
    }
}
