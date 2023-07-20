package org.csystem.scheduler;

import org.csystem.util.concurrent.ThreadUtil;
import org.csystem.util.scheduler.alarm.AlarmClock;
import org.csystem.util.scheduler.alarm.AlarmClockStatus;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@Ignore
public class AlarmClockDailyTest {
    @Test
    public void test()
    {
        var time = LocalTime.now().plusSeconds(20);

        System.out.println(time);

        AlarmClock.of(time).start(() -> System.out.println("Alarm"), () -> System.out.print("."), AlarmClockStatus.DAILY);

        ThreadUtil.sleep(25, TimeUnit.SECONDS);
    }
}
