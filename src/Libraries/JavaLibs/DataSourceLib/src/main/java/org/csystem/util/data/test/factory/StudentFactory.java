package org.csystem.util.data.test.factory;

import org.csystem.util.data.test.student.StudentInfo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class StudentFactory {
    private static final String[] ms_lectures = {"Matematik", "Fizik", "Kimya", "Biyoloji"};
    private static final Random m_random = new Random();
    public final List<StudentInfo> STUDENTS = new ArrayList<>();

    private static StudentInfo getPerson(String line)
    {
        var studentInfo = line.split("[,]");

        return new StudentInfo(studentInfo[0], Integer.parseInt(studentInfo[1]), Integer.parseInt(studentInfo[2]),
                ms_lectures[m_random.nextInt(ms_lectures.length)]);

    }

    private StudentFactory()
    {}

    public static StudentFactory loadFromTextFile(Path path) throws IOException
    {
        var result = new StudentFactory();

        try (var br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            br.readLine();

            String line;

            while ((line = br.readLine()) != null)
                result.STUDENTS.add(getPerson(line));
        }

        return result;
    }
}
