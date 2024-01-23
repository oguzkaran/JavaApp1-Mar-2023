package org.csystem.app.university;

public class GradeInfo {
    private String m_studentName;
    private String m_lectureName;
    private String m_midtermDate;
    private String m_finalDate;
    private int m_midtermGrade;
    private int m_finalGrade;

    //...


    public String getStudentName()
    {
        return m_studentName;
    }

    public void setStudentName(String studentName)
    {
        m_studentName = studentName;
    }

    public String getLectureName()
    {
        return m_lectureName;
    }

    public void setLectureName(String lectureName)
    {
        m_lectureName = lectureName;
    }

    public String getMidtermDate()
    {
        return m_midtermDate;
    }

    public void setMidtermDate(String midtermDate)
    {
        m_midtermDate = midtermDate;
    }

    public String getFinalDate()
    {
        return m_finalDate;
    }

    public void setFinalDate(String finalDate)
    {
        m_finalDate = finalDate;
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

    public int getTotalGrade()
    {
        return (int)Math.ceil(m_midtermGrade * 0.4 + m_finalGrade * 0.6);
    }

    //...
}
