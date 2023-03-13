package org.csystem.application.parser;

import org.csystem.util.console.CommandLineUtil;

import java.io.FileNotFoundException;
import java.io.IOException;

public final class LetterParserFileAsciiSourceApp {
    private LetterParserFileAsciiSourceApp()
    {
    }

    public static void run(String [] args)
    {
        CommandLineUtil.checkIfNotEqualAndExit(args, 1, "Wrong number of arguments");

        ParseFactory factory = new ParseFactory();

        try (FileAsciiSource fs = new FileAsciiSource(args[0])) {
            Parser parser = factory.getParser(ParserType.LETTER, fs);

            System.out.printf("Number of Letters:%d%n", parser.doParse());
        }
        catch (FileNotFoundException ignore) {
            System.err.println("File Not found");
        }
        catch (IOException ignore) {
            System.err.println();
        }

    }
}
