package org.csystem.collection;

import org.csystem.util.string.StringUtil;
import org.junit.Test;

import java.util.Random;

public class CSDArrayListChangeCapacityIndirectTest {
    @Test
    public void changeCapacityTest()
    {
        var random  = new Random();
        var list = new CSDArrayList<String>(1);

        for (int i = 0; i < 2; ++i)
            list.add(StringUtil.getRandomTextEN(random, random.nextInt(16) + 1));
    }
}
