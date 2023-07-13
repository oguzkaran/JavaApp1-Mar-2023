/*----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.scheduler.CountDownScheduler;

import java.util.concurrent.TimeUnit;

class Application {
    public static void run(String [] args)
    {
        new CountDownScheduler(10, 1, TimeUnit.SECONDS) {
            protected void onTick(long millisUntilFinished)
            {
                System.out.printf("%d\r", millisUntilFinished / 1000);
            }

            protected void onFinish()
            {
                System.out.println("00");
            }
        }.start();
    }
}
