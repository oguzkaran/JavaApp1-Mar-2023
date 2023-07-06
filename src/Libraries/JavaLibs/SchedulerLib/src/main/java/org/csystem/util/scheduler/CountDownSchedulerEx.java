/*----------------------------------------------------------------------
	FILE        : CountDownSchedulerEx.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 06.07.2023

	CountDownScheduler class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.scheduler;

public abstract class CountDownSchedulerEx extends CountDownScheduler {
    protected CountDownSchedulerEx(long millisInFuture, long interval)
    {
        super(millisInFuture, interval);
        throw new UnsupportedOperationException("TODO");
    }

    protected abstract void onStart();

    public final CountDownSchedulerEx startScheduler()
    {
        throw new UnsupportedOperationException("TODO");
    }

}
