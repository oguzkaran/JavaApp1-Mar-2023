package org.csystem.generator.random;

import com.karandev.util.console.Console;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Ignore
public class RandomPeriodicIntGeneratorTest {
    @Test
    public void test() throws InterruptedException
    {
        var generator = new RandomPeriodicIntGenerator(new Random(), 0, 100, 10, 0, 1000);

        generator.generate(val -> Console.write("%d ", val));
        TimeUnit.SECONDS.sleep(11);
    }
}
