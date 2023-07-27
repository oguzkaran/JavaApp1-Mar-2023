/*----------------------------------------------------------------------
	FILE        : Scheduler.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 25.07.2023

	Scheduler class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.scheduler;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Scheduler {
    private final long m_delay;
    private final long m_period;
    private final Timer m_timer;
    private Runnable m_cancelTask;

    private TimerTask createTimerTask(IRunnable task)
    {
        return new TimerTask() {
            @Override
            public void run()
            {
                try {
                    task.run();
                }
                catch (Exception ignore) {

                }
            }
        };
    }

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
        m_delay = timeUnit != MILLISECONDS ? MILLISECONDS.convert(delay, timeUnit) : delay;
        m_period = timeUnit != MILLISECONDS ? MILLISECONDS.convert(period, timeUnit) : period;
        m_timer = new Timer();
    }

    public Scheduler schedule(IRunnable task)
    {
        return schedule(task, null);
    }

    public Scheduler schedule(IRunnable task, Runnable cancelTask)
    {
        m_cancelTask = cancelTask;
        m_timer.scheduleAtFixedRate(createTimerTask(task), m_delay, m_period);

        return this;
    }

    public final void cancel()
    {
        m_timer.cancel();

        if (m_cancelTask != null)
            m_cancelTask.run();
    }
}
