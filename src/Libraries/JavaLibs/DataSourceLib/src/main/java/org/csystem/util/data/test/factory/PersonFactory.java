package org.csystem.util.data.test.factory;

import org.csystem.util.data.test.people.MaritalStatus;
import org.csystem.util.data.test.people.Person;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class PersonFactory {
    private static final MaritalStatus[] ms_status = MaritalStatus.values();
    private static final Random m_random = new Random();
    public final List<Person> PEOPLE = new ArrayList<>();

    private static Person getPerson(String line)
    {
        var peopleInfo = line.split("[,]");

        return new Person()
                .setId(Integer.parseInt(peopleInfo[0]))
                .setName(peopleInfo[1])
                .setGender(peopleInfo[2])
                .setBirthDate(peopleInfo[3])
                .setMaritalStatus(ms_status[m_random.nextInt(ms_status.length)]);
    }

    private PersonFactory()
    {}

    public static PersonFactory loadFromTextFile(Path path) throws IOException
    {
        var result = new PersonFactory();

        try (var br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;

            while ((line = br.readLine()) != null)
                result.PEOPLE.add(getPerson(line));
        }

        return result;
    }

    public Person [] getPeopleAsArray()
    {
        return PEOPLE.toArray(new Person[0]);
    }
}
