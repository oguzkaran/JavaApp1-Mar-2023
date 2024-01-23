package com.haticekubraulusoy.app.parser;

import com.baturhansahin.parser.PalindromeParser;
import com.boraserce.parser.source.StandardInputSource;
import org.csystem.util.console.Console;
import org.csystem.util.thread.ThreadUtil;

public class DemoApp {
    public static void run()
    {

        while (true) {
            try {
                PalindromeParser parser = new PalindromeParser(new StandardInputSource());

                parser.parse();

                Console.writeLine("Text:%s", parser.getText());
                Console.writeLine(parser.isPalindrome() ? "Palindrome" : "Not a palindrome");
            }
            catch (Exception ignore) {
                Console.writeLine("Problem occurs!...");
            }
            ThreadUtil.sleep(1000);
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
