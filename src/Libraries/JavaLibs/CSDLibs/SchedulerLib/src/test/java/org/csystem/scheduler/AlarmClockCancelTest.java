package org.csystem.scheduler;

import org.csystem.util.concurrent.ThreadUtil;
import org.csystem.util.scheduler.alarm.AlarmClock;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;


@Ignore
public class AlarmClockCancelTest {
    private static void alarmTaskCallback()
    {
        System.out.println("Alarm");
    }

    private static void periodTaskCallback()
    {
        System.out.print(".");
    }

    @Test
    public void test()
    {
        var time = LocalTime.now().plusSeconds(10);

        System.out.println(time);

        var alarm = AlarmClock.of(time).start(AlarmClockCancelTest::alarmTaskCallback, AlarmClockCancelTest::periodTaskCallback);

        ThreadUtil.sleep(5, TimeUnit.SECONDS);

        alarm.cancel();
    }
}
