/*----------------------------------------------------------
	FILE			: StringUtil.java
	AUTHOR			: Java-Nov-2022 Group
	LAST UPDATE		: 14.07.2023
	
	Utility class for string operations
	
	Copyleft (c) 1993 C and System Programmers Association 
	All Rights Free
------------------------------------------------------------*/
package org.csystem.util.string;

import java.util.random.RandomGenerator;

public final class StringUtil {
	private static final String LETTERS_TR = "abcçdefgğhıijklmnoöprsştuüvyz";
	private static final String LETTERS_EN = "abcdefghijklmnopqrstuwxvyz";
	private static final String LETTERS_CAPITAL_TR = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ";
	private static final String LETTERS_CAPITAL_EN = "ABCDEFGHIJKLMNOPQRSTUWXYZ";
	private static final String LETTERS_ALL_TR = LETTERS_TR + LETTERS_CAPITAL_TR;
	private static final String LETTERS_ALL_EN = LETTERS_EN + LETTERS_CAPITAL_EN;

	private StringUtil()
	{
	}

	public static String capitalize(String s)
	{
		return s.isEmpty() ? "" : Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
	}

	public static String changeCase(String s)
	{
		StringBuilder sb = new StringBuilder(s);

		int len = sb.length();

		for (int i = 0; i < len; ++i) {
			char ch = sb.charAt(i);
			sb.setCharAt(i, Character.isUpperCase(ch) ? Character.toLowerCase(ch) : Character.toUpperCase(ch));
		}

		return sb.toString();
	}

	public static int countString(String s1, String s2)
	{
		int count = 0;

		for (int index = -1; (index = s1.indexOf(s2, index + 1)) != -1; ++count)
			;

		return count;
	}

	public static int countStringIgnoreCase(String s1, String s2)
	{
		return countString(s1.toLowerCase(), s2.toLowerCase());
	}

	public static String getRandomText(RandomGenerator randomGenerator, int n, String text)
	{
		StringBuilder sb = new StringBuilder(n);
		int len = text.length();

		for (int i = 0; i < n; ++i)
			sb.append(text.charAt(randomGenerator.nextInt(len)));

		return sb.toString();
	}

	public static String getRandomTextEN(RandomGenerator randomGenerator, int n)
	{
		return getRandomText(randomGenerator, n, LETTERS_ALL_EN);
	}

	public static String getRandomTextTR(RandomGenerator randomGenerator, int n)
	{
		return getRandomText(randomGenerator, n, LETTERS_ALL_TR);
	}

	public static boolean isPalindrome(String s)
	{
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			char cLeft = Character.toLowerCase(s.charAt(left));

			if (!Character.isLetter(cLeft)) {
				++left;
				continue;
			}

			char cRight = Character.toLowerCase(s.charAt(right));

			if (!Character.isLetter(cRight)) {
				--right;
				continue;
			}

			if (cLeft != cRight)
				return false;

			++left;
			--right;
		}

		return true;
	}

	public static boolean isPangram(String s, String alphabet)
	{
		int len = alphabet.length();

		for (int i = 0; i < len; ++i)
			if (!s.contains(String.valueOf(alphabet.charAt(i))))
				return false;

		return true;
	}

	public static boolean isPangramEN(String s)
	{
		return isPangram(s.toLowerCase(), LETTERS_EN);
	}

	public static boolean isPangramTR(String s)
	{
		return isPangram(s.toLowerCase(), LETTERS_TR);
	}

	public static String join(String [] str, String delimiter, boolean skipBlanks)
	{
		StringBuilder sb = new StringBuilder();

		for (String s : str) {
			if (skipBlanks && s.isBlank())
				continue;

			sb.append(s).append(delimiter);
		}

		return sb.substring(0, sb.length() - delimiter.length());
	}
	public static String join(String [] str, String delimiter)
	{
		return join(str, delimiter, false);
	}

	public static String join(String [] str, char delimiter)
	{
		return join(str, String.valueOf(delimiter));
	}

	public static String join(String [] str, char delimiter, boolean skipBlanks)
	{
		return join(str, String.valueOf(delimiter), skipBlanks);
	}

	public static String padLeading(String s, int len)
	{
		return padLeading(s, len, ' ');
	}

	public static String padLeading(String s, int len, char ch)
	{
		int length = s.length();

		return len <= length ? s : String.valueOf(ch).repeat(len - length) + s;
	}

	public static String padTrailing(String s, int len)
	{
		return padTrailing(s, len, ' ');
	}

	public static String padTrailing(String s, int len, char ch)
	{
		int length = s.length();

		return len <= length ? s : s + String.valueOf(ch).repeat(len - length);
	}

	public static String reverse(String str)
	{
		return new StringBuilder(str).reverse().toString();
	}
}

