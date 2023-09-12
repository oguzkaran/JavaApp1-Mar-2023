/*----------------------------------------------------------------------
	FILE        : RandomPeriodicLongGenerator.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 03.08.2023

	RandomPeriodicLongGenerator class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.generator.random;

import org.csystem.generator.random.function.ILongConsumer;
import org.csystem.util.scheduler.Scheduler;

import java.util.random.RandomGenerator;

public class RandomPeriodicLongGenerator {
    private final RandomGenerator m_randomGenerator;
    private final Scheduler m_scheduler;
    private final long m_min, m_bound;
    private final int m_count;
    private int m_n;

    private void generateSchedulerCallback(ILongConsumer consumer) throws Exception
    {
        var value = m_randomGenerator.nextLong(m_min, m_bound);

        consumer.accept(value);
        if (--m_n == 0)
            m_scheduler.cancel();
    }

    public RandomPeriodicLongGenerator(RandomGenerator randomGenerator, long min, long bound, int count, long period)
    {
        this(randomGenerator, min, bound, count, 0, period);
    }
    public RandomPeriodicLongGenerator(RandomGenerator randomGenerator, long min, long bound, int count, long delay, long period)
    {
        m_randomGenerator = randomGenerator;
        m_scheduler = new Scheduler(delay, period);
        m_min = min;
        m_bound = bound;
        m_count = count;
    }

    public void generate(ILongConsumer consumer)
    {
        m_n = m_count;
        m_scheduler.schedule(() -> generateSchedulerCallback(consumer));
    }
}
