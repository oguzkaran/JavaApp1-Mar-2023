package org.csystem.app.factory.random;

import org.csystem.math.Complex;
import org.csystem.math.Fraction;
import org.csystem.math.geometry.Point;
import org.csystem.util.array.ArrayUtil;
import org.csystem.util.string.StringUtil;

import java.util.random.RandomGenerator;

public class RandomObjectFactory {
    private final RandomGenerator m_randomGenerator;

    public RandomObjectFactory(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    //String, int [], Point, Complex, Fraction,
    public Object create()
    {
        return switch (m_randomGenerator.nextInt(6)) {
            case 0 -> StringUtil.getRandomTextEN(m_randomGenerator, m_randomGenerator.nextInt(5, 11));
            case 1 -> ArrayUtil.getRandomArray(m_randomGenerator, m_randomGenerator.nextInt(5, 11), 0, 100);
            case 2 -> Point.createCartesian(m_randomGenerator.nextDouble(-100, 100), m_randomGenerator.nextDouble(-100, 100));
            case 3 -> new Complex(m_randomGenerator.nextDouble(-10, 10), m_randomGenerator.nextDouble(-10, 10));
            case 4 -> m_randomGenerator.nextInt(-128, 127);
            default -> new Fraction(m_randomGenerator.nextInt(-10, 10), m_randomGenerator.nextInt(1, 10));
        };
    }
}
