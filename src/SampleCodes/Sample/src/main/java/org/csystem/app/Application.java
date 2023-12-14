/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.io.util.console.Console;
import org.csystem.util.data.test.factory.StudentFactory;
import org.csystem.util.data.test.student.StudentInfo;

import java.io.IOException;
import java.nio.file.Path;

import static com.karandev.io.util.console.commandline.CommandLineUtil.checkLengthEquals;
import static java.util.stream.Collectors.groupingBy;

class Application {
    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 2, "Wrong number of arguments");

        try {
            var grade = Integer.parseInt(args[1]);
            var factory = StudentFactory.loadFromTextFile(Path.of(args[0]));
            var students = factory.STUDENTS;

            var map = students.stream().filter(s -> s.getMidtermGrade() * 0.4 + s.getFinalGrade() * 0.6 > grade)
                    .collect(groupingBy(StudentInfo::getLecture));

            map.keySet().forEach(lec -> {Console.writeLine(lec); map.get(lec).forEach(Console::writeLine);});
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid grade value!...");
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO problem occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Problem occurred:%s", ex.getClass().getName());
        }
    }
}
