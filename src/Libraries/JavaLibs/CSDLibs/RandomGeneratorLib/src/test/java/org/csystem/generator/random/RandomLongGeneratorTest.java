package org.csystem.generator.random;

import com.karandev.util.console.Console;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;

@Ignore
public class RandomLongGeneratorTest {
    @Test
    public void test()
    {
        for (var val : RandomLongGenerator.of(new Random(), 10, Long.MIN_VALUE, Long.MAX_VALUE))
            Console.write("%d%n", val);
    }
}
