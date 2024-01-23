package org.csystem.simulation.exam;

import org.csystem.util.array.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

public class ExamSimulation {
    private final String m_lectureName;
    private int [][] m_grades;
    private double m_average;
    private double [] m_averages;
    private int [] m_minGrades;
    private int [] m_maxGrades;
    private final Random m_random;

    private void fillGrades()
    {
        Scanner kb = new Scanner(System.in);
        System.out.printf("%s dersi için şube sayısını giriniz:", m_lectureName);
        m_grades = new int[Integer.parseInt(kb.nextLine())][];

        for (int i = 0; i < m_grades.length; ++i) {
            System.out.printf("%d.şubenin öğrenci sayısını giriniz:", i + 1);
            m_grades[i] = ArrayUtil.getRandomArray(m_random, Integer.parseInt(kb.nextLine()), 0, 101);
        }

        m_averages = new double[m_grades.length];
        m_minGrades = new int[m_grades.length];
        m_maxGrades = new int[m_grades.length];
    }

    private void findAverages()
    {
        int numberOfAllStudents = 0;
        int totalGrades = 0;

        for (int i = 0; i < m_grades.length; ++i) {
            int total = ArrayUtil.sum(m_grades[i]);

            numberOfAllStudents += m_grades[i].length;
            totalGrades += total;
            m_averages[i] = (double)total / m_grades[i].length;
            m_minGrades[i] = ArrayUtil.min(m_grades[i]);
            m_maxGrades[i] = ArrayUtil.max(m_grades[i]);
        }

        m_average = (double)totalGrades / numberOfAllStudents;
    }

    public ExamSimulation(String name, Random random)
    {
        m_lectureName = name;
        m_random = random;
    }

    public String getLectureName()
    {
        return m_lectureName;
    }

    public int getGrade(int i, int k)
    {
        return m_grades[i][k];
    }

    public double getAverage()
    {
        return m_average;
    }

    public double getAverage(int i)
    {
        return m_averages[i];
    }

    public int getMinGrade(int i)
    {
        return m_minGrades[i];
    }

    public int getMaxGrade(int i)
    {
        return m_maxGrades[i];
    }

    public void run()
    {
        fillGrades();
        findAverages();
    }

    public void displayGrades()
    {
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("%s dersinin şubelere göre notları:%n", m_lectureName);
        for (int i = 0; i < m_grades.length; ++i) {
            System.out.printf("%d.şube notları:", i + 1);
            ArrayUtil.print(m_grades[i]);
        }
        System.out.println("----------------------------------------------------------------------");
    }

    public void displayReport()
    {
        System.out.println("#########################################################################");
        displayGrades();
        int n = m_grades.length;

        for (int i = 0; i < n; ++i) {
            System.out.printf("%d.şube:%n", i + 1);
            System.out.printf("Not Ortalaması:%f%n", m_averages[i]);
            System.out.printf("En yüksek Not:%d%n", m_maxGrades[i]);
            System.out.printf("En düşük Not:%d%n", m_minGrades[i]);
        }
        System.out.printf("Okul Ortalaması:%f%n", m_average);
        System.out.println("#########################################################################");
    }
}

