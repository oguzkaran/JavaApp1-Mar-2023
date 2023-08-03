/*----------------------------------------------------------------------
	FILE        : RandomPeriodicIntGenerator.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 03.08.2023

	RandomPeriodicIntGenerator class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.generator.random;

import org.csystem.generator.random.function.IIntConsumer;
import org.csystem.util.scheduler.Scheduler;

import java.util.random.RandomGenerator;

public class RandomPeriodicIntGenerator {
    private final RandomGenerator m_randomGenerator;
    private final Scheduler m_scheduler;
    private final int m_min, m_bound;
    private final int m_count;
    private int m_n;

    private void generateSchedulerCallback(IIntConsumer consumer) throws Exception
    {
        var value = m_randomGenerator.nextInt(m_min, m_bound);

        consumer.accept(value);
        if (--m_n == 0)
            m_scheduler.cancel();
    }

    public RandomPeriodicIntGenerator(RandomGenerator randomGenerator, int min, int bound, int count, long period)
    {
        this(randomGenerator, min, bound, count, 0, period);
    }
    public RandomPeriodicIntGenerator(RandomGenerator randomGenerator, int min, int bound, int count, long delay, long period)
    {
        m_randomGenerator = randomGenerator;
        m_scheduler = new Scheduler(delay, period);
        m_min = min;
        m_bound = bound;
        m_count = count;
    }

    public void generate(IIntConsumer consumer)
    {
        m_n = m_count;
        m_scheduler.schedule(() -> generateSchedulerCallback(consumer));
    }
}
