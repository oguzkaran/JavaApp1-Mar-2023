/*----------------------------------------------------------------------------------------------------------------------
    Override "retention policy"'si SOURCE olan ve yalnızca metot bildirimlerinde kullanılabilen bir annotation'dır. Bu
    annotation'ın elemanı yoktur. Bu annotation, metodun override edilip edilemeyeceğinin derleme zamanında kontrolü
    için kullanılır. Eğer metot override edilemiyor ise error oluşur. Override SOURCE bir annotation olduğu için byte code'a
    yazılmaz. Bu anlamda byte code'un içerisinde yer kaplamaz. Bu annotation'ın kullanım zorunluluğu yoktur. Ancak her
    override işleminde her zaman kullanılmalıdır. Bu annotation'ın okunabilirliği artırır. 
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.app.company.Employee;

import java.time.LocalDate;
import java.time.Month;

class Application {
    public static void run(String [] args)
    {
        var employee1 = new Employee("Ümit", "Yasin", "Çoban", LocalDate.of(1997, Month.OCTOBER, 15));
        var employee2 = new Employee("Baturhan", "Şahin", LocalDate.of(1994, Month.OCTOBER, 13));

        Console.writeLine(employee1);
        Console.writeLine(employee2);

        Console.writeLine(employee1.getSecretFullName('X'));
        Console.writeLine(employee2.getSecretFullName('X'));
    }
}


