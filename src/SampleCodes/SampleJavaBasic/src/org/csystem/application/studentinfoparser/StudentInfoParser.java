package org.csystem.application.studentinfoparser;

import org.csystem.util.datetime.Date;

public class StudentInfoParser {
    private final StudentInfo m_studentInfo;

    private static Date getBirthDate(String str)
    {
        String [] birthDateInfo = str.split("[/]");
        int day = Integer.parseInt(birthDateInfo[0]);
        int month = Integer.parseInt(birthDateInfo[1]);
        int year = Integer.parseInt(birthDateInfo[2]);

        return new Date(day, month, year);
    }


    public StudentInfoParser(String str)
    {
        /*
            <isim>:<gg/aa/yyyy>:<ders adı>:<vize>:<final>
	        Oğuz Karan:10/09/1976:Matematik:54:78
	        Büşra Uludağ Polat:09/08/1994:Programlamaya Giriş:89:100
	        Furkan Genç:02/11/2006:Tarih:78:98
        */

        String [] studentInfoStr = str.split("[:]+");

        //...

        m_studentInfo = new StudentInfo();
        m_studentInfo.setName( studentInfoStr[0]);
        m_studentInfo.setBirthDate(getBirthDate(studentInfoStr[1]));
        m_studentInfo.setLectureName(studentInfoStr[2]);
        m_studentInfo.setMidtermGrade(Integer.parseInt(studentInfoStr[3]));
        m_studentInfo.setFinalGrade(Integer.parseInt(studentInfoStr[4]));
    }

    public StudentInfo getStudentInfo()
    {
        return m_studentInfo;
    }
}
