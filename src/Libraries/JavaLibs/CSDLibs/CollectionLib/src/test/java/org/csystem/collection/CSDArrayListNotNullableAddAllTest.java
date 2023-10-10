package org.csystem.collection;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import org.csystem.collection.factory.RandomListFactory;

@Ignore
public class CSDArrayListNotNullableAddAllTest {
    public static RandomListFactory factory = new RandomListFactory();
    public static List<Integer> intList = Arrays.asList(1, 2, 3, 4);
    public CSDArrayListNotNullable<Object> m_list;

    public CSDArrayListNotNullableAddAllTest()
    {
        m_list = factory.createIntegerList(10, -100, 100);
    }

    @Test
    public void givenCollection_thenAddAll()
    {
        Assert.assertTrue(m_list.addAll(intList));
    }

    @Test
    public void givenIndexAndCollection_thenAddAll()
    {
        Assert.assertTrue(m_list.addAll(0, intList));
    }

    @Test
    public void givenCollectionWithNullValues_thenThrowsIllegalArgumentException()
    {
        Assert.assertThrows(IllegalArgumentException.class, () -> m_list.addAll(Arrays.asList(null, 808, null)));
    }

    @Test
    public void givenIndexAndCollectionWithNullValues_thenThrowsIllegalArgumentException()
    {
        Assert.assertThrows(IllegalArgumentException.class, () -> m_list.addAll(0, Arrays.asList(null, 909, null)));
    }
}
