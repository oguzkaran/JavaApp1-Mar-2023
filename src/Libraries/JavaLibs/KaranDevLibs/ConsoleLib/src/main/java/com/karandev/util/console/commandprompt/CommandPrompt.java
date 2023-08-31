package com.karandev.util.console.commandprompt;

import com.karandev.util.console.Console;
import com.karandev.util.console.commandprompt.annotation.Commands;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class CommandPrompt {
    public Object m_regObject;
    private final ArrayList<MethodCallInfo> m_methodCallInfos = new ArrayList<>();
    private String m_prompt = "csd";
    private String m_suffix = "#";
    private String m_paramStringTypeErrorMessage = "Message parameters must be String";
    private String m_wrongNumberOfArgumentsMessage = "Wrong number of arguments";
    private String m_invalidCommandMessage = "Invalid Command";

    private static class MethodCallInfo {
        String commandText;
        Method method;
        int argCount;
    }

    private CommandPrompt()
    {
    }

    public static class Builder {
        private final CommandPrompt m_commandPrompt = new CommandPrompt();

        public Builder register(Object regObject)
        {
            throw new UnsupportedOperationException("Not implemented yet");
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

    public void run()
    {
        while (true) {
            var cmd = Console.read(m_prompt + m_suffix);

            if (cmd.isBlank())
                continue;
            //...
        }
    }
}
