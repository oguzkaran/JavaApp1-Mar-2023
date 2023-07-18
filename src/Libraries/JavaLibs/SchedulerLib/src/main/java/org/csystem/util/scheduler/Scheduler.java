/*----------------------------------------------------------------------
	FILE        : Scheduler.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 18.07.2023

	CountDownSchedulerEx class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.scheduler;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Scheduler {
    public Scheduler(long period)
    {
        this(0, period);
    }

    public Scheduler(long delay, long period)
    {
        this(delay, period, MILLISECONDS);
    }

    public Scheduler(long period, TimeUnit timeUnit)
    {
        this(0, period, timeUnit);
    }

    public Scheduler(long delay, long period, TimeUnit timeUnit)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Scheduler schedule(Runnable task)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Scheduler schedule(Runnable task, Runnable cancelTask)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public final void cancel()
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
