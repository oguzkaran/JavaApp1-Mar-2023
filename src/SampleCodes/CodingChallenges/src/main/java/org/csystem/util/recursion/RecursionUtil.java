package org.csystem.util.recursion;

import com.karandev.util.console.Console;

public class RecursionUtil {
    public static void reverseRecur(char [] chars, int left, int right)
    {
        if (left >= right)
            return;

        char temp = chars[left];

        chars[left] = chars[right];
        chars[right] = temp;
        reverseRecur(chars, left + 1, right - 1);
    }

    private static void writeReverseRecur(String s, int i)
    {
        if (i == s.length())
            return;

        writeReverseRecur(s, i + 1);
        Console.write(s.charAt(i));
    }

    public static long factorial(int n)
    {
        if (n <= 0)
            return 1;

        return n * factorial(n - 1);
    }

    public static String reverse(String s)
    {
        var chars = s.toCharArray();

        reverseRecur(chars, 0, s.length() - 1);

        return String.valueOf(chars);
    }

    public static void writeReverse(String s)
    {
        writeReverseRecur(s, 0);
    }
}
