/*----------------------------------------------------------------------
	FILE        : RandomPeriodicDoubleGenerator.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 03.08.2023

	RandomPeriodicDoubleGenerator class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.generator.random;

import org.csystem.generator.random.function.IDoubleConsumer;
import org.csystem.util.scheduler.Scheduler;

import java.util.random.RandomGenerator;

public class RandomPeriodicDoubleGenerator {
    private final RandomGenerator m_randomGenerator;
    private final Scheduler m_scheduler;
    private final double m_min, m_bound;
    private final int m_count;
    private int m_n;

    private void generateSchedulerCallback(IDoubleConsumer consumer) throws Exception
    {
        var value = m_randomGenerator.nextDouble(m_min, m_bound);

        consumer.accept(value);
        if (--m_n == 0)
            m_scheduler.cancel();
    }

    public RandomPeriodicDoubleGenerator(RandomGenerator randomGenerator, double min, double bound, int count, long period)
    {
        this(randomGenerator, min, bound, count, 0, period);
    }

    public RandomPeriodicDoubleGenerator(RandomGenerator randomGenerator, double min, double bound, int count, long delay, long period)
    {
        m_randomGenerator = randomGenerator;
        m_scheduler = new Scheduler(delay, period);
        m_min = min;
        m_bound = bound;
        m_count = count;
    }

    public void generate(IDoubleConsumer consumer)
    {
        m_n = m_count;
        m_scheduler.schedule(() -> generateSchedulerCallback(consumer));
    }
}
