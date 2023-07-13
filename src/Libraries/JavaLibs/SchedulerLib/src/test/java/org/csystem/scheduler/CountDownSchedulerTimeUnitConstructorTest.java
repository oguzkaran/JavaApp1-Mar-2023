package org.csystem.scheduler;

import org.csystem.util.scheduler.CountDownScheduler;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
@Ignore
public class CountDownSchedulerTimeUnitConstructorTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        long durationInFuture;
        long interval;

        TimeUnit timeUnit;
        long expected;

        public DataInfo(long durationInFuture, long interval, TimeUnit timeUnit, long expected)
        {
            this.durationInFuture = durationInFuture;
            this.interval = interval;
            this.timeUnit = timeUnit;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo(4000, 1000, TimeUnit.MILLISECONDS, 1000),
                new DataInfo(5, 1, TimeUnit.SECONDS, 1000));
    }

    public CountDownSchedulerTimeUnitConstructorTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenTotalTimeAndIntervalAndTimeUnit_thenSchedule() throws InterruptedException
    {
        new CountDownScheduler(m_dataInfo.durationInFuture, m_dataInfo.interval, m_dataInfo.timeUnit) {
            long value = m_dataInfo.durationInFuture;

            @Override
            protected void onTick(long millisUntilFinished)
            {
                value = millisUntilFinished;
                System.out.printf("%02d%n", millisUntilFinished / 1000);
            }

            @Override
            protected void onFinish()
            {
                System.out.println("00");
                Assert.assertEquals(m_dataInfo.expected, value);
            }
        }.start();

        TimeUnit.SECONDS.sleep(m_dataInfo.timeUnit.toSeconds(m_dataInfo.durationInFuture));
    }
}
