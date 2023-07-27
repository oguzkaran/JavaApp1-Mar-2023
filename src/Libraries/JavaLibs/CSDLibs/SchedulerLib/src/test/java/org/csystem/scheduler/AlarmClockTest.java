package org.csystem.scheduler;

import org.csystem.util.concurrent.ThreadUtil;
import org.csystem.util.scheduler.alarm.AlarmClock;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@Ignore
public class AlarmClockTest {
    @Test
    public void test()
    {
        var time = LocalTime.now().plusSeconds(20);
        System.out.println(time);

        AlarmClock.of(time).start(() -> System.out.println("Alarm"), () -> System.out.print("."));

        ThreadUtil.sleep(21, TimeUnit.SECONDS);
    }
}
