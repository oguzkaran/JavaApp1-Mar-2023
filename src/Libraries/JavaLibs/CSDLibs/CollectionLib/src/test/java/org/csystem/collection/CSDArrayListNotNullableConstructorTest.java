package org.csystem.collection;

import org.csystem.collection.factory.RandomListFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
@Ignore
public class CSDArrayListNotNullableConstructorTest {
    private final DataInfo m_dataInfo;
    public static RandomListFactory factory = new RandomListFactory();

    public static class DataInfo {
        CSDArrayListNotNullable<Object> list;
        int expected;

        public DataInfo(CSDArrayListNotNullable<Object> list, int expected)
        {
            this.list = list;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(
                new DataInfo(factory.createIntegerList(10, -100, 100), -1),
                new DataInfo(factory.createStringList(10, 2, 5), -1));
    }

    public CSDArrayListNotNullableConstructorTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenCollection_thenCreateNotNullableArrayList()
    {
        System.out.println(m_dataInfo.list);
        Assert.assertEquals(m_dataInfo.expected, m_dataInfo.list.indexOf(null));
    }

    @Test
    public void givenCollectionWithNullElement_thenThrowsIllegalArgumentException()
    {
        Assert.assertThrows(IllegalArgumentException.class, () -> new CSDArrayListNotNullable<>(Arrays.asList(null, null)));
    }
}
