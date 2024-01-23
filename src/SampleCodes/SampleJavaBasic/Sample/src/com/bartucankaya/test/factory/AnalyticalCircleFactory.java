package com.bartucankaya.test.factory;

import com.bartucankaya.AnalyticalCircle;

import java.util.Random;

public class AnalyticalCircleFactory {
    private final Random m_random = new Random();

    public AnalyticalCircle createRandomAnalyticalCircle(double min, double bound)
    {
        return new AnalyticalCircle(m_random.nextDouble(min, bound), m_random.nextDouble(min, bound), m_random.nextDouble(min, bound));
    }
}
