package org.csystem.util.recursion;

import com.karandev.util.console.Console;

public class Util {
    public static long factorial(int n)
    {
        if (n <= 0)
            return 1;

        var result = 1L;

        for (; n > 1; --n)
            result *= n;

        return result;
    }

    public static String reverse(String s)
    {
        var chars = s.toCharArray();
        var left = 0;
        var right = s.length() - 1;

        while (left < right) {
            char temp = chars[left];

            chars[left++] = chars[right];
            chars[right--] = temp;
        }

        return String.valueOf(chars);
    }

    public static void writeReverse(String s)
    {
        for (var i = s.length() - 1; i >= 0; --i)
            Console.write(s.charAt(i));
    }
}
