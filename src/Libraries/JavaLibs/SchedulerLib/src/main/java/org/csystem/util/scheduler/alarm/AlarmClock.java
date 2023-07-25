/*----------------------------------------------------------------------
	FILE        : AlarmClock.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 25.07.2023

	AlarmClock class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.scheduler.alarm;

import org.csystem.util.scheduler.Scheduler;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import static org.csystem.util.scheduler.alarm.AlarmClockStatus.DAILY;
import static org.csystem.util.scheduler.alarm.AlarmClockStatus.ONCE;

public class AlarmClock {
    private final Scheduler m_scheduler;
    private final LocalTime m_time;

    private void schedulerTaskCallback(Runnable alarmTask, Runnable periodTask, AlarmClockStatus alarmClockStatus)
    {
        if (periodTask != null)
            periodTask.run();

        var now = LocalTime.now();

        now = now.withNano(0);

        if (now.equals(m_time)) {
            if (alarmClockStatus == ONCE)
                m_scheduler.cancel();
            alarmTask.run();
        }
    }

    private AlarmClock(LocalTime time)
    {
        m_scheduler = new Scheduler(1, TimeUnit.SECONDS);
        m_time =  time.withNano(0);
    }

    public static AlarmClock of(LocalTime time)
    {
        return new AlarmClock(time);
    }

    public static AlarmClock of(int hour, int minute)
    {
        return of(hour, minute, 0);
    }

    public static AlarmClock of(int hour, int minute, int second)
    {
        return of(LocalTime.of(hour, minute, second));
    }

    public AlarmClock start(Runnable alarmTask)
    {
        return start(alarmTask, null, ONCE);
    }

    public AlarmClock start(Runnable alarmTask, Runnable periodTask)
    {
        return start(alarmTask, periodTask, ONCE);
    }

    public AlarmClock start(Runnable alarmTask, AlarmClockStatus alarmClockStatus)
    {
        return start(alarmTask, null, alarmClockStatus);
    }

    public AlarmClock start(Runnable alarmTask, Runnable periodTask, AlarmClockStatus alarmClockStatus)
    {
        m_scheduler.schedule(() -> schedulerTaskCallback(alarmTask, periodTask, alarmClockStatus));
        return this;
    }

    public void cancel()
    {
        m_scheduler.cancel();
    }
}
