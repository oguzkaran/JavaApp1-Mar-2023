package org.csystem.generator.random;

import com.karandev.util.console.Console;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;

@Ignore
public class RandomDoubleGeneratorTest {
    @Test
    public void test()
    {
        for (var val : RandomDoubleGenerator.of(new Random(), 10, 0, 100))
            Console.write("%f%n", val);
    }
}
