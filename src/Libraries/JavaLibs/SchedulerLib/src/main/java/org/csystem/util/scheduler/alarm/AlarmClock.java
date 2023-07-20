/*----------------------------------------------------------------------
	FILE        : AlarmClock.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 20.07.2023

	Scheduler class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.scheduler.alarm;

import java.time.LocalTime;

public class AlarmClock {

    private AlarmClock(int hour, int minute, int second)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static AlarmClock of(LocalTime time)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static AlarmClock of(int hour, int minute)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static AlarmClock of(int hour, int minute, int second)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public AlarmClock start(Runnable alarmTask)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public AlarmClock start(Runnable alarmTask, Runnable periodTask)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void cancel()
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
