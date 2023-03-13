/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden gün, ay ve yıl bilgilerine ilişkin tarihin aşağıdaki açıklamalara
	göre haftanın hangi gününe geldiğini döndüren getDayOfWeek isimli metodu yazınız ve aşağıdaki kod ile test ediniz
	Açıklamalar:
		- Metot geçersiz bir tarih durumunda -1 değerine geri dönecektir
		- Haftanın günü 1.1.1900 ile verilen tariharasındaki (verilen tarih dahil) gün sayısının 7(yedi) ile bölümünden
		elde edilen kalan ile bulunabilir. Değer 0(sıfır) ise "Pazar", 1(bir) ise "Pazartesi", ... 6(altı) ise "Cumartesi"
		günlerine karşılık gelir
		- 1.1.1900 öncesindeki tarihler geçersizler kabul edilir
		- Parametresi ile aldığı gün, ay ve yıl bilgilerine ilişkin tarihin hafta sonu olup olmadığını test eden isWeekend
		ve hafta içi olup olmadığını test eden isWeekday metotlarını yazınız. Metotlar tarih geçerliliği kontrolü yapmayacaktır
		(İleride daha iyisi yazılacaktır)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.application.date;

import org.csystem.util.datetime.Date;
import org.csystem.util.datetime.Month;

public class DateApp {
	private DateApp()
	{
	}

	private static void displayDateTR(Date d)
	{
		System.out.println(d.toLongDateStringTR());
		System.out.println(d.isWeekend() ? "Bugün kurs var tekrar yaptınız mı?" : "Kurs günü yaklaşıyor. Tekrar yapmayı unutmayınız");
	}

	private static void displayDateEN(Date d)
	{
		System.out.println(d.toLongDateStringEN());
		System.out.println(d.isWeekend() ? "That is the course day. Did you review?" :
				"Course day is coming. Do not forget to review");
	}
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Gün?");
			int day = Integer.parseInt(kb.nextLine());
			
			if (day == 0)
				break;
			
			System.out.print("Ay?");
			int month = Integer.parseInt(kb.nextLine());
			
			System.out.print("Yıl?");
			int year = Integer.parseInt(kb.nextLine());

			Date date = new Date(day, month, year); //Geçersiz tarih durumu ileride ele alınacaktır

			displayDateTR(date);
			displayDateEN(date);
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
