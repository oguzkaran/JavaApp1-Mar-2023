package org.csystem.application.calculatesumcountminmaxaverage;

public class SumCountMaxMinAverage {
	private int m_sum;
	private int m_count;
	private int m_min;
	private int m_max;

	public void sum(int val)
	{
		m_sum += val;
		++m_count;
		if (val < m_min)
			m_min = val;

		if (m_max < val)
			m_max = val;
	}

	public double getAverage()
	{
		return (double)m_sum / m_count;
	}

	public int getSum()
	{
		return m_sum;
	}

	public int getCount()
	{
		return m_count;
	}

	public int getMin()
	{
		return m_min;
	}

	public int getMax()
	{
		return m_max;
	}

	public String toString()
	{
		return String.format("{sum: %d, count: %d, min: %d, max: %d, avg: %f}",
				m_sum, m_count, m_min, m_max, getAverage());
	}
}