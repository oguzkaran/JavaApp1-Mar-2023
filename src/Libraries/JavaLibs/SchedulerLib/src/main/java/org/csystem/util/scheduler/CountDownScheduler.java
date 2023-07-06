/*----------------------------------------------------------------------
	FILE        : CountDownScheduler.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 06.07.2023

	CountDownScheduler class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.scheduler;

public abstract class CountDownScheduler {
    protected CountDownScheduler(long millisInFuture, long interval)
    {
        throw new UnsupportedOperationException("TODO");
    }

    protected abstract void onTick(long millisUntilFinished);
    protected abstract void onFinish();

    public final CountDownScheduler start()
    {
        throw new UnsupportedOperationException("TODO");
    }

    public final void cancel()
    {
        throw new UnsupportedOperationException("TODO");
    }
}
