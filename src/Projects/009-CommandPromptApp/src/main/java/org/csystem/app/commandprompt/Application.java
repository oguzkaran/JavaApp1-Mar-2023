package org.csystem.app.commandprompt;

import org.csystem.app.commandprompt.command.CommandPromptApp;

import java.util.Random;

import static com.karandev.util.console.commandline.CommandLineUtil.checkLengthEquals;

class Application {
    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments!...");
        var app = new CommandPromptApp(args[0], new Random());

        app.run();
    }
}
