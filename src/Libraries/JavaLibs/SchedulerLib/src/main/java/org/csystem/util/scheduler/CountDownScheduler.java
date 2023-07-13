/*----------------------------------------------------------------------
	FILE        : CountDownScheduler.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 13.07.2023

	CountDownScheduler class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.scheduler;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.*;

public abstract class CountDownScheduler {
    private final Timer m_timer;
    private final long m_millisInFuture;
    private final long m_interval;

    private TimerTask createTimerTask()
    {
        return new TimerTask() {
            long value;

            public void run()
            {
                onTick(m_millisInFuture - value);
                value += m_interval;

                if (value < m_millisInFuture)
                    return;

                onFinish();
                m_timer.cancel();
            }
        };
    }

    protected CountDownScheduler(long millisInFuture, long interval)
    {
        this(millisInFuture, interval, TimeUnit.MILLISECONDS);
    }

    protected CountDownScheduler(long durationInFuture, long interval, TimeUnit timeUnit)
    {
        m_millisInFuture = timeUnit == MILLISECONDS ? durationInFuture : timeUnit.toMillis(durationInFuture);
        m_interval = timeUnit == MILLISECONDS ? interval : timeUnit.toMillis(interval);
        m_timer = new Timer();
    }

    protected abstract void onTick(long millisUntilFinished);
    protected abstract void onFinish();

    public final CountDownScheduler start()
    {
        m_timer.scheduleAtFixedRate(createTimerTask(), 0, m_interval);

        return this;
    }

    public final void cancel()
    {
        m_timer.cancel();
    }
}
