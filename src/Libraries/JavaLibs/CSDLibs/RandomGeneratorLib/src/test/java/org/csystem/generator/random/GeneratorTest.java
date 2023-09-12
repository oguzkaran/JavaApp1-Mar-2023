package org.csystem.generator.random;

import com.karandev.util.console.Console;
import org.csystem.generator.Generator;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;

@Ignore
public class GeneratorTest {
    @Test
    public void test()
    {
        var min = 0;
        var bound = 100;
        var random = new Random();

        for (var val : Generator.of(() -> random.nextInt(min, bound), 5))
            Console.write("%d ", val);

        Console.writeLine();
    }
}
