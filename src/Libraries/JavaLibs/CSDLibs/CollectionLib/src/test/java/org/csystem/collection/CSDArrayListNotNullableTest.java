package org.csystem.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class CSDArrayListNotNullableTest {
    @Test
    public void justAddOneNotNull()
    {
        var x = new CSDArrayListNotNullable<Integer>(10);
        var random = new Random();

        for(int i = 0; i < 20; i++)
            x.add(random.nextInt(100));

        assertEquals(20, x.size());
    }

    @Test
    public void justAddOneNotNullWithIndex()
    {
        var x = new CSDArrayListNotNullable<Integer>(10);
        var random = new Random();

        for(int i = 1; i <= 20; i++)
            x.add(i - 1,random.nextInt(100));

        assertEquals(20, x.size());
    }

    @Test
    public void justAddOneNullWithIndex()
    {
        var x = new CSDArrayListNotNullable<Integer>(10);
        var random = new Random();
        var initialCapacity = 10;

        var y = new ArrayList<Integer>(initialCapacity);

        for (int i = 0 ; i < initialCapacity; i++)
            y.add(random.nextBoolean() ? random.nextInt(100) : null);

        Assert.assertThrows(IllegalArgumentException.class , () -> x.addAll(y));
    }


    @Test
    public void justAddAllNotNullWithCapacity()
    {
        var random = new Random();

        var x = new ArrayList<Integer>(10);

        for (int i = 0 ; i < 10; i++)
            x.add(random.nextInt(100));

        var y = new CSDArrayListNotNullable<Integer>();

        y.addAll(x);
        assertEquals(10, x.size());
    }


    @Test
    public void justAddAllNullWithCapacity()
    {
        var x = new ArrayList<Integer>(10);

        for (int i = 0 ; i < 10; i++)
            x.add(null);

        var y = new CSDArrayListNotNullable<Integer>();


        Assert.assertThrows(IllegalArgumentException.class , () -> y.addAll(x));
    }

    @Test
    public void justSetNotNullWithCapacity()
    {
        var random = new Random();
        var initialCapacity = 10;

        var x = new ArrayList<Integer>(initialCapacity);

        for (int i = 0 ; i < initialCapacity; i++)
            x.add(random.nextInt(100));

        var y = new CSDArrayListNotNullable<Integer>();

        y.addAll(x);

        y.forEach(val -> System.out.printf("%d ", val));

        System.out.println();

        for (int i = 1 ; i < initialCapacity; i++) {
            y.set(i, i);
            System.out.print(y.get(i) + " ");
        }

        assertEquals(9, (int)y.get(9));
    }
}
