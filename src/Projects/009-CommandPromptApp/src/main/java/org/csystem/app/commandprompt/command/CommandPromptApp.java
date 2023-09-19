package org.csystem.app.commandprompt.command;

import com.karandev.util.console.Console;
import com.karandev.util.console.commandprompt.CommandPrompt;
import com.karandev.util.console.commandprompt.annotation.Command;
import com.karandev.util.console.commandprompt.annotation.Commands;
import com.karandev.util.console.commandprompt.annotation.ErrorCommand;
import org.csystem.io.file.directory.DirectoryList;

import java.io.*;
import java.nio.file.*;
import java.util.random.RandomGenerator;

public class CommandPromptApp {
    private static final String [] COMMANDS =
            {"ls, list, dir", "cp, copy", "append_rand_bytes, arb", "quit, exit", "help, ?", "read_bytes, rb"};
    private final CommandPrompt m_commandPrompt;
    private final RandomGenerator m_randomGenerator;

    private void doListForEachCallback(File file)
    {
        Console.writeLine("%s %s", file.getName(), file.isDirectory() ? "<DIR>" : String.valueOf(file.length()));
    }

    @Command("ls")
    @Command("dir")
    @Command
    private void list()
    {
        list(".");
    }
    
    private void doList(Path path)
    {
        try {
            new DirectoryList(path).forEach(this::doListForEachCallback);
        }
        catch (NotDirectoryException ignore) {
            Console.Error.writeLine("'%s' is not a directory", path);
        }
        catch (IOException ex) {
            Console.Error.writeLine(ex.getMessage());
        }
    }

    @Command("ls")
    @Command("dir")
    @Command
    private void list(String pathStr)
    {
        try {
            var path = Path.of(pathStr);

            if (Files.exists(path))
                doList(path);
            else
                Console.Error.writeLine("'%s' not exists", path);
        }
        catch (InvalidPathException ex) {
            Console.Error.writeLine(ex.getMessage());
        }

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

    @Command("append_rand_bytes")
    @Command("arb")
    private void appendRandomBytes(String path, String countStr)
    {
        try (var fos = new FileOutputStream(path, true)) {
            var bytes = new byte[Integer.parseUnsignedInt(countStr)];

            m_randomGenerator.nextBytes(bytes);
            fos.write(bytes);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid count value");
        }
        catch (IOException ex) {
            Console.Error.writeLine("I/O Problem occurs:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("General Problem occurs:%s", ex.getMessage());
        }
    }

    @Command("read_byes")
    @Command("rb")
    private void readBytes(String path)
    {
        try (var fis = new FileInputStream(path)) {
            int value;

            while ((value = fis.read()) != -1)
                Console.write("%d ", value);

            Console.writeLine();
        }
        catch (FileNotFoundException ignore) {
            Console.Error.writeLine("'%s' not found", path);
        }
        catch (IOException ex) {
            Console.Error.writeLine("I/O Problem occurs:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("General Problem occurs:%s", ex.getMessage());
        }
    }

    @Command("?")
    @Command
    private void help()
    {
        for (var str : COMMANDS)
            Console.writeLine("%s -> ", str);
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
        System.out.println("Invalid command!...");
    }

    public CommandPromptApp(String prompt, RandomGenerator randomGenerator)
    {
        m_commandPrompt = new CommandPrompt.Builder()
                .setPrompt(prompt)
                .setSuffix(">")
                .register(this)
                .build();

        m_randomGenerator = randomGenerator;
    }

    public void run()
    {
        m_commandPrompt.run();
    }
}

