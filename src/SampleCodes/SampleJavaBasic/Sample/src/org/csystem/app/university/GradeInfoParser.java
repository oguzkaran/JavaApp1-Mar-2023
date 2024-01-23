package org.csystem.app.university;

import org.csystem.app.datetime.DateUtil;

public class GradeInfoParser {
    private final GradeInfo m_gradeInfo;

    public static String getDateStr(String str)
    {
        String [] dateInfo = str.split("[/]");

        int day = Integer.parseInt(dateInfo[0]);
        int month = Integer.parseInt(dateInfo[1]);
        int year = Integer.parseInt(dateInfo[2]);

        return DateUtil.getDateStrTR(day, month, year);
    }

    public GradeInfoParser(String dataStr)
    {
        //...
        String [] gradeInfoStr = dataStr.split("[:]+");

        //...

        m_gradeInfo = new GradeInfo();

        m_gradeInfo.setStudentName(gradeInfoStr[0]);
        m_gradeInfo.setLectureName(gradeInfoStr[1]);
        m_gradeInfo.setMidtermDate(getDateStr(gradeInfoStr[2]));
        m_gradeInfo.setFinalDate(getDateStr(gradeInfoStr[3]));
        m_gradeInfo.setMidtermGrade(Integer.parseInt(gradeInfoStr[4]));
        m_gradeInfo.setFinalGrade(Integer.parseInt(gradeInfoStr[5]));
    }

    public GradeInfo getGradeInfo()
    {
        return m_gradeInfo;
    }
}
