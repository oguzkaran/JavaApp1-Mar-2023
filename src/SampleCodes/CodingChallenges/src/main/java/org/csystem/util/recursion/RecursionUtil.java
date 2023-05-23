package org.csystem.util.recursion;

import com.karandev.util.console.Console;

public class RecursionUtil {
    private static int fibonacciNumberRecur(int n)
    {
        if (n <= 2)
            return n - 1;

        return fibonacciNumberRecur(n - 1) + fibonacciNumberRecur(n - 2);
    }

    private static int gcdRecur(int a, int b)
    {
        return b == 0 ? a : gcdRecur(b, a % b);
    }

    private static void reverseRecur(char [] chars, int left, int right)
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

    public static int fibonacciNumber(int n)
    {
        if (n <= 0)
            return -1;

        return fibonacciNumberRecur(n);
    }

    public static int gcd(int a, int b)
    {
        return gcdRecur(Math.abs(a), Math.abs(b));
    }

    public static String reverse(String s)
    {
        var chars = s.toCharArray();

        reverseRecur(chars, 0, s.length() - 1);

        return String.valueOf(chars);
    }

    public static void writeCollatz(int n)
    {
        Console.writeLine(n);

        if (n == 1)
            return;

        writeCollatz(n % 2 == 0 ? n / 2 : 3 * n + 1);
    }
    public static void writeReverse(String s)
    {
        writeReverseRecur(s, 0);
    }
}
