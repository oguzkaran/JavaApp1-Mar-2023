package org.csystem.collection;

import org.csystem.collection.factory.RandomListFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class CSDArrayListNotNullableSetTest {
    public static final String FACE = "('_')";
    public static RandomListFactory factory = new RandomListFactory();
    public CSDArrayListNotNullable<Object> m_list;
    public Object strOld;

    public CSDArrayListNotNullableSetTest()
    {
        m_list = factory.createStringList(10, 3, 7);
        m_list.add(FACE);
    }

    @Test
    public void givenIndexAndNullValue_thenReturnsOldString()
    {
        strOld = m_list.set(m_list.indexOf(FACE), "#####");
        Assert.assertEquals(strOld, FACE);
        System.out.println(strOld);
    }

    @Test
    public void givenIndexAndNullValue_thenThrowsIllegalArgumentException()
    {
        Assert.assertThrows(IllegalArgumentException.class, () -> m_list.set(0, null));
    }
}
