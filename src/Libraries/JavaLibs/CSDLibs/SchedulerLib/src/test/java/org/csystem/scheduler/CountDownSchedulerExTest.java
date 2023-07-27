package org.csystem.scheduler;

import org.csystem.util.scheduler.CountDownSchedulerEx;
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
public class CountDownSchedulerExTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        long millisInFuture;
        long interval;
        long expected;

        public DataInfo(long millisInFuture, long interval, long expected)
        {
            this.millisInFuture = millisInFuture;
            this.interval = interval;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo(4000, 1000, 1000), new DataInfo(5000, 1000, 1000));
    }

    public CountDownSchedulerExTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenTotalTimeAndInterval_whenBothLong_thenSchedule() throws InterruptedException
    {
        new CountDownSchedulerEx(m_dataInfo.millisInFuture, m_dataInfo.interval) {
            long value = m_dataInfo.millisInFuture;

            @Override
            protected void onStart()
            {
                Assert.assertEquals(m_dataInfo.millisInFuture, value);
                System.out.println("Started");
            }

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
        }.startScheduler();

        TimeUnit.SECONDS.sleep(TimeUnit.MILLISECONDS.toSeconds(m_dataInfo.millisInFuture));
    }
}
