package org.csystem.util.data.test.factory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class NameFactory {
    public final List<String> NAMES = new ArrayList<>();

    private NameFactory()
    {
    }

    public static NameFactory loadFromTextFile(Path path) throws IOException
    {
        try (var bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            var result = new NameFactory();

            String name;

            while ((name = bufferedReader.readLine()) != null)
                result.NAMES.add(name);

            return result;
        }
    }

    //...
}
