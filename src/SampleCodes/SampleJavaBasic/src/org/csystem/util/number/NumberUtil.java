/*----------------------------------------------------------------------
	FILE        : NumberUtil.java
	AUTHOR      : Java-May-2021 Group
	LAST UPDATE : 21.11.2021

	Utility class for numeric operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.number;

import static java.lang.Math.*;

public final class NumberUtil {
	private static final String [] ms_ones;
	private static final String [] ms_tens;

	static {
		ms_ones = new String[]{"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
		ms_tens = new String[]{"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};
	}

	private static int [] getDigits(long val, int n)
	{
		val = Math.abs(val);
		int [] result = new int[val == 0 ? 1 : (int)(Math.log10(val) / n) + 1];

		for (int i = result.length - 1; val != 0; result[i--] = (int)(val % (long)Math.pow(10, n)), val /= Math.pow(10, n))
			;

		return result;
	}

	private static String numberToText3DigitsTR(int val)
	{
		if (val == 0)
			return "sıfır";

		String text = val < 0 ? "eksi" : "";

		val = Math.abs(val);

		int a = val / 100;
		int b = val % 100 / 10;
		int c = val % 10;

		if (a != 0) {
			if (a != 1)
				text += ms_ones[a];
			text += "yüz";
		}

		if (b != 0)
			text += ms_tens[b];

		if (c != 0)
			text += ms_ones[c];

		return text;
	}

	private NumberUtil()
	{
	}

	public static int calculateDigitalRoot(int val)
	{
		int root = abs(val);
		
		while ((root = digitsSum(root)) > 9)
			;
		
		return root;
	}
	
	public static int countDigits(long val)
	{
		return val == 0 ? 1 : (int)log10(abs(val)) +  1;
	}
	
	public static int digitsSum(long val)
	{
		int sum = 0;
		
		while (val != 0) {
			sum += val % 10;
			val /= 10;
		}
		
		return sum;
	}
	
	public static void displayCollatz(int n)
	{
		if (n <= 0) {
			System.out.println("Geçersiz Sayı");
			return;
		}
		
		System.out.println(n);
		
		while (n != 1)
			System.out.println(n = n % 2 == 0 ? n / 2 : 3 * n + 1);
	}
	
	public static int factorial(int n)
	{
		int result = 1;
		
		for (int i = 2; i <= n; ++i)
			result *= i;
		
		return result;
	}
	
	public static int gcd(int a, int b)
	{
		int min = min(abs(a), abs(b));
		
		for (int i = min; i >= 2; --i)
			if (a % i == 0 && b % i == 0)
				return i;
		
		return 1;
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
	
	public static int getDigitsPowSum(int val)
	{
		int n = countDigits(val);
		int sum = 0;
		
		while (val != 0) {
			sum += pow(val % 10, n);
			val /= 10;
		}		
		
		return sum;
	}
	
	public static int getDigitsFactorialSum(int n)
	{
		int sum = 0;
		
		while (n != 0) {
			sum += factorial(n % 10);
			n /= 10;
		}
		
		return sum;
	}
	
	public static int getIndexOfPrime(int n)
	{
		int i = 1;
		int val = 2;
		
		for (;;) {
			if (val == n)
				return i;
			
			if (isPrime(val))
				++i;
			
			++val;
		}
	}
	
	public static int getNextFibonacciNumber(int val)
	{
		if (val < 0)
			return 0;
		
		int prev1 = 1, prev2 = 0, result;		
		
		for (;;) {
			result = prev1 + prev2;
			
			if (result > val)
				return result;
			
			prev2 = prev1;
			prev1 = result;
		}		
	}
	
	public static int getPrime(int n)
	{	
		int count = 0;
		int val = 2;
		
		for (;;) {
			if (isPrime(val))
				++count;
			
			if (count == n)
				return val;
			
			++val;
		}		
	}
	
	public static int mid(int a, int b, int c)
	{
		if (a <= b && b <= c || c <= b && b <= a)
			return b;
		
		if (b <= a && a <= c || c <= a && a <= b)
			return a;
		
		return c;					
	}

	public static String numberToText(int val)
	{
		//TODO:
		return numberToText3DigitsTR(val);
	}

	
	public static void printGoldbachPrimes(int val)
	{
		for (int a = 2; a < val; ++a) {
			int b = val - a;
			
			if (isPrime(a) && isPrime(b) && a <= b)
				System.out.printf("%d + %d = %d == %d%n", a, b, a + b, val);				
		}				
	}
	
	public static void printPrimeFactors(int n)
	{		
		if (n == 0)
			return;		
		
		n = abs(n);
		
		int i = 2;		
		
		while (n != 1) {
			if (n % i == 0) {
				System.out.printf("%d ", i);
				n /= i;
			}
			else
				++i;
		}		
		
		System.out.println();	
	}
	
	public static int reversed(int val)
	{
		int result = 0;
		
		while (val != 0) {
			result = result * 10 + val % 10;
			val /= 10;
		}
		
		return result;
	}
		
	
	public static int sumFactors(int val)
	{
		if (val == 1)
			return 1;
		
		int result = 0;
		int sqrtVal = (int)sqrt(val);
		
		for (int i = 2; i <= sqrtVal; ++i)
			if (val % i == 0)
				result += (i == val / i) ? i : (i + val / i);
		
		return result + 1;
	}
	
	public static boolean areFriends(int a, int b)
	{
		return sumFactors(a) == b && sumFactors(b) == a;
	}
	
	public static boolean isArmstrong(int val)
	{
		return val >= 0 && getDigitsPowSum(val) == val;		
	}
	
	public static boolean isFactorian(int n)
	{
		return n >= 0 && getDigitsFactorialSum(n) == n;
	}
	
	public static boolean isDecimalHarshad(int val)
	{
		return val > 0 && val % digitsSum(val) == 0;
	}	
	
	public static boolean isHardyRamanujan(int val)
	{
		if (val <= 0)
			return false;
		
		int count = 0;
		
		EXIT_LOOP:
			for (int x = 1; x * x * x < val; ++x)
				for (int y = x + 1; x * x * x + y * y * y <= val; ++y)
					if (x * x * x + y * y * y == val) {
						if (++count == 2)
							break EXIT_LOOP;
						++x;
					}
		return count == 2;
	}
	
	public static boolean isPerfect(int val)
	{
		return sumFactors(val) == val;
	}
	
	public static boolean isPrime(long val)
	{
		if (val <= 1)
			return false;
		
		if (val % 2 == 0)
			return val == 2;
		
		if (val % 3 == 0)
			return val == 3;
		
		if (val % 5 == 0)
			return val == 5;
		
		if (val % 7 == 0)
			return val == 7;
		
		int sqrtVal = (int)sqrt(val);
		
		for (long i = 11; i <= sqrtVal; i += 2)
			if (val % i == 0)
				return false;
		
		
		return true;
	}
	
	public static boolean isPrimeX(long val)
	{
		boolean result;
		
		for (long sum = val; (result = isPrime(sum)) && sum > 9; sum = digitsSum(sum))
			;
		
		return result;
	}
	
	public static boolean isSuperPrime(int n)
	{
		return isPrime(n) && isPrime(getIndexOfPrime(n));
	}
}