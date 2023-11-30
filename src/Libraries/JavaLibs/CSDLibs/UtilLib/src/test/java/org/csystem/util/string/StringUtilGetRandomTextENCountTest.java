package org.csystem.util.string;

import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class StringUtilGetRandomTextENCountTest {

    @Test
    public void givenValue_whenRandomGeneratorAndCount_thenReturnsRandomTextENWithCountLength()
    {
        var random = new Random(100);
        var count = 10;
        var sb = new StringBuilder(count);
        var alphabet = "abcdefghijklmnopqrstuwxvyzABCDEFGHIJKLMNOPQRSTUWXVYZ";
        var len = alphabet.length();

        IntStream.range(0, count).forEach(i -> sb.append(alphabet.charAt(random.nextInt(len))));
        var str = sb.toString();

        assertEquals(str, StringUtil.getRandomTextEN(new Random(100), count));
    }
}
