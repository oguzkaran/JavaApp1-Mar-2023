package org.csystem.app.factory.random;

import org.csystem.util.string.StringUtil;

import java.util.Optional;
import java.util.random.RandomGenerator;

public class RandomPasswordFactory {
    private final RandomGenerator m_randomGenerator;

    public RandomPasswordFactory(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    public Optional<String> createPassword(int min, int bound)
    {
        return Optional.ofNullable(min > bound || min <= 0 ? null : StringUtil.getRandomTextEN(m_randomGenerator, m_randomGenerator.nextInt(min, bound)));
    }

    public Optional<String> createPassword(int count)
    {
        return Optional.ofNullable(count <= 0 ? null : StringUtil.getRandomTextEN(m_randomGenerator, count));
    }
}
