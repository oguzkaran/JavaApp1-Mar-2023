/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte komut satırından alınan bir tarihten önce sisteme girmiş olanların yaş ortalamları bölümlenmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.io.util.console.Console;
import org.csystem.util.data.test.factory.PersonFactory;
import org.csystem.util.data.test.people.MaritalStatus;
import org.csystem.util.data.test.people.Person;

import java.io.IOException;
import java.nio.file.Path;
import java.time.format.DateTimeParseException;
import static java.util.stream.Collectors.*;

import static com.karandev.io.util.console.commandline.CommandLineUtil.checkLengthEquals;

class Application {
    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 2, "Wrong number of arguments");

        try {
            var age = Double.parseDouble(args[1]);
            var factory = PersonFactory.loadFromTextFile(Path.of(args[0]));
            var people = factory.PEOPLE;

            var map = people.stream().filter(p -> p.getAge() < age)
                    .collect(groupingBy(Person::getMaritalStatus));

            Console.writeLine("Single People:");
            map.get(MaritalStatus.SINGLE).forEach(Console::writeLine);
            Console.writeLine("Married People:");
            map.get(MaritalStatus.MARRIED).forEach(Console::writeLine);
            Console.writeLine("Divorced People:");
            map.get(MaritalStatus.DIVORCED).forEach(Console::writeLine);
            Console.writeLine("Widow People:");
            map.get(MaritalStatus.WIDOW).forEach(Console::writeLine);
        }
        catch (DateTimeParseException ignore) {
            Console.Error.writeLine("Invalid date values!...");
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO problem occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Problem occurred:%s", ex.getClass().getName());
        }
    }
}
