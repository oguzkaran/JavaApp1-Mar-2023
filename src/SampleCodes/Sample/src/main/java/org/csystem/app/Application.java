/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki problem SchedulerLib kütüphanesinin 14.2.0 versiyonunda IRunnable arayüzü eklenerek ortadan kaldırılmıştır.
    Bu bir yaklaşımdır. Bu şekilde olmaması da anlamlı olabilir. yani SchedulerLib'in önceki versiyonlarındaki sınıflar da
    kötü tasarlanmamıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.math.MathUtil;
import org.csystem.util.scheduler.Scheduler;

import java.util.Random;

class Application {

    public static void run(String [] args)
    {
        var scheduler = new Scheduler(1000);
        var random = new Random();

        scheduler.schedule(() -> Console.writeLine("%f", MathUtil.sqrt(random.nextDouble(0, 23.4))));
    }
}
