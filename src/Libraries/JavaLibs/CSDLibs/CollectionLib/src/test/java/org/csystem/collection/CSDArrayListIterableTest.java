package org.csystem.collection;

import org.junit.Assert;
import org.junit.Test;

public class CSDArrayListIterableTest {
    private int m_i;
    private void forEachCallback(Integer val)
    {
        System.out.printf("%d ", val);
        Assert.assertEquals(m_i++ + 1, val.intValue());
    }

    @Test
    public void test_for_each()
    {
        var list = new CSDArrayList<Integer>();

        for (int i = 1; i <= 11; ++i)
            list.add(i);

        list.forEach(this::forEachCallback);

        Assert.assertEquals(list.size(), m_i);
    }
}
