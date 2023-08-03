/*----------------------------------------------------------------------
	FILE        : RandomPeriodicTextGenerator.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 03.08.2023

	RandomPeriodicTextGenerator class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.generator.random;

import org.csystem.generator.random.function.IConsumer;
import org.csystem.util.scheduler.Scheduler;
import org.csystem.util.string.StringUtil;

import java.util.random.RandomGenerator;

public class RandomPeriodicTextGenerator {
    private final RandomGenerator m_randomGenerator;
    private final Scheduler m_scheduler;
    private final int m_min, m_bound;
    private final int m_count;
    private int m_n;

    private void generateSchedulerCallback(IConsumer<String> consumer) throws Exception
    {
        var str = StringUtil.getRandomTextEN(m_randomGenerator, m_randomGenerator.nextInt(m_min, m_bound));

        consumer.accept(str);
        if (--m_n == 0)
            m_scheduler.cancel();
    }
    public RandomPeriodicTextGenerator(RandomGenerator randomGenerator, int min, int bound, int count, long period)
    {
        this(randomGenerator, min, bound, count, 0, period);
    }

    public RandomPeriodicTextGenerator(RandomGenerator randomGenerator, int min, int bound, int count, long delay, long period)
    {
        m_randomGenerator = randomGenerator;
        m_scheduler = new Scheduler(delay, period);
        m_min = min;
        m_bound = bound;
        m_count = count;
    }

    public void generate(IConsumer<String> consumer)
    {
        m_n = m_count;
        m_scheduler.schedule(() -> generateSchedulerCallback(consumer));
    }
}
