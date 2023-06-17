/*----------------------------------------------------------------------
	FILE        : StringUtil.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 06.05.2023

	Utility class for string operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.string;

import java.util.ArrayList;
import java.util.Random;

public final class StringUtil {
    private static final String ALPHABET_TR;
    private static final String ALPHABET_EN;
    private static final String ALPHABET_CAPITALS_TR;
    private static final String ALPHABET_CAPITALS_EN;
    private static final String ALPHABET_ALL_EN;
    private static final String ALPHABET_ALL_TR;

    static {
        ALPHABET_TR = "abcçdefgğhıijklmnoöprsştuüvyz";
        ALPHABET_EN = "abcdefghijklmnopqrstuwxvyz";
        ALPHABET_CAPITALS_TR = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ";
        ALPHABET_CAPITALS_EN = "ABCDEFGHIJKLMNOPQRSTUWXVYZ";
        ALPHABET_ALL_TR = ALPHABET_TR + ALPHABET_CAPITALS_TR;
        ALPHABET_ALL_EN = ALPHABET_EN + ALPHABET_CAPITALS_EN;
    }

    private StringUtil()
    {
    }

    public static String changeCase(String s)
    {
        var sb = new StringBuilder(s);

        for (var i = 0; i < sb.length(); ++i) {
            char c = sb.charAt(i);
            sb.setCharAt(i, Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
        }

        return sb.toString();
    }
    
    public static int countString(String s1, String s2)
    {
        int count = 0;

        for (int i = 0; (i= s1.indexOf(s2, i)) != -1; ++i, ++count)
            ;

        return count;
    }

    public static int countStringIgnoreCase(String s1, String s2)
    {
        return countString(s1.toLowerCase(), s2.toLowerCase());
    }

    public static void fillRandomStringArray(Random r, String [] str, int min, int max, String sourceText)
    {
        for (int i = 0; i < str.length; ++i)
            str[i] = getRandomText(r, r.nextInt(max - min + 1) + min, sourceText);
    }

    public static void fillRandomStringArrayTR(Random r, String [] str, int min, int max)
    {
        fillRandomStringArray(r, str, min, max, ALPHABET_ALL_TR);
    }

    public static void fillRandomStringArrayEN(Random r, String [] str, int min, int max)
    {
        fillRandomStringArray(r, str, min, max, ALPHABET_ALL_EN);
    }

    public static String getLetters(String s)
    {
        var sb = new StringBuilder(s.length());
        var len = s.length();

        for (var i = 0; i < len; ++i) {
            char c = s.charAt(i);

            if (Character.isLetter(c))
                sb.append(c);
        }

        return sb.toString();
    }

    public static String getRandomText(Random r, int n, String sourceText)
    {
        var sb = new StringBuilder(n);
        var length = sourceText.length();

        for (int i = 0; i < n; ++i)
            sb.append(sourceText.charAt(r.nextInt(length)));

        return sb.toString();
    }

    public static String getRandomTextEN(Random r, int n)
    {
        return getRandomText(r, n, ALPHABET_ALL_TR);
    }

    public static String getRandomTextEN(int n)
    {
        return getRandomTextEN(new Random(), n);
    }

    public static String getRandomTextTR(Random r, int n)
    {
        return getRandomText(r, n, ALPHABET_ALL_EN);
    }

    public static String getRandomTextTR(int n)
    {
        return getRandomTextTR(new Random(), n);
    }

    public static String [] getRandomStringArrayTR(int n, int min, int max)
    {
        return getRandomStringArrayTR(new Random(), n, min, max);
    }

    public static String [] getRandomStringArrayTR(Random r, int n, int min, int max)
    {
        String [] result = new String[n];

        fillRandomStringArrayTR(r, result, min, max);

        return result;
    }

    public static String [] getRandomStringArrayEN(int n, int min, int max)
    {
        return getRandomStringArrayEN(new Random(), n, min, max);
    }

    public static String [] getRandomStringArrayEN(Random r, int n, int min, int max)
    {
        String [] result = new String[n];

        fillRandomStringArrayEN(r, result, min, max);

        return result;
    }

    public static boolean isJavaIdentifier(String s)
    {
        if (s.isBlank() || s.equals("_"))
            return false;

        char ch = s.charAt(0);

        if (!Character.isJavaIdentifierStart(ch))
            return false;

        int length = s.length();

        for (int i = 1; i < length; ++i)
            if (!Character.isJavaIdentifierPart(s.charAt(i)))
                return false;

        return true;
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

    public static boolean isPangram(String text, String alphabet)
    {
        int length = alphabet.length();

        for (int i = 0; i < length; ++i)
            if (!text.contains(String.valueOf(alphabet.charAt(i))))
                return false;

        return true;
    }

    public static boolean isPangramTR(String s)
    {
        return isPangram(s.toLowerCase(), "abcçdefgğhıijklmnoöprsştuüvyz");
    }

    public static boolean isPangramEN(String s)
    {
        return isPangram(s.toLowerCase(), "abcdefghijklmnopqrstuvwxyz");
    }

    public static String join(String [] str)
    {
        return join(str, ' ', false);
    }

    public static String join(String [] str, boolean removeEmpties)
    {
        return join(str, ' ', removeEmpties);
    }

    public static String join(String [] str, char delimiter)
    {
        return join(str, String.valueOf(delimiter), false);
    }

    public static String join(String [] str, char delimiter, boolean removeEmpties)
    {
        return join(str, String.valueOf(delimiter), removeEmpties);
    }

    public static String join(String [] str, String delimiter)
    {
        return join(str, delimiter, false);
    }

    public static String join(String [] str, String delimiter, boolean removeEmpties)
    {
        var sb = new StringBuilder();

        for (var s : str) {
            if (removeEmpties && s.isEmpty())
                continue;

            sb.append(s).append(delimiter);
        }

        return sb.substring(0, sb.length() - delimiter.length());
    }

    public static String join(ArrayList<String> list, char delimiter)
    {
        return join(list, delimiter, false);
    }

    public static String join(ArrayList<String> list, char delimiter, boolean removeEmpties)
    {
        return join(list, String.valueOf(delimiter), removeEmpties);
    }

    public static String join(ArrayList<String> list, String delimiter)
    {
        return join(list, delimiter, false);
    }

    public static String join(ArrayList<String> list, String delimiter, boolean removeEmpties)
    {
        var sb = new StringBuilder();

        for (var s : list) {
            if (removeEmpties && s.isEmpty())
                continue;

            sb.append(s).append(delimiter);
        }

        return sb.substring(0, sb.length() - delimiter.length());
    }

    public static String padLeading(String s, int length, char ch)
    {
        int len = s.length();

        return length <= len ? s : String.valueOf(ch).repeat(length - len) + s;
    }

    public static String padLeading(String s, int length)
    {
        return padLeading(s, length, ' ');
    }

    public static String padTrailing(String s, int length, char ch)
    {
        int len = s.length();

        return length <= len ? s : s + String.valueOf(ch).repeat(length - len);
    }

    public static String padTrailing(String s, int length)
    {
        return padTrailing(s, length, ' ');
    }

    public static String reverse(String s)
    {
        return new StringBuilder(s).reverse().toString();
    }

    public static String squeeze(String s1, String s2)
    {
        var length = s1.length();
        var sb = new StringBuilder(length);

        for (int i = 0; i < length; ++i) {
            char ch = s1.charAt(i);

            if (!s2.contains(String.valueOf(ch)))
                sb.append(ch);
        }

        return sb.toString();
    }

    public static String wrapWith(String str, String leading, String trailing)
    {
        return String.format("%s%s%s", leading, str.trim(), trailing);
    }
    
    public static String wrapWith(String str, char leading, char trailing)
    {
        return wrapWith(str, String.valueOf(leading), String.valueOf(trailing));
    }
    
    public static String wrapWith(String str, String wrapper)
    {
        return wrapWith(str, wrapper, wrapper);
    }
    
    public static String wrapWith(String str, char wrapper)
    {
        return wrapWith(str, wrapper, wrapper);
    }
    
    public static String wrapWithBraces(String str)
    {
        return wrapWith(str, '(', ')');
    }    
}
