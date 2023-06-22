package org.csystem.util.recursion;

import java.util.Arrays;

public class StandardDeviationInfo {
    private final double m_standardDeviation;
    private final double m_mean;

    private final int [] m_data;

    public StandardDeviationInfo(double standardDeviation, double mean, int[] data)
    {
        m_standardDeviation = standardDeviation;
        m_mean = mean;
        m_data = Arrays.copyOf(data, data.length);
    }

    public double getStandardDeviation()
    {
        return m_standardDeviation;
    }

    public double getMean()
    {
        return m_mean;
    }

    public int get(int index)
    {
        return m_data[index];
    }
}
