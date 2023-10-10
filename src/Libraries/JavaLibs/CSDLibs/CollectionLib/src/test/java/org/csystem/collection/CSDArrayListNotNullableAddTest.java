package org.csystem.collection;

import org.csystem.collection.factory.RandomListFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class CSDArrayListNotNullableAddTest {
    public static RandomListFactory factory = new RandomListFactory();
    public CSDArrayListNotNullable<Object> m_list;

    public CSDArrayListNotNullableAddTest()
    {
        m_list = factory.createIntegerList(10, -100, 100);
    }

    @Test
    public void givenValue_thenAdd()
    {
        Assert.assertTrue(m_list.add(0));
    }

    @Test
    public void givenIndexAndValue_thenAdd()
    {
        m_list.add(0, Integer.MIN_VALUE);

        Assert.assertEquals(0, m_list.indexOf(Integer.MIN_VALUE));
    }

    @Test
    public void givenNullValue_thenThrowsIllegalArgumentException()
    {
        Assert.assertThrows(IllegalArgumentException.class, () -> m_list.add(null));
    }

    @Test
    public void givenIndexAndNullValue_thenThrowsIllegalArgumentException()
    {
        Assert.assertThrows(IllegalArgumentException.class, () -> m_list.add(0, null));
    }
}
