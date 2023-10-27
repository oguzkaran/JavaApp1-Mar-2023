/*----------------------------------------------------------------------
	FILE        : CommandPrompt.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 09.09.2023

	CommandPrompt class of REPL framework

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.io.util.console.commandprompt;

import com.karandev.io.util.console.Console;
import com.karandev.io.util.console.commandprompt.annotation.Command;
import com.karandev.io.util.console.commandprompt.annotation.ErrorCommand;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;

public class CommandPrompt {
    public Object m_regObject;
    private final ArrayList<CommandInfo> m_commandInfos = new ArrayList<>();
    private Method m_errorCommandMethod;
    private String m_prompt = "csd";
    private String m_suffix = "#";
    private String m_paramStringTypeErrorMessage = "Message parameters must be String";
    private String m_wrongNumberOfArgumentsMessage = "Wrong number of arguments";
    private String m_invalidCommandMessage = "Invalid Command";

    private static class CommandInfo {
        String commandText;
        Method method;
        int argCount;

        CommandInfo(String commandText, Method method, int argCount)
        {
            this.commandText = commandText;
            this.method = method;
            this.argCount = argCount;
        }
    }

    public static class Builder {
        private final CommandPrompt m_commandPrompt = new CommandPrompt();

        public Builder register(Object regObject)
        {
            m_commandPrompt.registerObject(regObject);

            return this;
        }

        public Builder setPrompt(String prompt)
        {
            m_commandPrompt.m_prompt = prompt;

            return this;
        }

        public Builder setSuffix(String suffix)
        {
            m_commandPrompt.m_suffix = suffix;

            return this;
        }

        public Builder setParamStringTypeErrorMessage(String paramStringTypeErrorMessage)
        {
            m_commandPrompt.m_paramStringTypeErrorMessage = paramStringTypeErrorMessage;

            return this;
        }

        public Builder setWrongNumberOfArgumentsMessage(String wrongNumberOfArgumentsMessage)
        {
            m_commandPrompt.m_wrongNumberOfArgumentsMessage = wrongNumberOfArgumentsMessage;

            return this;
        }

        public Builder setInvalidCommandMessage(String invalidMessage)
        {
            m_commandPrompt.m_invalidCommandMessage = invalidMessage;

            return this;
        }

        public CommandPrompt build()
        {
            return m_commandPrompt;
        }
    }

    private static boolean areAllString(Parameter [] parameters)
    {
        for (var param : parameters)
            if (param.getParameterizedType() != String.class)
                return false;

        return true;
    }

    private CommandPrompt()
    {
    }

    private void registerCommands(Command [] commands, Method method)
    {
        for (var command : commands) {
            var value = command.value();
            var commandText = value.isBlank() ? method.getName() : value;
            var parameters = method.getParameters();

            if (!areAllString(parameters))
                throw new IllegalArgumentException(m_paramStringTypeErrorMessage);

            m_commandInfos.add(new CommandInfo(commandText, method, parameters.length));
        }
    }

    private void runCommands(String [] args) throws InvocationTargetException, IllegalAccessException
    {
        var params = Arrays.copyOfRange(args, 1, args.length);
        var flag = false;
        var argsFlag = false;

        for (var commandInfo : m_commandInfos) {
            if (commandInfo.commandText.equals(args[0])) {
                flag = true;
                argsFlag = true;

                if (commandInfo.argCount != params.length) {
                    argsFlag = false;
                    continue;
                }

                commandInfo.method.setAccessible(true);
                commandInfo.method.invoke(m_regObject, (Object[]) params);
                commandInfo.method.setAccessible(false);
                break;
            }
        }

        if (!flag) {
            if (m_errorCommandMethod != null) {
                m_errorCommandMethod.setAccessible(true);
                m_errorCommandMethod.invoke(m_regObject);
                m_errorCommandMethod.setAccessible(false);
            }
            else
                System.err.println(m_invalidCommandMessage);
        }
        else if (!argsFlag)
            System.err.println(m_wrongNumberOfArgumentsMessage);
    }

    private void registerObject(Object regObject)
    {
        m_regObject = regObject;
        var clsRegObject = m_regObject.getClass();
        var methods = clsRegObject.getDeclaredMethods();

        for (var method : methods) {
            var commands = method.getDeclaredAnnotationsByType(Command.class);

            if (commands.length == 0) {
                if (m_errorCommandMethod == null && method.getDeclaredAnnotation(ErrorCommand.class) != null
                        && method.getParameters().length == 0)
                    m_errorCommandMethod = method;
                continue;
            }
            registerCommands(commands, method);
        }
    }

    public void setPrompt(String prompt)
    {
        m_prompt = prompt;
    }

    public void run()
    {
        try {
            while (true) {
                var cmd = Console.read(m_prompt + m_suffix);

                if (cmd.isBlank())
                    continue;

                runCommands(cmd.split("[ \t]+"));
            }
        }
        catch (Throwable ex) {
            throw new IllegalArgumentException(ex.getMessage(), ex);
        }
    }
}
