package org.csystem.app.commandprompt.command;

import com.karandev.util.console.Console;
import com.karandev.util.console.commandprompt.CommandPrompt;
import com.karandev.util.console.commandprompt.annotation.Command;
import com.karandev.util.console.commandprompt.annotation.Commands;
import com.karandev.util.console.commandprompt.annotation.ErrorCommand;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CommandPromptApp {
    private final CommandPrompt m_commandPrompt;
    //...

    @Command("ls")
    @Command("dir")
    @Command
    private void list()
    {
        list(".");
    }

    private void doList(File dir)
    {
        var files = dir.listFiles();

        if (files != null)
            for (var file : files)
                Console.writeLine("%s %s", file.getName(), file.isDirectory() ? "<DIR>" : String.valueOf(file.length()));
        else
            Console.Error.writeLine("'%s' is not a directory", dir.getName());
    }

    @Command("ls")
    @Command("dir")
    @Command
    private void list(String path)
    {
        var dir = new File(path);

        if (dir.exists())
            doList(dir);
        else
            Console.Error.writeLine("'%s' not exists", dir.getName());
    }

    private boolean checkFileIfExists(Path source)
    {
        return Files.exists(source);
    }

    @Commands({@Command("cp"), @Command})
    private void copy(String source, String dest)
    {
        try {
            var sourcePath = Path.of(source);
            var destPath = Path.of(dest);

            if (checkFileIfExists(sourcePath))
                Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
            else
                Console.Error.writeLine("%s not exists", sourcePath.getFileName());
        }
        catch (IOException ignore) {
            Console.Error.writeLine("I/O problem occurs");
        }
        catch (InvalidPathException ex) {
            Console.Error.writeLine("%s is not valid for path", ex.getInput());
        }
    }

    @Command
    private void change(String prompt)
    {
        m_commandPrompt.setPrompt(prompt);
    }

    @Command("quit")
    @Command
    private void exit()
    {
        Console.writeLine("C and System Programmers Association");
        System.exit(0);
    }

    @ErrorCommand
    private void error()
    {
        System.out.println("Error");
    }

    public CommandPromptApp(String prompt)
    {
        m_commandPrompt = new CommandPrompt.Builder()
                .setPrompt(prompt)
                .setSuffix(">")
                .register(this)
                .build();
    }

    public void run()
    {
        m_commandPrompt.run();
    }
}

