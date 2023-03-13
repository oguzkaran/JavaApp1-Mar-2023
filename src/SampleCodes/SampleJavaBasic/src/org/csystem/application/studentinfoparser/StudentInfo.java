package org.csystem.application.studentinfoparser;

import org.csystem.util.datetime.Date;

public class StudentInfo {
    private String m_name;
    private Date m_birthDate;
    private String m_lectureName;
    private int m_midtermGrade;
    private int m_finalGrade;

    //...


    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public Date getBirthDate()
    {
        return m_birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        m_birthDate = birthDate;
    }

    public String getLectureName()
    {
        return m_lectureName;
    }

    public void setLectureName(String lectureName)
    {
        m_lectureName = lectureName;
    }

    public int getMidtermGrade()
    {
        return m_midtermGrade;
    }

    public void setMidtermGrade(int midtermGrade)
    {
        m_midtermGrade = midtermGrade;
    }

    public int getFinalGrade()
    {
        return m_finalGrade;
    }

    public void setFinalGrade(int finalGrade)
    {
        m_finalGrade = finalGrade;
    }

    public double getGrade()
    {
        return m_midtermGrade * 0.4 + m_finalGrade * 0.6;
    }


    public String toString()
    {
        double grade = getGrade();

        String fmt = "{name: %s, birthDate: %s, lectureName: %s, midterm: %d, final: %d, grade:%.1f, status: %s}";

        return String.format(fmt, m_name, m_birthDate.toLongDateStringTR(), m_lectureName, m_midtermGrade, m_finalGrade, grade, grade >= 50 ? "Geçti" : "Kaldı");
    }
}
