/*----------------------------------------------------------
	FILE			: NumberUtil.java
	AUTHOR			: Java-Nov-2022 Group
	LAST UPDATE		: 24.06.2023
	
	Utility class for numeric operations
	
	Copyleft (c) 1993 C and System Programmers Association 
	All Rights Free
------------------------------------------------------------*/
package org.csystem.util.numeric;

import static java.lang.Math.abs;
import static java.lang.Math.log10;

public final class NumberUtil {
	private NumberUtil()
	{
	}

	private static final String [] ONES = {"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
	private static final String [] TENS = {"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};

	private static int [] getDigits(long val, int n)
	{
		int [] digits = new int[val == 0 ? 1 : (int)(Math.log10(Math.abs(val)) / n) + 1];
		int powOfTen = (int)pow(10, n);

		val = abs(val);

		for (int i = digits.length - 1; i >= 0; digits[i] = (int)(val % powOfTen), val /= powOfTen, --i)
			;

		return digits;
	}

	private static String numToText3DigitsTR(int a, int b, int c)
	{
		String str = "";

		if (a != 0) {
			if (a != 1)
				str += ONES[a];

			str += "yüz";
		}

		return str  + TENS[b] + ONES[c];
	}

	private static String numToText3DigitsTR(int val)
	{
		if (val == 0)
			return "sıfır";

		String str = val < 0 ? "eksi" : "";

		val = Math.abs(val);

		int a = val / 100;
		int b = val / 10 % 10;
		int c = val % 10;

		return str + numToText3DigitsTR(a, b, c);
	}

	public static boolean areFriends(int a, int b)
	{
		return sumFactors(a) == b && sumFactors(b) == a;
	}

	public static int calculateDigitalRoot(int a)
	{
		int root = abs(a);

		while (root > 9)
			root = sumDigits(root);

		return root;
	}

	public static int calculateDigitsPowSum(int a)
	{
		int n = countDigits(a);

		int total = 0;

		while (a != 0) {
			total += pow(a % 10, n);

			a /= 10;
		}

		return total;

	}

	public static int countDigits(long a)
	{	
		return a == 0 ? 1 : (int)log10(abs(a)) + 1;
	}

	public static int factorial(int n)
	{
		int result = 1;

		for (int i = 2; i <= n; ++i)
			result *= i;
		
		return result;
	}

	public static int fibonacciNumber(int n)
	{
		if (n <= 2)
			return n - 1;

		int prev1 = 1, prev2 = 0, val = 0;

		for (int i = 2; i < n; ++i) {
			val = prev1 + prev2;
			prev2 = prev1;
			prev1 = val;
		}

		return val;
	}

	public static int [] getDigits(long val)
	{
		return getDigits(val, 1);
	}

	public static int [] getDigitsInTwos(long val)
	{
		return getDigits(val, 2);
	}

	public static int [] getDigitsInThrees(long val)
	{
		return getDigits(val, 3);
	}
	
	public static int getHardyRamanujanCount(int n)
	{
		int count = 0;

		EXIT_LOOP:

		for (int a = 1; a * a * a < n; ++a)
			for (int b = a + 1; a * a * a + b * b * b <= n; ++b)
				if (a * a * a + b * b * b == n) {
					if (++count == 2)
						break EXIT_LOOP;

					++a;
				}

		return count;
	}

	public static int getPrime(int n)
	{
		int val = 2;
		int count = 0;

		for (;;) {
			if (isPrime(val))
				++count;

			if (count == n)
				return val;

			++val;
		}
	}
	
	public static int indexOfPrime(long a)
	{
		int i = 1;
		long val = 2;

		for (;;) {
			if (val == a)
				return i;

			if (isPrime(val))
				++i;
			
			++val;
		}
	}

	public static boolean isArmstrong(int a)
	{
		return a >= 0 && calculateDigitsPowSum(a) == a;
	}

	public static boolean isDecimalHarshad(int val)
	{
		return val > 0 && val % sumDigits(val) == 0; 
	}
	
	public static boolean isEven(int a)
	{
		return a % 2 == 0;
	}
	
	public static boolean isFactorian(int n)
	{
		return n > 0 && sumFactorialDigits(n) == n;
	}

	public static boolean isHardyRamanujan(int n)
	{
		return n > 0 && getHardyRamanujanCount(n) == 2;
	}

	public static boolean isOdd(int a)
	{
		return !isEven(a);
	}

	public static boolean isPerfect(int val)
	{
		return sumFactors(val) == val;
	}
	
	public static boolean isPrime(long a)
	{
		if (a <= 1)
			return false;

		if (a % 2 == 0)
			return a == 2;

		if (a % 3 == 0)
			return a == 3;

		if (a % 5 == 0)
			return a == 5;

		if (a % 7 == 0)
			return a == 7;

		for (long i = 11; i * i <= a; i += 2)
			if (a % i == 0)
				return false;
		
		return true;
	}		

	public static boolean isPrimeX(long a)
	{
		boolean result;
		
		for (long sum = a; (result = isPrime(sum)) && sum > 9; sum = sumDigits(sum))
			;
		
		return result;
	}

	public static boolean isSuperPrime(long a)
	{
		return isPrime(a) && isPrime(indexOfPrime(a));
	}

	public static int mid(int a, int b, int c)
	{
		if (a <= b && b <= c || c <= b && b <= a)
			return b;

		if (b <= a && a <= c || c <= a && a <= b)
			return a;

		return c;
	}

	public static int multiply(int a, int b)
	{
		return a * b;
	}
	
	public static int nextFibonacciNumber(int val)
	{
		if (val < 0)
			return 0;

		int prev1 = 1, prev2 = 0, next;
		
		for (;;) {
			next = prev1 + prev2;
			
			if (next > val)
				return next;

			prev2 = prev1;
			prev1 = next;
		}
	}

	public static int pow(int a, int b)
	{
		int result = 1;

		while (b-- > 0)
			result *= a;
		
		return result;
	}
	
	public static int reversed(int a)
	{
		int result = 0;

		while (a != 0) {
			result = result * 10 + a % 10;
			a /= 10;
		}

		return result;
	}
	
	public static int sumDigits(long a)
	{
		int sum = 0;

		while (a != 0) {
			sum += a % 10;
			a /= 10;
		}

		return abs(sum);

	}

	public static int sumFactorialDigits(int n)
	{
		int sum = 0;
		
		while (n != 0) {
			sum += factorial(n % 10);
			n /= 10;
		}

		return sum;
	}

	public static long sumFactors(long val)
	{
		long result = 1;

		for (long i = 2; i * i <= val; ++i)
			if (val % i == 0)
				result += (i == val / i) ? i : (i + val / i); 

		return result;
	}
}