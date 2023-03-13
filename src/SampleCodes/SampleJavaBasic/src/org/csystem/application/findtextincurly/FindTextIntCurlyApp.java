/*---------------------------------------------------------------------------------------------------------------------- 	 
	Homework-008-1. sorunun bir çözümü
	Dikkat: IntelliJ IDEA IDE uygulamasının console'u ile test ederken yazıyı değiştirmek genellikle hatalı yazı yazılmasına
	yol açar. Bunun için aşağıdali örnek yazıları da kopyalayıp yapıtırabilirsiniz
	
	 - Bu örnek {aslında {hiç zor}} değil
	 - Bu örnekten {daha {zor {örnekler de yapacağız} değil}} mi?
	 - Yanlış {bir giriş için hata mesajı yazdırılacak
	 - Bu örnekten {daha
	 - Bu örnekten daha zor } örnekler
	 - {test}
	 - {{test}}
	 - {}
	(ileride daha iyisi yazılacaktır)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.application.findtextincurly;

import java.util.Scanner;

class FindTextIntCurlyApp {
	private FindTextIntCurlyApp()
	{
	}

	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		
		for (;;) {
			System.out.print("Bir yazı giriniz:");
			String str = kb.nextLine();
			
			if ("elma".equals(str))
				break;
			
			FindTextInCurly findTextInCurly = new FindTextInCurly(str);
			
			findTextInCurly.findText();
			
			System.out.println(findTextInCurly.isValid() ? findTextInCurly.getResult() : "yanlış bir giriş");
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}
