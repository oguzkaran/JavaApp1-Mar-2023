package org.csystem.generator.random;

import com.karandev.util.console.Console;
import org.csystem.generator.Generator;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;

import static org.csystem.util.string.StringUtil.getRandomTextEN;

@Ignore
public class GeneratorTest {
    @Test
    public void intValuesTest()
    {
        var min = 0;
        var bound = 100;
        var random = new Random();

        Generator.of(() -> random.nextInt(min, bound), 5).forEach(val -> Console.write("%d ", val));
        Console.writeLine();
    }

    @Test
    public void stringValuesTest()
    {
        var min = 5;
        var bound = 11;
        var random = new Random();

        Generator.of(() -> getRandomTextEN(random, random.nextInt(min, bound)), 5).forEach(Console::writeLine);
    }
}
