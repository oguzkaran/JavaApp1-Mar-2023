/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyden aşağıdaki formatta alınan bilgiyi ayrıştırarak ekrana açıklamalarda belirtilen sonuçları
    yazdıran programı yazınız:
    	<ad soyad>:<ders adı>:<gg/aa/yyyy>:<gg/aa/yyyy>:<arasınav notu>:<final notu>
    	Alican Keçici:Evrim:29/04/2021:23/06/2022:78:97
    	Baturhan Şahin:Matematik:19/07/2023:31/12/2023:79:97
    	Oğuz Karan:Fonksiyonel Analiz:23/05/1997:26/06/1997:45:55
    	Bartu Çankaya:Termodinamik:15/01/2017:25/05/2017:04:21

    Açıklamalar:
    	- Format geçerlilik kontrolü yapılmayacaktır

    	- Arasınav ve final notlarına göre, arasınav * 0.4 + final * 0.6 formülü ile geçme notu hesapğlanacak ve sınav
    	tarihleri hangi güne geldiği bilgisi ile Türkçe olarak yazdırılacaktır

    	- Notu 50+ olan öğrenciler geçmiş olacaklardır

    	- Geçme notu ceil metodu ile tamsayı olarak elde edilecektir

    	- Örnek çıktı aşağıdaki gibi olacaktır
    		----------------------------------------------------------------
    		Adı Soyadı: Alican Keçici
    		Ders Adı: Evrim
    		Arasınav Tarihi: 29 Nisan 2021 Perşembe
    		Final Tarihi: 23 Haziran 2022 Perşembe
    		Arasınav Notu: 78
    		Final Notu: 97
    		Geçme Notu: 90
    		Sonuç: Geçti
    		----------------------------------------------------------------
    	Not: İleride daha iyisi yazılacaktır
-----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.university;

import java.util.Scanner;

public class GradeInfoApp {
    private static void printReport(GradeInfo gradeInfo)
    {
        int grade = gradeInfo.getTotalGrade();

        System.out.println("----------------------------------------------------------------");
        System.out.printf("Adı Soyadı: %s%n", gradeInfo.getStudentName());
        System.out.printf("Ders Adı: %s%n", gradeInfo.getLectureName());
        System.out.printf("Arasınav Tarihi: %s%n", gradeInfo.getMidtermDate());
        System.out.printf("Final Tarihi: %s%n", gradeInfo.getFinalDate());
        System.out.printf("Arasınav Notu: %d%n", gradeInfo.getMidtermGrade());
        System.out.printf("Final Notu: %d%n", gradeInfo.getFinalGrade());
        System.out.printf("Geçme Notu: %d%n", grade);
        System.out.printf("Sonuç:%s%n", grade >= 50 ? "Geçti" : "Kaldı");
        System.out.println("----------------------------------------------------------------");
    }

    private static void run()
    {
        Scanner kb = new Scanner(System.in);

        while (true) {
            System.out.print("Formatlı yazıyı giriniz:");
            String str = kb.nextLine().strip();

            if ("elma".equals(str))
                break;

            GradeInfoParser parser = new GradeInfoParser(str);

            printReport(parser.getGradeInfo());
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
