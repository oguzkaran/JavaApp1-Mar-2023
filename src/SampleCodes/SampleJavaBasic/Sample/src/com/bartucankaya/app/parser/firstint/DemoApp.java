package com.bartucankaya.app.parser.firstint;

import com.fatihkarabulut.parser.FirstIntValueParser;
import com.karandev.parser.source.factory.SourceFactory;
import org.csystem.util.console.Console;
import org.csystem.util.thread.ThreadUtil;

public class DemoApp {
    public static void run()
    {
        SourceFactory factory = new SourceFactory();
        FirstIntValueParser parser = new FirstIntValueParser();

        while (true) {
            try {
                parser.parse(factory.create());

                Console.writeLine("First Int Value is %d", parser.getValue());
            }
            catch (NumberFormatException ignore) {
                Console.writeLine("Can not get any int value from source!...");
            }
            ThreadUtil.sleep(1000);
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
