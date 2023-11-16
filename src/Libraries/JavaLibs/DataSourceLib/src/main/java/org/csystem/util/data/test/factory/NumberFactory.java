package org.csystem.util.data.test.factory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class NumberFactory {
    private  final int [] m_numbers;

    private NumberFactory(int n)
    {
        m_numbers = new int[n];
    }

    public static NumberFactory loadFromTextFile(Path path) throws IOException
    {
        try (var bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            var countStr = bufferedReader.readLine();
            if (countStr == null)
                return new NumberFactory(0);

            var count = Integer.parseInt(countStr);
            var result = new NumberFactory(count);

            for (int i = 0; i < count; ++i)
                result.m_numbers[i] = Integer.parseInt(bufferedReader.readLine());

            return result;
        }
    }

    public int [] getNumbers()
    {
        return Arrays.copyOf(m_numbers, m_numbers.length);
    }
}
