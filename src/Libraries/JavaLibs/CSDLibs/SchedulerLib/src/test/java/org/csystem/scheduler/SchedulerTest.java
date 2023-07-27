package org.csystem.scheduler;

import org.csystem.util.concurrent.ThreadUtil;
import org.csystem.util.scheduler.Scheduler;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

@Ignore
public class SchedulerTest {
    private int m_counter;
    private void schedulerCallback()
    {
        ++m_counter;
        System.out.printf("%d ", m_counter);
    }

    @Test
    public void test()
    {
        var scheduler = new Scheduler(1, TimeUnit.SECONDS)
                .schedule(() -> schedulerCallback(), () -> System.out.println("\nCancelled"));

        ThreadUtil.sleep(10, TimeUnit.SECONDS);
        scheduler.cancel();
        Assert.assertTrue(11 == m_counter || 10 == m_counter);
    }
}
