/*----------------------------------------------------------------------
	FILE        : StopWatch.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 13.04.2023

	StopWatch utility class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.datetime.stopwatch;

import java.util.concurrent.TimeUnit;

public class StopWatch {
    private long m_start;
    private long m_stop;

    public static StopWatch of()
    {
        return new StopWatch();
    }

    public void start()
    {
        m_start = System.nanoTime();
    }

    public void stop()
    {
        m_stop = System.nanoTime();
    }

    public long elapsed(TimeUnit timeUnit)
    {
        return timeUnit.convert(m_stop - m_start, TimeUnit.NANOSECONDS);
    }

    public long elapsedInMillis()
    {
        return elapsed(TimeUnit.MILLISECONDS);
    }

    public long elapsedInNano()
    {
        return m_stop - m_start;
    }

    public long elapsedInSecond()
    {
        return elapsed(TimeUnit.SECONDS);
    }

    public double totalSeconds()
    {
        return elapsedInNano() / 1_000_000_000.;
    }

    //...
}
