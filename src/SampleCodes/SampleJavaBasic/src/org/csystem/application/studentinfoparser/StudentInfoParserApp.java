/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Klavyeden aşağıdak formatta girilen bilgiyi ayrıştırarak ekrana sonuçları yazdıran programı yazınız:
	<isim>:<gg/aa/yyyy>:<ders adı>:<vize>:<final>
	Oğuz Karan:10/09/1976:Matematik:54:78
	Büşra Uludağ Polat:09/08/1994:Programlamaya Giriş:89:100
	Furkan Genç:02/11/2006:Tarih:78:98
	Oğuz Karan:10/09/1976:Kimya:55:20
	Açıklamalar:
	- Format geçerlilik kontrolü yapılmayacaktır
	- Formatta kişinin vize ve final notlarına göre vize * 0.4 + final * 0.6 formülüne göre geçme notu hesaplanacak
	ve doğum tarihinin hangi güne geldiği de belirlenerek ekrana geçti-kaldı bilgisiyle beraber yazılacaktır
	- Geçme notu >= 50 ise öğrenci geçecek, değilse kalacaktır
	- İleride daha iyisi yazılacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.application.studentinfoparser;

import java.util.Scanner;

public class StudentInfoParserApp {
    private StudentInfoParserApp()
    {
    }

    public static void run()
    {
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("Formatlı yazıyı giriniz:");
            String str = kb.nextLine();

            if ("elma".equals(str))
                break;

            StudentInfoParser parser = new StudentInfoParser(str);
            StudentInfo studentInfo = parser.getStudentInfo();

            System.out.println(studentInfo.toString());
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}
