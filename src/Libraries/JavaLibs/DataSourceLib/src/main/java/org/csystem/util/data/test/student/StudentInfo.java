package org.csystem.util.data.test.student;

public class StudentInfo {
    private String m_name;
    private int m_midtermGrade;
    private int m_finalGrade;
    private String m_lecture;

    public StudentInfo(String name, int midtermGrade, int finalGrade, String lecture)
    {
        m_name = name;
        m_midtermGrade = midtermGrade;
        m_finalGrade = finalGrade;
        m_lecture = lecture;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
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

    public String getLecture()
    {
        return m_lecture;
    }

    public void setLecture(String lecture)
    {
        m_lecture = lecture;
    }

    @Override
    public String toString()
    {
        return String.format("%s, %d, %d, %s", m_name, m_midtermGrade, m_finalGrade, m_lecture);
    }
}
