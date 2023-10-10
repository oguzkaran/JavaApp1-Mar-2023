package org.csystem.tuple;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;
import java.util.random.RandomGenerator;

@Ignore
public class IntPairEqualsTest {

    @Test
    public void true_test_minInteger()
    {
        var pair1 = IntPair.of(Integer.MIN_VALUE,Integer.MAX_VALUE);
        var pair2 = IntPair.of(Integer.MIN_VALUE,Integer.MAX_VALUE);

        Assert.assertEquals(pair1, pair2);
    }

    @Test
    public void false_test_maxInteger()
    {
        var pair1 = IntPair.of(Integer.MAX_VALUE,Integer.MIN_VALUE);
        var pair2 = IntPair.of(Integer.MAX_VALUE,Integer.MAX_VALUE);


        Assert.assertNotEquals(pair1, pair2);
    }


    @Test
    public void true_test_RandomOneNumber()
    {
        var pair1 = IntPair.of(10,15);
        var pair2 = IntPair.of(10,15);

        Assert.assertEquals(pair1, pair2);
    }

    @Test
    public void false_test_RandomOneNumber()
    {
        var pair1 = IntPair.of(10,15);
        var pair2 = IntPair.of(11,16);

        Assert.assertNotEquals(pair1, pair2);
    }

    @Test
    public void false_different_numbers_test()
    {
        var pair1 = IntPair.of(10,15);
        var pair2 = IntPair.of(15,10);


        Assert.assertNotEquals(pair1, pair2);
    }

    @Test
    public void false_test_RandomNumbers()
    {
        var random = new Random();

        for (int i = Integer.MIN_VALUE ; i < Integer.MAX_VALUE; i++){
            var pair1 = IntPair.of(random.nextInt(Integer.MIN_VALUE,Integer.MAX_VALUE),random.nextInt(Integer.MIN_VALUE,Integer.MAX_VALUE));
            var pair2 = IntPair.of(random.nextInt(Integer.MIN_VALUE,Integer.MAX_VALUE),random.nextInt(Integer.MIN_VALUE,Integer.MAX_VALUE));

            System.out.printf("pair1.1 : %s pair1.2 : %s pair2.1 : %s pair2.2 : %s %n", pair1.getFirst(), pair1.getSecond(), pair2.getFirst(), pair2.getSecond());

            Assert.assertNotEquals(pair1, pair2);
        }
    }

    @Test
    public void true_test_RandomNumbers()
    {
        var random = new Random();

        for (int i = Integer.MIN_VALUE ; i < Integer.MAX_VALUE; i++){
            var pair1 = IntPair.of(random.nextInt(Integer.MIN_VALUE,Integer.MAX_VALUE),random.nextInt(Integer.MIN_VALUE,Integer.MAX_VALUE));
            var pair2 = IntPair.of(random.nextInt(Integer.MIN_VALUE,Integer.MAX_VALUE),random.nextInt(Integer.MIN_VALUE,Integer.MAX_VALUE));

            System.out.printf("pair1.1 : %s pair1.2 : %s pair2.1 : %s pair2.2 : %s %n", pair1.getFirst(), pair1.getSecond(), pair2.getFirst(), pair2.getSecond());

            Assert.assertEquals(pair1, pair2);
        }
    }

    @Test
    public void write_number_test()
    {
        var pair = IntPair.of(10,15);

        System.out.println(pair);
    }

    @Test
    public void write_number_test_min_max()
    {
        var pair = IntPair.of(Integer.MAX_VALUE,Integer.MIN_VALUE);

        System.out.println(pair);
    }


}
