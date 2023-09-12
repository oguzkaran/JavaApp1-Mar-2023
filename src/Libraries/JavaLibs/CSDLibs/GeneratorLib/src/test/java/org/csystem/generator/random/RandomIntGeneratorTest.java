package org.csystem.generator.random;

import com.karandev.util.console.Console;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;

@Ignore
public class RandomIntGeneratorTest {
    @Test
    public void test()
    {
        var gen = RandomIntGenerator.of(new Random(), 10, 0, 100);

        for (var val : gen)
            Console.write("%d ", val);

        Console.writeLine();
    }
}
