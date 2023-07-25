/*----------------------------------------------------------------------
	FILE        : CountDownSchedulerEx.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 25.07.2023

	CountDownSchedulerEx class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.scheduler;

import java.util.concurrent.TimeUnit;

public abstract class CountDownSchedulerEx extends CountDownScheduler {
    protected CountDownSchedulerEx(long millisInFuture, long interval)
    {
        this(millisInFuture, interval, TimeUnit.MILLISECONDS);
    }

    protected CountDownSchedulerEx(long durationInFuture, long interval, TimeUnit timeUnit)
    {
        super(durationInFuture, interval, timeUnit);
    }

    protected abstract void onStart() throws Exception;

    public final CountDownSchedulerEx startScheduler()
    {
        try {
            onStart();
        }
        catch (Exception ignore) {

        }
        start();

        return this;

    }
}
