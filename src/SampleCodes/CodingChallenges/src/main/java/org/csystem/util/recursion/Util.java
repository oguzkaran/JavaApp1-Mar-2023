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

    public static int fibonacciNumber(int n)
    {
        if (n <= 0)
            return -1;

        if (n <= 2)
            return n - 1;

        int prev1 = 1, prev2 = 0, result = 0;

        for (int i = 2; i < n; ++i) {
            result = prev1 + prev2;
            prev2 = prev1;
            prev1 = result;
        }

        return result;
    }

    public static int gcd(int a, int b)
    {
        int min = Math.min(Math.abs(a), Math.abs(b));

        for (int i = min; i >= 2; --i)
            if (a % i == 0 && b % i == 0)
                return i;

        return 1;
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

    public static void writeCollatz(int n)
    {
        for (;;) {
            Console.writeLine(n);

            if (n == 1)
                break;

            n = n % 2 == 0 ? n / 2 : 3 * n + 1;
        }
    }

    public static void writeReverse(String s)
    {
        for (var i = s.length() - 1; i >= 0; --i)
            Console.write(s.charAt(i));
    }
}
