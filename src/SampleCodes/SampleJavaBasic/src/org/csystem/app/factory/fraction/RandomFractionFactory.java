package org.csystem.app.factory.fraction;

import org.csystem.util.math.Fraction;

import java.util.Random;

public class RandomFractionFactory {
	private final Random m_random;

	public RandomFractionFactory()
	{
		this(new Random());
	}

	public RandomFractionFactory(Random random)
	{
		m_random = random;
	}

	public Fraction getRandomFraction(int min, int max)
	{
		return new Fraction(m_random.nextInt(max - min) + min, m_random.nextInt(max - min) + min);
	}
}

