package org.csystem.app;

import com.karandev.util.console.Console;

import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.karandev.util.console.commandline.CommandLineUtil.checkLengthEquals;

class Application {
    private static String getParameterList(Parameter [] parameters)
    {
        return Stream.of(parameters).map(Parameter::getType)
                .map(Class::getSimpleName).collect(Collectors.joining(", "));
    }

    private static void printMethods(Class<?> cls)
    {
        var methods = cls.getMethods();

        if (methods.length == 0)
            return;

        Console.writeLine("Methods");
        for (var method : methods) {
            Console.writeLine("%s %s(%s)", method.getReturnType().getSimpleName(),
                    method.getName(), getParameterList(method.getParameters()));
        }
    }

    private static void printFields(Class<?> cls)
    {
        var fields = cls.getFields();
        if (fields.length == 0)
            return;

        Console.writeLine("Fields");
        for (var field : fields)
            Console.writeLine("%s%s %s", Modifier.isStatic(field.getModifiers()) ? "static " : "", field.getType().getSimpleName(), field.getName());
    }

    private static void printConstructors(Class<?> cls)
    {
        var ctors = cls.getConstructors();

        if (ctors.length == 0)
            return;

        Console.writeLine("Constructors");
        for (var ctor : ctors)
            Console.writeLine("%s(%s)", ctor.getName(), getParameterList(ctor.getParameters()));
    }

    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments!...");

        try {
            var cls = Class.forName(args[0]);

            printFields(cls);
            printConstructors(cls);
            printMethods(cls);
        }
        catch (ClassNotFoundException ignore) {
            Console.Error.writeLine("%s not found", args[0]);
        }
    }
}
