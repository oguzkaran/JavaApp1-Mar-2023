/*----------------------------------------------------------------------
	FILE        : ThreadUtil.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 18.07.2023

	Utility class for thread operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.concurrent;

import java.util.concurrent.TimeUnit;

public final class ThreadUtil {
    private ThreadUtil()
    {
    }

    public static void sleep(long milliseconds)
    {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        }
        catch (InterruptedException ignore) {

        }
    }

    public static void sleep(long timeout, TimeUnit timeUnit)
    {
        sleep(TimeUnit.MILLISECONDS.convert(timeout, timeUnit));
    }
    //...
}
