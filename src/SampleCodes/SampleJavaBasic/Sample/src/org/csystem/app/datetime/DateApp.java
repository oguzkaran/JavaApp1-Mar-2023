/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden gün ay ve yıl bilgisine ilişkin tarihin haftanın hangi gününe
	geldiği bilgisini aşağıdaki açıklamalara göre dmndüren getDayOfWeek isimli metodu yazınız ve test ediniz
	Açıklamalar:
		- Metot geçersiz bir tarih durumunda -1 değerine geri dönecektir
		- Haftanın günü 01.01.1900 ile verilen tarih arasındaki (bverilen tarih dahil) gün sayısının 7 ilem bölümünden
		elde edilen kalan ile belirlenebilir. Buna göre sıfır "pazar, 1 "pazartesi", 2 "salı" ... 6 "cumartesi" günlerine
		kaşılık gelir

		- 01.01.1900 öncesindeki tarihler geçersiz sayılacaktır

	(İleride daha iyisi yazılacaktır)
-----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.datetime;

import java.util.Scanner;

public class DateApp {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("Gün ay ve yıl bilgilerini giriniz:");
            int day = kb.nextInt();
            int month = kb.nextInt();
            int year = kb.nextInt();

            if (day == 0)
                break;

            DateUtil.printDateTR(day, month, year);
            DateUtil.printDateEN(day, month, year);
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
