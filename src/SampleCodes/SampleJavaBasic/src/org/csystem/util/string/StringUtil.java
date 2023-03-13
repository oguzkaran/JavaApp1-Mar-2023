/*----------------------------------------------------------------------
	FILE        : StringUtil.java
	AUTHOR      : Java-May-2021 Group
	LAST UPDATE : 21.01.2022

	Utility class for string operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.string;

import org.csystem.util.array.ArrayUtil;

import java.util.ArrayList;
import java.util.Random;

public final class StringUtil {
    private static final String ms_alphabetTR;
    private static final String ms_alphabetEN;

    static {
        ms_alphabetTR = "abcçdefgğhıijklmnoöprsştuüvyzABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ";
        ms_alphabetEN = "abcdefghijklmnopqrstuwxvyzABCDEFGHIJKLMNOPQRSTUWXVYZ";
    }

    private StringUtil()
    {
    }
    public static String capitalize(String s)
    {
        return s.isEmpty() ? "" : Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    public static String capitalizeWS(String s)
    {
        int i;
        int length = s.length();

        for (i = 0; i < length && Character.isWhitespace(s.charAt(i)); ++i)
            ;

        return i == length ? s : s.substring(0, i) + Character.toUpperCase(s.charAt(i)) + s.substring(i + 1).toLowerCase();
    }

    public static String changeCase(String s)
	{
		char [] c = s.toCharArray();
		
		for (int i = 0; i < c.length; ++i)
		    c[i] = Character.isUpperCase(c[i]) ? Character.toLowerCase(c[i]) : Character.toUpperCase(c[i]);
		
		return String.valueOf(c);
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
        fillRandomStringArray(r, str, min, max, ms_alphabetTR);
    }

    public static void fillRandomStringArrayEN(Random r, String [] str, int min, int max)
    {
        fillRandomStringArray(r, str, min, max, ms_alphabetEN);
    }

    public static String getLetters(String s)
    {
        String str = "";

        char [] chars = s.toCharArray();

        for (char c : chars)
            if (Character.isLetter(c))
                str += c; // İleride daha etkin olacak

        return str;
    }

    public static String getLongestPalindrome(String text)
    {
        String result = "";

        int end = text.length();

        while (end != 0) {
            int begin = 0;

            while (begin != end) {
                String str = text.substring(begin++, end);

                if (str.length() > 1 && isPalindrome(str) && str.length() > result.length())
                    result = str;
            }

            --end;
        }

        return result;
    }

    public static String getRandomText(Random r, int n, String sourceText)
    {
        int length = sourceText.length();
        char [] c = new char[n];

        for (int i = 0; i < n; ++i)
            c[i] = sourceText.charAt(r.nextInt(length));

        return String.valueOf(c);
    }

    public static String getRandomTextEN(Random r, int n)
    {
        return getRandomText(r, n, ms_alphabetTR);
    }

    public static String getRandomTextEN(int n)
    {
        return getRandomTextEN(new Random(), n);
    }

    public static String getRandomTextTR(Random r, int n)
    {
        return getRandomText(r, n, ms_alphabetEN);
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
            if (!text.contains(alphabet.charAt(i) + ""))
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
        return join(str, delimiter + "", false);
    }

    public static String join(String [] str, char delimiter, boolean removeEmpties)
    {
        return join(str, delimiter + "", removeEmpties);
    }

    public static String join(String [] str, String delimiter)
    {
        return join(str, delimiter, false);
    }

    public static String join(String [] str, String delimiter, boolean removeEmpties)
    {
        String result = "";

        for (String s : str) {
            if (removeEmpties && s.isEmpty())
                continue;

            result += s + delimiter;
        }

        return result.substring(0, result.length() - delimiter.length());
    }

    public static String join(ArrayList<String> list, char delimiter)
    {
        return join(list, delimiter, false);
    }

    public static String join(ArrayList<String> list, char delimiter, boolean removeEmpties)
    {
        return join(list, delimiter + "", removeEmpties);
    }

    public static String join(ArrayList<String> list, String delimiter)
    {
        return join(list, delimiter, false);
    }

    public static String join(ArrayList<String> list, String delimiter, boolean removeEmpties)
    {
        String result = "";

        for (String s : list) {
            if (removeEmpties && s.isEmpty())
                continue;

            result += s + delimiter;
        }

        return result.substring(0, result.length() - delimiter.length());
    }

    public static String padLeading(String s, int length, char ch)
    {
        int len = s.length();

        return length <= len ? s : repeat(length - len, ch) + s;
    }

    public static String padLeading(String s, int length)
    {
        return padLeading(s, length, ' ');
    }

    public static String padTrailing(String s, int length, char ch)
    {
        int len = s.length();

        return length <= len ? s : s + repeat(length - len, ch);
    }

    public static String padTrailing(String s, int length)
    {
        return padTrailing(s, length, ' ');
    }    

    public static String repeat(int count, char ch)
    {
    	return String.format("%0" + count + "d", 0).replace('0', ch);
    }

    public static String reversed(String s)
    {
        char [] c = s.toCharArray();

        ArrayUtil.reverse(c);

        return String.valueOf(c);
    }

    public static String squeeze(String s1, String s2)
	{
		String str = "";
		int length = s1.length();

		for (int i = 0; i < length; ++i) {
			char ch = s1.charAt(i);
			
			if (!s2.contains(ch + ""))
				str += ch;
		}			
		
		return str;
	}
    
    public static String trimLeading(String s)
    {
        int i;
        int length = s.length();

        for (i = 0;  i < length && Character.isWhitespace(s.charAt(i)); ++i)
            ;

        return s.substring(i);

    }

    public static String trimTrailing(String s)
    {
        int i;

        for (i = s.length() - 1; i >= 0 && Character.isWhitespace(s.charAt(i)); --i)
            ;

        return s.substring(0, i + 1);
    }
    
    public static String wrapWith(String str, String leading, String trailing)
    {
    	return String.format("%s%s%s", leading, str.trim(), trailing);
    }
    
    public static String wrapWith(String str, char leading, char trailing)
    {
    	return wrapWith(str, leading + "", trailing + "");
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
